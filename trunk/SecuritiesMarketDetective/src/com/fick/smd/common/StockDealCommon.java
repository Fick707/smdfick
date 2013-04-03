package com.fick.smd.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockDealDetail;
import com.fick.smd.hibernate.formbean.stockbean.StockDealDetail;

public class StockDealCommon {

	private static DaoMethodTemplate dmt = new DaoMethodTemplate();
	private static DaoImplStockDealDetail detailDao = new DaoImplStockDealDetail();

	private static Map<String, List<StockDealDetail>> stockDeals = new HashMap<String, List<StockDealDetail>>();

	public static void addDetail(String code, StockDealDetail stockDealDetail) {
		List<StockDealDetail> details = stockDeals.get(code);
		if (details == null) {
			details = new ArrayList<StockDealDetail>();
			details.add(stockDealDetail);
			stockDeals.put(code, details);
			return;
		}
		details.add(stockDealDetail);
		stockDeals.put(code, details);
	}

	/**
	 * 保存当天的交易记录
	 */
	public static void storeDetails() {
		// TODO Auto-generated method stub
		List<StockDealDetail> details = new ArrayList<StockDealDetail>();
		for (String code : stockDeals.keySet()) {
			details.addAll(stockDeals.get(code));
		}
		detailDao.setDetails(details);
		dmt.process(detailDao, 2);
	}

}
