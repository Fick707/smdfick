package com.fick.smd.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fick.smd.esper.input.InputAdapter;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockProps;
import com.fick.smd.hibernate.formbean.stockbean.Stock;
import com.fick.smd.work.StockAnalysisRunnableUnit;
import com.fick.smd.work.StockAnalysisService;

public class StockCommon {

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

}
