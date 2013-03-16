package com.fick.smd.common;

import com.fick.smd.stock.StockStorageService;
import com.fick.smd.stock.StockStorageServiceImpl;

public class ServiceCommon {

	private static StockStorageService stockStorageService;

	public static StockStorageService getStockStorageService() {
		if (stockStorageService == null) {
			stockStorageService = new StockStorageServiceImpl();
		}
		return stockStorageService;
	}

}
