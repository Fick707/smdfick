package com.fick.smd.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.springquartz.SpringContextFactory;

public class Constants {

	/**
	 * private constructor
	 */
	private Constants() {
	}

	private static Log log = LogFactory.getLog(Constants.class);
	private static Properties props = new Properties();
	public static final String SUCCESS = "success";
	public static final String UNSUCCESS = "unsuccess";
	public static final String ROLL_BACK = "rollback";
	public static final String PRICE_MAX = "price_max";
	public static final String PRICE_MIN = "price_min";
	public static final String PRICE_YESTERDAY = "price_yesterday";
	public static final String PRICE_TODAY = "price_today";
	public static final String PRICE_TODAY_END = "price";
	public static final String RATE_MAX = "rate_max";
	public static final String RATE_MIN = "rate_min";
	public static final String MAX_RATE = "max_rate";

	public static long STOCK_INFO_REPEAT = 5000;
	public static int OUTBOUND_QUEUE_CAPACITY = 50;
	public static int OUTBOUND_THREAD_POOL_CAPACITY = 5;
	static {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties.properties");
			props.load(is);
			is.close();
			if (CommonUtils.getLongFromString(props.getProperty("STOCK_INFO_REPEAT")) != null) {
				STOCK_INFO_REPEAT = CommonUtils.getLongFromString(props.getProperty("STOCK_INFO_REPEAT"));
			}
			if (CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_QUEUE_CAPACITY")) != null) {
				OUTBOUND_QUEUE_CAPACITY = CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_QUEUE_CAPACITY"));
			}
			if (CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_THREAD_POOL_CAPACITY")) != null) {
				OUTBOUND_THREAD_POOL_CAPACITY = CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_THREAD_POOL_CAPACITY"));
			}
			SpringContextFactory.getContext();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("properties.properties could not be found!");
			System.exit(-1);
		}
	}

	public static String getProperty(String key) {
		return props.getProperty(key);
	}

	public static void reload() {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties.properties");
			props.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
