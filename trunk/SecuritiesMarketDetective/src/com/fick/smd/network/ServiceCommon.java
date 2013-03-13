package com.fick.smd.network;

import com.fick.smd.hibernate.formbean.stockbean.Stock;

public interface ServiceCommon {

	public Stock getStockInfoByCode(String code, Connection connection);

	public String getStockNameByCode(String code, Connection connection);
}
