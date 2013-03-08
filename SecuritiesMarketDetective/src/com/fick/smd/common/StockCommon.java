package com.fick.smd.common;

import java.util.HashMap;
import java.util.Map;

import com.espertech.esper.client.EventBean;

public class StockCommon {

	private static Map<String, Map<String, Float>> stockPropsToday = new HashMap<String, Map<String, Float>>();

	private static boolean isWarn = true;

	public synchronized static void setIsWarn(boolean warn) {
		isWarn = warn;
	}

	public static boolean getIsWarn() {
		return isWarn;
	}

	public static void upStockProps(EventBean bean) {
		if (bean == null || bean.get("code") == null) {
			return;
		}
		String code = (String) bean.get("code");
		if (stockPropsToday.get(code) == null) {
			Map<String, Float> props = new HashMap<String, Float>();
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
				props.put(Constants.MAX_RATE, maxRate);
			}
			if (bean.get(Constants.PRICE_MAX) != null) {
				props.put(Constants.PRICE_MAX, (Float) bean.get(Constants.PRICE_MAX));
			}
			if (bean.get(Constants.PRICE_MIN) != null) {
				props.put(Constants.PRICE_MIN, (Float) bean.get(Constants.PRICE_MIN));
			}
			if (bean.get(Constants.PRICE_TODAY_END) != null) {
				props.put(Constants.PRICE_TODAY_END, (Float) bean.get(Constants.PRICE_TODAY_END));
			}
			if (bean.get(Constants.PRICE_YESTERDAY) != null) {
				props.put(Constants.PRICE_YESTERDAY, (Float) bean.get(Constants.PRICE_YESTERDAY));
			}
			if (bean.get(Constants.PRICE_TODAY) != null) {
				props.put(Constants.PRICE_TODAY, (Float) bean.get(Constants.PRICE_TODAY));
			}
			stockPropsToday.put(code, props);
		} else {
			Map<String, Float> props = stockPropsToday.get(code);

			if (bean.get(Constants.PRICE_MAX) != null) {
				float priceMax = (Float) bean.get(Constants.PRICE_MAX);
				if (props.get(Constants.PRICE_MAX) == null) {
					props.put(Constants.PRICE_MAX, priceMax);
				} else if (priceMax > props.get(Constants.PRICE_MAX)) {
					props.put(Constants.PRICE_MAX, priceMax);
				}
			}
			if (bean.get(Constants.PRICE_MIN) != null) {
				float priceMin = (Float) bean.get(Constants.PRICE_MIN);
				if (props.get(Constants.PRICE_MIN) == null) {
					props.put(Constants.PRICE_MIN, priceMin);
				} else if (priceMin < props.get(Constants.PRICE_MIN)) {
					props.put(Constants.PRICE_MIN, priceMin);
				}
			}
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
					props.put(Constants.MAX_RATE, maxRate);
				} else if (maxRate > props.get(Constants.MAX_RATE)) {
					props.put(Constants.MAX_RATE, maxRate);
				}
			}
			if (bean.get(Constants.PRICE_TODAY_END) != null) {
				float price = (Float) bean.get(Constants.PRICE_TODAY_END);
				if (props.get(Constants.PRICE_TODAY_END) == null) {
					props.put(Constants.PRICE_TODAY_END, price);
				} else if (price != props.get(Constants.PRICE_TODAY_END)) {
					props.put(Constants.PRICE_TODAY_END, price);
				}
			}
			stockPropsToday.put(code, props);
		}
	}

	public static void upStockMaxRate(EventBean bean) {
		if (bean == null || bean.get("code") == null) {
			return;
		}
		String code = (String) bean.get("code");
		if (stockPropsToday.get(code) == null) {
			Map<String, Float> props = new HashMap<String, Float>();
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
				props.put(Constants.MAX_RATE, maxRate);
			}
			stockPropsToday.put(code, props);
		} else {
			Map<String, Float> props = stockPropsToday.get(code);
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
					props.put(Constants.MAX_RATE, maxRate);
				} else if (maxRate > props.get(Constants.MAX_RATE)) {
					props.put(Constants.MAX_RATE, maxRate);
				}
			}
			stockPropsToday.put(code, props);
		}
	}

	public static Map<String, Map<String, Float>> getStockProps() {
		return stockPropsToday;
	}
}
