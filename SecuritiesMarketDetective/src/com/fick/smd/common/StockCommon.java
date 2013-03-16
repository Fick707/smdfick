package com.fick.smd.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.esper.input.InputAdapter;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockProps;
import com.fick.smd.hibernate.formbean.stockbean.Stock;
import com.fick.smd.hibernate.formbean.stockbean.StockStorage;
import com.fick.smd.work.StockAnalysisRunnableUnit;
import com.fick.smd.work.StockAnalysisService;

public class StockCommon {

	private static final Log log = LogFactory.getLog(StockCommon.class);

	private static Map<String, Float> avgMaxRateCurr = getAvgMaxRateCurr();

	private static Map<String, Map<StockPropType, Float>> stockPropsToday = new HashMap<String, Map<StockPropType, Float>>();

	private static boolean isWarn = Constants.IS_WARN_INIT;

	/**
	 * 设置提醒弹出框
	 * 
	 * @param warn
	 */
	public synchronized static void setIsWarn(boolean warn) {
		isWarn = warn;
	}

	/**
	 * 得到当前提醒状态
	 * 
	 * @return
	 */
	public static boolean getIsWarn() {
		return isWarn;
	}

	/**
	 * 更新股票属性
	 * 
	 * @param bean
	 */
	public static void upStockProps(Stock stock) {
		String code = stock.getCode();
		if (stockPropsToday.get(code) == null) {
			Map<StockPropType, Float> props = new HashMap<StockPropType, Float>();
			props.put(StockPropType.PRICE_MAX, stock.getPrice_highest());
			props.put(StockPropType.PRICE_MIN, stock.getPrice_lowest());
			props.put(StockPropType.PRICE_TODAY_END, stock.getPrice_current());
			props.put(StockPropType.PRICE_YESTERDAY, stock.getPrice_yesterday());
			props.put(StockPropType.PRICE_TODAY, stock.getPrice_today());
			props.put(StockPropType.PRICE_AVG, CommonUtils.getAvg(props.get(StockPropType.PRICE_AVG), stock.getPrice_current()));
			stockPropsToday.put(code, props);
		} else {
			Map<StockPropType, Float> props = stockPropsToday.get(code);

			float priceMax = stock.getPrice_highest();
			if (props.get(Constants.PRICE_MAX) == null) {
				props.put(StockPropType.PRICE_MAX, priceMax);
			} else if (priceMax > props.get(Constants.PRICE_MAX)) {
				props.put(StockPropType.PRICE_MAX, priceMax);
			}

			float priceMin = stock.getPrice_lowest();
			if (props.get(Constants.PRICE_MIN) == null) {
				props.put(StockPropType.PRICE_MIN, priceMin);
			} else if (priceMin < props.get(Constants.PRICE_MIN)) {
				props.put(StockPropType.PRICE_MIN, priceMin);
			}

			float price = stock.getPrice_current();
			if (props.get(Constants.PRICE_TODAY_END) == null) {
				props.put(StockPropType.PRICE_TODAY_END, price);
			} else if (price != props.get(Constants.PRICE_TODAY_END)) {
				props.put(StockPropType.PRICE_TODAY_END, price);
			}
			props.put(StockPropType.PRICE_AVG, CommonUtils.getAvg(props.get(StockPropType.PRICE_AVG), price));
			stockPropsToday.put(code, props);
		}
	}

	/**
	 * 得到今天分析所得的股票关键值，用于每天市后入库
	 * 
	 * @return
	 */
	public static Map<String, Map<StockPropType, Float>> getStockProps() {
		return stockPropsToday;
	}

	/**
	 * 根据从数据库中取得的数据，加载到Map对象中
	 * 
	 * @param rates
	 * @return
	 */
	private static Map<String, Float> getAvgMaxRateCurr() {

		DaoMethodTemplate dmt = new DaoMethodTemplate();
		DaoImplStockProps smrdao = new DaoImplStockProps();
		List rates = (List) dmt.process(smrdao, 1);
		Map<String, Float> curRates = new HashMap<String, Float>();
		Double temp;
		if (rates != null) {
			for (Object obj : rates) {
				Object[] objs = (Object[]) obj;
				temp = (Double) objs[1];
				curRates.put((String) objs[0], temp.floatValue());
			}
		}
		return curRates;
	}

