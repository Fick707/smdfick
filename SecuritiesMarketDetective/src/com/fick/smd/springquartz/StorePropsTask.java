package com.fick.smd.springquartz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.ServiceCommon;
import com.fick.smd.common.StockDealCommon;
import com.fick.smd.common.StockPropsCommon;

/**
 * 保存今天交易属性的任务，每天闭市时执行
 * 
 * @author Fick
 * 
 */
public class StorePropsTask {
	private static final Log log = LogFactory.getLog(StorePropsTask.class);

	public void process() {
		// 闭仓
		log.info("begin to close stock storages!");
		ServiceCommon.getStockStorageService().closeStorages();
		log.info("end to close stock storages!");

		// 保存股票分析的属性
		log.info("begin to store props of stocks for analysising!");
		StockPropsCommon.storeProps();
		log.info("end to store props of stocks for analysising!");

		// 处理今天交易的详情
		log.info("begin to store deal details!");
		StockDealCommon.storeDetails();
		log.info("end to store deal details!");

		// 停止应用
		log.info("system will shutdown 60 seconds later!");
		try {
			Thread.sleep(60000);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
