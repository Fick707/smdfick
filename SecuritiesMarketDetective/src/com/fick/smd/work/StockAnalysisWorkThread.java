package com.fick.smd.work;

import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;
import com.fick.smd.common.StockCommon;
import com.fick.smd.hibernate.formbean.stockbean.Stock;
import com.fick.smd.network.Connection;
import com.fick.smd.network.ConnectionFactory;

public class StockAnalysisWorkThread extends Thread {
	private static final Log log = LogFactory.getLog(StockAnalysisWorkThread.class);
	private String code;
	private Connection connection;

	public StockAnalysisWorkThread(String code) {
		this.code = code;
		this.connection = ConnectionFactory.newConnectionInstant(this.code);
	}

	@Override
	public void run() {
		log.info("start the stock analysis work thread (code : " + code + ") successfully!");
		Stock preStock = null;
		Stock stock;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		while (ThreadSwitch.getStockAnalysisWorkThreadST()) {
			try {
				stock = ConnectionFactory.getServiceCommon().getStockInfoByCode(code, this.connection);
				if (stock == null) {
					continue;
				}
				if (stock.getPrice_current() == 0) {
					continue;
				}
				if (stock.getDatetime().before(calendar.getTime())) {
					continue;
				}
				if (preStock == null) {
					preStock = stock;
				} else if (stock.equals(preStock)) {
					Thread.sleep(Constants.STOCK_ANALYSIS_REPEAT);
					continue;
				}
				preStock = stock;
				StockCommon.dealNewStock(stock);
				Thread.sleep(Constants.STOCK_ANALYSIS_REPEAT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
