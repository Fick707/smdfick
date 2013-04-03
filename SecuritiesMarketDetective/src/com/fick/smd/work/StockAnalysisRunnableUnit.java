package com.fick.smd.work;

import com.fick.smd.common.StockPropsCommon;
import com.fick.smd.hibernate.formbean.stockbean.Stock;

public class StockAnalysisRunnableUnit implements Runnable {

	private Stock stock;

	public StockAnalysisRunnableUnit(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void run() {
		StockPropsCommon.upStockProps(stock);
	}

}
