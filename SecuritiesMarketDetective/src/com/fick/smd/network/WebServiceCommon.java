package com.fick.smd.network;

import com.fick.smd.hibernate.formbean.esperbean.Stock;

public class WebServiceCommon implements ServiceCommon {
	@Override
	public synchronized Stock getStockInfoByCode(String code, Connection connection) {
		return connection.getStock(code);
	}

	@Override
	public synchronized String getStockNameByCode(String code, Connection connection) {
		Stock stock = connection.getStock(code);
		return stock.getName();
	}
}
