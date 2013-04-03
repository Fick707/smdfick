package com.fick.smd.springquartz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.ServiceCommon;
import com.fick.smd.common.StockDealCommon;
import com.fick.smd.common.StockPropsCommon;

public class StorePropsTask {
	private static final Log log = LogFactory.getLog(StorePropsTask.class);

	public void process() {
		log.info("begin to close stock storages!");
		ServiceCommon.getStockStorageService().closeStorages();
		log.info("end to close stock storages!");

		log.info("begin to store props of stocks for analysising!");
		StockPropsCommon.storeProps();
		log.info("end to store props of stocks for analysising!");

		log.info("begin to store deal details!");

		log.info("end to store deal details!");
		StockDealCommon.storeDetails();
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
