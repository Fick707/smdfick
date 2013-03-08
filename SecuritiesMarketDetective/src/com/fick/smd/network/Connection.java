package com.fick.smd.network;

import com.fick.smd.hibernate.formbean.esperbean.Stock;

public interface Connection {

	public void connect();

	public Stock getStock(String code);

}
