package com.fick.smd.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.espertech.esper.client.EventBean;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockProps;

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
	public static void upStockProps(EventBean bean) {
		if (bean == null || bean.get("code") == null) {
			return;
		}
		String code = (String) bean.get("code");
		if (stockPropsToday.get(code) == null) {
			Map<StockPropType, Float> props = new HashMap<StockPropType, Float>();
			if (bean.get(Constants.RATE_MAX) != null && bean.get(Constants.RATE_MIN) != null) {
				float rateMax = (Float) bean.get(Constants.RATE_MAX);
				float rateMin = (Float) bean.get(Constants.RATE_MIN);
				props.put(StockPropType.RATE_MAX, rateMax);
				props.put(StockPropType.RATE_MIN, rateMin);
				float maxRate = rateMax - rateMin;
				if (rateMin > 0) {
					maxRate = rateMax;
				}
				if (rateMax < 0) {
					maxRate = 0 - rateMin;
				}
				props.put(StockPropType.MAX_RATE, maxRate);
			}
			if (bean.get(Constants.PRICE_MAX) != null) {
				props.put(StockPropType.PRICE_MAX, (Float) bean.get(Constants.PRICE_MAX));
			}
			if (bean.get(Constants.PRICE_MIN) != null) {
				props.put(StockPropType.PRICE_MIN, (Float) bean.get(Constants.PRICE_MIN));
			}
			if (bean.get(Constants.PRICE_TODAY_END) != null) {
				props.put(StockPropType.PRICE_TODAY_END, (Float) bean.get(Constants.PRICE_TODAY_END));
			}
			if (bean.get(Constants.PRICE_YESTERDAY) != null) {
				props.put(StockPropType.PRICE_YESTERDAY, (Float) bean.get(Constants.PRICE_YESTERDAY));
			}
			if (bean.get(Constants.PRICE_TODAY) != null) {
				props.put(StockPropType.PRICE_TODAY, (Float) bean.get(Constants.PRICE_TODAY));
			}
			stockPropsToday.put(code, props);
		} else {
			Map<StockPropType, Float> props = stockPropsToday.get(code);

			if (bean.get(Constants.PRICE_MAX) != null) {
				float priceMax = (Float) bean.get(Constants.PRICE_MAX);
				if (props.get(Constants.PRICE_MAX) == null) {
					props.put(StockPropType.PRICE_MAX, priceMax);
				} else if (priceMax > props.get(Constants.PRICE_MAX)) {
					props.put(StockPropType.PRICE_MAX, priceMax);
				}
			}
			if (bean.get(Constants.PRICE_MIN) != null) {
				float priceMin = (Float) bean.get(Constants.PRICE_MIN);
				if (props.get(Constants.PRICE_MIN) == null) {
					props.put(StockPropType.PRICE_MIN, priceMin);
				} else if (priceMin < props.get(Constants.PRICE_MIN)) {
					props.put(StockPropType.PRICE_MIN, priceMin);
				}
			}
			if (bean.get(Constants.RATE_MAX) != null && bean.get(Constants.RATE_MIN) != null) {
				float rateMax = (Float) bean.get(Constants.RATE_MAX);
				float rateMin = (Float) bean.get(Constants.RATE_MIN);
				props.put(StockPropType.RATE_MAX, rateMax);
				props.put(StockPropType.RATE_MIN, rateMin);
				float maxRate = rateMax - rateMin;
				if (rateMin > 0) {
					maxRate = rateMax;
				}
				if (rateMax < 0) {
					maxRate = 0 - rateMin;
				}
				if (props.get(Constants.MAX_RATE) == null) {
					props.put(StockPropType.MAX_RATE, maxRate);
				} else if (maxRate > props.get(Constants.MAX_RATE)) {
					props.put(StockPropType.MAX_RATE, maxRate);
				}
			}
			if (bean.get(Constants.PRICE_TODAY_END) != null) {
				float price = (Float) bean.get(Constants.PRICE_TODAY_END);
				if (props.get(Constants.PRICE_TODAY_END) == null) {
					props.put(StockPropType.PRICE_TODAY_END, price);
				} else if (price != props.get(Constants.PRICE_TODAY_END)) {
					props.put(StockPropType.PRICE_TODAY_END, price);
				}
			}
			stockPropsToday.put(code, props);
		}
	}

	/**
	 * 更新股票的涨跌振幅
	 * 
	 * @param bean
	 */
	public static void upStockMaxRate(EventBean bean) {
		if (bean == null || bean.get("code") == null) {
			return;
		}
		String code = (String) bean.get("code");
		if (stockPropsToday.get(code) == null) {
			Map<StockPropType, Float> props = new HashMap<StockPropType, Float>();
			if (bean.get(Constants.RATE_MAX) != null && bean.get(Constants.RATE_MIN) != null) {
				float rateMax = (Float) bean.get(Constants.RATE_MAX);
				float rateMin = (Float) bean.get(Constants.RATE_MIN);
				float maxRate = rateMax - rateMin;
				props.put(StockPropType.MAX_RATE, maxRate);
			}
			stockPropsToday.put(code, props);
		} else {
			Map<StockPropType, Float> props = stockPropsToday.get(code);
			if (bean.get(Constants.RATE_MAX) != null && bean.get(Constants.RATE_MIN) != null) {
				float rateMax = (Float) bean.get(Constants.RATE_MAX);
				float rateMin = (Float) bean.get(Constants.RATE_MIN);
				float maxRate = rateMax - rateMin;
				if (rateMin > 0) {
					maxRate = rateMax;
				}
				if (rateMax < 0) {
					maxRate = 0 - rateMin;
				}
				if (props.get(Constants.MAX_RATE) == null) {
					props.put(StockPropType.MAX_RATE, maxRate);
				} else if (maxRate > props.get(Constants.MAX_RATE)) {
					props.put(StockPropType.MAX_RATE, maxRate);
				}
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
}
