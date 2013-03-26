package com.fick.smd.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.StockStorageCommon;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockStorage;
import com.fick.smd.hibernate.formbean.stockbean.StockStorage;

public class StockStorageServiceImpl implements StockStorageService {

	private static final Log log = LogFactory.getLog(StockStorageServiceImpl.class);

	private DaoMethodTemplate dmt = new DaoMethodTemplate();
	private DaoImplStockStorage dao = new DaoImplStockStorage();

	@Override
	public void openStorages() {
		// TODO Auto-generated method stub
		log.info("开仓！");
		List<StockStorage> list = (List<StockStorage>) dmt.process(dao, 1);
		// 开仓，并添加映射
		for (StockStorage temp : list) {
			// 每天开仓前，将前一天不可用的股票设置成可用的股票；
			temp.setStocknum(temp.getStocknum() + temp.getLockedstocknum());
			temp.setLockedstocknum(0);
			StockStorageCommon.addStockStorage(temp);
			log.info("股票代码:" + temp.getStockcode() + "开仓成功！");
		}
		log.info("开仓成功！");
	}

	@Override
	public void addStorage(String code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeStorages() {
		// TODO Auto-generated method stub
		log.info("关仓！");
		Map<String, StockStorage> stockStorageMap = StockStorageCommon.getStockStorageMap();
		List<StockStorage> list = new ArrayList<StockStorage>();
		StockStorage stockStorage;
		for (String temp : stockStorageMap.keySet()) {
			stockStorage = stockStorageMap.get(temp);
			if (!StockStorageCommon.hasBeenBought(stockStorage)) {
				log.warn("股票代码:" + stockStorage.getStockcode() + "今日没有买入！");
			}
			if (!StockStorageCommon.hasBeenSold(stockStorage)) {
				log.warn("股票代码:" + stockStorage.getStockcode() + "今日没有卖出！");
			}
			list.add(stockStorage);
		}
		dao.setStockStorages(list);
		dmt.process(dao, 3);
		log.info("关仓成功！");
	}

	@Override
	public void clearStorage(String code) {
		// TODO Auto-generated method stub

	}

}
