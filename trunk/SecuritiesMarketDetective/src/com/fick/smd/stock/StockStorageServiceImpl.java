package com.fick.smd.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fick.smd.common.StockStorageCommon;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockStorage;
import com.fick.smd.hibernate.formbean.stockbean.StockStorage;

public class StockStorageServiceImpl implements StockStorageService {

	private DaoMethodTemplate dmt = new DaoMethodTemplate();
	private DaoImplStockStorage dao = new DaoImplStockStorage();

	@Override
	public void openStorages() {
		// TODO Auto-generated method stub
		List<StockStorage> list = (List<StockStorage>) dmt.process(dao, 1);
		// 开仓，并添加映射
		for (StockStorage temp : list) {
			// 每天开仓前，将前一天不可用的股票设置成可用的股票；
			temp.setStocknum(temp.getStocknum() + temp.getLockedstocknum());
			StockStorageCommon.addStockStorage(temp);
		}
	}

	@Override
	public void addStorage(String code) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeStorages() {
		// TODO Auto-generated method stub
		Map<String, StockStorage> stockStorageMap = StockStorageCommon.getStockStorageMap();
		List<StockStorage> list = new ArrayList<StockStorage>();
		for (String temp : stockStorageMap.keySet()) {
			list.add(stockStorageMap.get(temp));
		}
		dao.setStockStorages(list);
		dmt.process(dao, 3);
	}

	@Override
	public void clearStorage(String code) {
		// TODO Auto-generated method stub

	}

}
