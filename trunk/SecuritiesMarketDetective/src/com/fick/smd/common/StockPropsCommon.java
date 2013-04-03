package com.fick.smd.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fick.smd.agg.SmdAggregator;
import com.fick.smd.agg.SmdAggregatorAvg;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockProps;
import com.fick.smd.hibernate.formbean.stockbean.Stock;
import com.fick.smd.hibernate.formbean.stockbean.StockProps;

public class StockPropsCommon {
	// private static final Log log = LogFactory.getLog(StockPropsCommon.class);
	private static DaoMethodTemplate dmt = new DaoMethodTemplate();
	private static DaoImplStockProps rateDao = new DaoImplStockProps();

	private static Map<String, SmdAggregator> stockAggregatorMap = new HashMap<String, SmdAggregator>();

	private static Map<String, Map<StockPropType, Float>> stockPropsToday = new HashMap<String, Map<StockPropType, Float>>();

	/**
	 * 更新股票属性
	 * 
	 * @param bean
	 */
	public static void upStockProps(Stock stock) {
		String code = stock.getCode();
		SmdAggregator aggregatorAvg = stockAggregatorMap.get(code);
		if (aggregatorAvg == null) {
			aggregatorAvg = new SmdAggregatorAvg();
			stockAggregatorMap.put(code, aggregatorAvg);
		}
		aggregatorAvg.enter(stock);
		if (stockPropsToday.get(code) == null) {
			Map<StockPropType, Float> props = new HashMap<StockPropType, Float>();
			props.put(StockPropType.PRICE_MAX, stock.getPrice_highest());
			props.put(StockPropType.PRICE_MIN, stock.getPrice_lowest());
			props.put(StockPropType.PRICE_TODAY_END, stock.getPrice_current());
			props.put(StockPropType.PRICE_YESTERDAY, stock.getPrice_yesterday());
			props.put(StockPropType.PRICE_TODAY, stock.getPrice_today());
			props.put(StockPropType.PRICE_AVG, (Float) aggregatorAvg.getValue());
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
			props.put(StockPropType.PRICE_AVG, (Float) aggregatorAvg.getValue());
			stockPropsToday.put(code, props);
		}
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

	/**
	 * 保存股票属性
	 */
	public static void storeProps() {
		List<StockProps> rates = new ArrayList<StockProps>();
		StockProps rate;
		for (String key : stockPropsToday.keySet()) {
			Map<StockPropType, Float> props = stockPropsToday.get(key);
			rate = new StockProps();
			rate.setStockcode(key);
			if (props.get(StockPropType.PRICE_MAX) != null && props.get(StockPropType.PRICE_MIN) != null && props.get(StockPropType.PRICE_YESTERDAY) != null) {
				rate.setPricehighest(props.get(StockPropType.PRICE_MAX));
				rate.setPricelowest(props.get(StockPropType.PRICE_MIN));
				rate.setPriceyestoday(props.get(StockPropType.PRICE_YESTERDAY));
				rate.setMaxrate(StockCommon.getMaxRate(rate.getPricehighest(), rate.getPricelowest(), rate.getPriceyestoday()));
			}
			if (props.get(StockPropType.PRICE_TODAY) != null) {
				rate.setPricetoday(props.get(StockPropType.PRICE_TODAY));
			}
			if (props.get(StockPropType.PRICE_TODAY_END) != null) {
				rate.setPricetodayend(props.get(StockPropType.PRICE_TODAY_END));
			}
			rates.add(rate);
		}
		rateDao.setProps(rates);
		dmt.process(rateDao, 2);
	}
}
