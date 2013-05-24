package org.hraink.futures.jctp.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;

public class CtpConstants {
	private static Log log = LogFactory.getLog(Constants.class);
	private static Properties ctpProps = new Properties();

	private CtpConstants() {
	}

	static {
		log.info("loading ctp properties……");
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("ctpproperties.properties");
			ctpProps.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("ctpproperties.properties could not be found!");
			System.exit(-1);
		}
		log.info("load ctp properties successfully!");
	}

	/**
	 * 根据key值得到对应的属性值
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return ctpProps.getProperty(key);
	}

	/**
	 * 得到以";"分隔的属性值，返回字符串数组
	 * 
	 * @param key
	 * @return
	 */
	public static String[] getPropertyValues(String key) {
		return ctpProps.getProperty(key).split(";");
	}

}
