package com.fick.smd.network;

import com.fick.smd.common.Constants;

public class ConnectionFactory {

	private static ServiceCommon common;

	public static Connection newConnectionInstant(String code) {
		Connection connection = null;
		String flag = Constants.getProperty("CONNECTION_TYPE");
		if (flag == null) {
			flag = "1";
		}
		if ("1".equals(flag)) {
			connection = new HttpConnection(code);
		} else if ("2".equals(flag)) {
			connection = new WebServiceConnection();
		}
		return connection == null ? new HttpConnection(code) : connection;
	}

	public static ServiceCommon getServiceCommon() {
		if (common == null) {
			String flag = Constants.getProperty("CONNECTION_TYPE");
			if (flag == null) {
				flag = "1";
			}
			if ("1".equals(flag)) {
				common = new HttpServiceCommon();
			} else if ("2".equals(flag)) {
				common = new WebServiceCommon();
			}
		}
		return common;
	}

}