	/**
	 * 根据股票代码，得到它当前的平均涨跌振幅
	 * 
	 * @param code
	 * @return
	 */
	public static Float getAvgMaxRateByCode(String code) {
		return avgMaxRateCurr.get(code) == null ? null : avgMaxRateCurr.get(code);
	}

	/**
	 * 根据股票代码和属性类型，得到指定股票当前的属性值；
	 * 
	 * @param code
	 * @param type
	 * @return
	 */
	public static Float getStockPropByCodeAndType(String code, StockPropType type) {
		Map<StockPropType, Float> props = stockPropsToday.get(code);
		if (props == null) {
			return null;
		}
		return props.get(type) == null ? null : props.get(type);
	}

	public static void dealNewStock(Stock stock) {
		StockAnalysisService.submitAnalysis(new StockAnalysisRunnableUnit(stock));
		InputAdapter.sendEvent(stock);
	}

	/**
	 * 判断指定的股票当前的价格是否可买
	 * 
	 * @param code
	 * @param price
	 * @return
	 */
	public static StockStorage isBuyOk(String code, float price) {
		StockStorage stockStorage = StockStorageCommon.getStockStorageByCode(code);
		// 判断是不是正在正常交易的股票
		if (stockStorage == null) {
			log.warn("股票代码:" + code + ",未开仓，请检查仓库状态！");
			return null;
		}
		// 判断是否已买，如果已买，不能再买
		if (StockStorageCommon.hasBeenBought(stockStorage)) {
			return null;
		}
		// 判断是否已经卖，如果，判断当前价格是否赚钱，如果赚钱，则可买，否则不可买
		if (StockStorageCommon.hasBeenSold(stockStorage)) {
			float soldEarning = StockStorageCommon.getSellCostByNumAndPrice(stockStorage.getDealnum(), stockStorage.getSellprice());
			float buyCost = StockStorageCommon.getBuyCostByNumAndPrice(stockStorage.getDealnum(), price);
			if (soldEarning - buyCost >= stockStorage.getExpectearning()) {
				return stockStorage;
			} else {
				return null;
			}
		}
		// 上面条件都不满足，则判断当前价格是不是在今日平均体格之下，这个条件用来测试，最终判断可能要根据当前振幅是不是达到预期低度
		if (price >= getStockPropByCodeAndType(code, StockPropType.PRICE_AVG)) {
			return null;
		}
		return stockStorage;
	}

	/**
	 * 判断指定的股票当前的价格是否可卖
	 * 
	 * @param code
	 * @param price
	 * @return
	 */
	public static StockStorage isSellOk(String code, float price) {
		StockStorage stockStorage = StockStorageCommon.getStockStorageByCode(code);
		// 判断是不是正在正常交易的股票
		if (stockStorage == null) {
			log.warn("股票代码:" + code + ",未开仓，请检查仓库状态！");
			return null;
		}
		// 判断是否有可操作股票
		if (stockStorage.getStocknum() <= 0) {
			return null;
		}
		// 判断是否已卖，如果已卖，不能再卖
		if (StockStorageCommon.hasBeenSold(stockStorage)) {
			return null;
		}
		// 判断是否已经买，如果，判断当前价格是否赚钱，如果赚钱，则可卖，否则不可卖
		if (StockStorageCommon.hasBeenBought(stockStorage)) {
			float soldEarning = StockStorageCommon.getSellCostByNumAndPrice(stockStorage.getDealnum(), price);
			float buyCost = StockStorageCommon.getBuyCostByNumAndPrice(stockStorage.getDealnum(), stockStorage.getBuyprice());
			if (soldEarning - buyCost >= stockStorage.getExpectearning()) {
				return stockStorage;
			} else {
				return null;
			}
		}
		// 上面条件都不满足，则判断当前价格是不是在今日平均体格之下，这个条件用来测试，最终判断可能要根据当前振幅是不是达到预期低度
		if (price <= getStockPropByCodeAndType(code, StockPropType.PRICE_AVG)) {
			return null;
		}
		return stockStorage;
	}
}
