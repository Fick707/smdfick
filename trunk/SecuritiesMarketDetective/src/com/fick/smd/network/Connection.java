package com.fick.smd.network;

import com.fick.smd.hibernate.formbean.stockbean.Stock;

public interface Connection {

	public void connect();

	public Stock getStock(String code);

}
