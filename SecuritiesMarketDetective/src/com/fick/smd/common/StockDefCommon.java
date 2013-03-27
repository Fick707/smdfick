package com.fick.smd.common;

import java.util.List;

import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockDef;
import com.fick.smd.work.StockAnalysisWorkThread;
import com.fick.smd.work.StockWorkThread;

public class StockDefCommon {

	private static DaoImplStockDef dao = new DaoImplStockDef();
	private static DaoMethodTemplate dmt = new DaoMethodTemplate();

	/**
	 * 根据code添加关注的股票
	 * 
	 * @param code
	 */
	public static void addStockDefByCode(String code) {
		dao.setStockCodes(new String[] { code });
		dmt.process(dao, 1);
	}

	/**
	 * 开启股票交易线程
	 */
	public static void startStockWorkThread() {
		List<String> codes = (List<String>) dmt.process(dao, 3);
		for (String code : codes) {
			StockWorkThread stockWorkThread = new StockWorkThread(code);
			stockWorkThread.start();
		}
	}

	/**
	 * 开启股票分析线程
	 */
	public static void startStockAnalysisWorkThread() {
		List<String> codes = (List<String>) dmt.process(dao, 4);
		for (String code : codes) {
			StockAnalysisWorkThread stockAnalysisWorkThread = new StockAnalysisWorkThread(code);
			stockAnalysisWorkThread.start();
		}
	}

}
