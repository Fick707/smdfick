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

	// socket port
	public static int SOCKET_PORT = 4500;
	// 连接网络频率
	public static long STOCK_INFO_REPEAT = 5000;
	// 分析连网频率
	public static long STOCK_ANALYSIS_REPEAT = 10000;
	// 出栈队列容量
	public static int OUTBOUND_QUEUE_CAPACITY = 50;
	// 出栈线程数
	public static int OUTBOUND_THREAD_POOL_CAPACITY = 5;
	// 分析队列容量
	public static int ANALYSIS_QUEUE_CAPACITY = 50;
	// 分析线程数
	public static int ANALYSIS_THREAD_POOL_CAPACITY = 5;
	/*
	 *费用相关 
	 */
	// 佣金率commission
	public static float COMMISSION_RATE = 0.0015f;

	// 印花税率stamp tax
	public static float STAMP_TAX_RATE = 0.001f;

	// 过户费transfer fee 元/1000
	public static float TRANSFER_FEE = 1;

	public static float AMPLITUDE_RATE = 0.8f;

	// 警告开关初始
	public static boolean IS_WARN_INIT = false;

	static {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties.properties");
			props.load(is);
			is.close();
			if (CommonUtils.getIntegerFromString(props.getProperty("SOCKET_PORT")) != null) {
				SOCKET_PORT = CommonUtils.getIntegerFromString(props.getProperty("SOCKET_PORT"));
			}
			if (CommonUtils.getLongFromString(props.getProperty("STOCK_INFO_REPEAT")) != null) {
				STOCK_INFO_REPEAT = CommonUtils.getLongFromString(props.getProperty("STOCK_INFO_REPEAT"));
			}
			if (CommonUtils.getLongFromString(props.getProperty("STOCK_ANALYSIS_REPEAT")) != null) {
				STOCK_ANALYSIS_REPEAT = CommonUtils.getLongFromString(props.getProperty("STOCK_ANALYSIS_REPEAT"));
			}
			if (CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_QUEUE_CAPACITY")) != null) {
				OUTBOUND_QUEUE_CAPACITY = CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_QUEUE_CAPACITY"));
			}
			if (CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_THREAD_POOL_CAPACITY")) != null) {
				OUTBOUND_THREAD_POOL_CAPACITY = CommonUtils.getIntegerFromString(props.getProperty("OUTBOUND_THREAD_POOL_CAPACITY"));
			}
			if (CommonUtils.getIntegerFromString(props.getProperty("ANALYSIS_QUEUE_CAPACITY")) != null) {
				ANALYSIS_QUEUE_CAPACITY = CommonUtils.getIntegerFromString(props.getProperty("ANALYSIS_QUEUE_CAPACITY"));
			}
			if (CommonUtils.getIntegerFromString(props.getProperty("ANALYSIS_THREAD_POOL_CAPACITY")) != null) {
				ANALYSIS_THREAD_POOL_CAPACITY = CommonUtils.getIntegerFromString(props.getProperty("ANALYSIS_THREAD_POOL_CAPACITY"));
			}
			if (CommonUtils.getFloatFromString(props.getProperty("COMMISSION_RATE")) != null) {
				COMMISSION_RATE = CommonUtils.getFloatFromString(props.getProperty("COMMISSION_RATE"));
			}
			if (CommonUtils.getFloatFromString(props.getProperty("STAMP_TAX_RATE")) != null) {
				STAMP_TAX_RATE = CommonUtils.getFloatFromString(props.getProperty("STAMP_TAX_RATE"));
			}
			if (CommonUtils.getFloatFromString(props.getProperty("TRANSFER_FEE")) != null) {
				TRANSFER_FEE = CommonUtils.getFloatFromString(props.getProperty("TRANSFER_FEE"));
			}
			if (CommonUtils.getFloatFromString(props.getProperty("AMPLITUDE_RATE")) != null) {
				AMPLITUDE_RATE = CommonUtils.getFloatFromString(props.getProperty("AMPLITUDE_RATE"));
			}
			if (CommonUtils.getBooleanFromString(props.getProperty("IS_WARN_INIT")) != null) {
				IS_WARN_INIT = CommonUtils.getBooleanFromString(props.getProperty("IS_WARN_INIT"));
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
