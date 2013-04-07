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
	 * 分析
	 * 
	 * @param stock
	 */
	public static void addToAnalysis(Stock stock) {
		StockAnalysisService.submitAnalysis(new StockAnalysisRunnableUnit(stock));
	}

	/**
	 * 发送给引擎
	 * 
	 * @param stock
	 */
	public static void sendToEsper(Stock stock) {
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
		// 判断余额是否足够
		if (stockStorage.getBalance() < StockStorageCommon.getBuyCostByNumAndPrice(stockStorage.getDealnum(), price)) {
			return null;
		}
		// 判断是否已经卖，如果，判断当前价格是否赚钱，如果赚钱，则可买，否则不可买
		if (StockStorageCommon.hasBeenSold(stockStorage)) {
			float soldEarning = StockStorageCommon.getSellEarningByNumAndPrice(stockStorage.getDealnum(), stockStorage.getSellprice());
			float buyCost = StockStorageCommon.getBuyCostByNumAndPrice(stockStorage.getDealnum(), price);
			if (soldEarning - buyCost >= stockStorage.getExpectearning()) {
				return stockStorage;
			} else {
				return null;
			}
		}
		// 两个条件：
		// 1.振幅是否已经达到预期且当前价格低于当前平均价格；
		// 2.当前价格低于当前平均价格一定值；
		if ((getMaxRate(StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_MAX), price,
				StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_YESTERDAY)) >= getAvgMaxRateByCode(code)
				* Constants.AMPLITUDE_RATE
				&& price < StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_AVG))
				|| (StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_AVG) - price >= Constants.PRICE_PRICEAVG)) {
			return stockStorage;
		}
		return null;
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
			// log.warn("股票代码:" + code + "目前没有可操作股票！");
			return null;
		}
		// 判断是否已卖，如果已卖，不能再卖
		if (StockStorageCommon.hasBeenSold(stockStorage)) {
			return null;
		}
		// 判断是否已经买，如果，判断当前价格是否赚钱，如果赚钱，则可卖，否则不可卖
		if (StockStorageCommon.hasBeenBought(stockStorage)) {
			float soldEarning = StockStorageCommon.getSellEarningByNumAndPrice(stockStorage.getDealnum(), price);
			float buyCost = StockStorageCommon.getBuyCostByNumAndPrice(stockStorage.getDealnum(), stockStorage.getBuyprice());
			if (soldEarning - buyCost >= stockStorage.getExpectearning()) {
				return stockStorage;
			} else {
				return null;
			}
		}
		// 两个条件：
		// 1.振幅是否已经达到预期且当前价格高于当前平均价格；
		// 2.当前价格比当前平均价格高出一定值；
		if ((getMaxRate(price, StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_MIN),
				StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_YESTERDAY)) >= getAvgMaxRateByCode(code)
				* Constants.AMPLITUDE_RATE
				&& price > StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_AVG))
				|| (price - StockPropsCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_AVG) >= Constants.PRICE_PRICEAVG)) {
			return stockStorage;
		}
		return null;
	}

	/**
	 * 根据最高价，最低价，昨日收盘价得到振幅
	 * 
	 * @param h
	 * @param l
	 * @param y
	 * @return
	 */
	public static float getMaxRate(float h, float l, float y) {
		return (h - l) * 100 / y;
	}
}
