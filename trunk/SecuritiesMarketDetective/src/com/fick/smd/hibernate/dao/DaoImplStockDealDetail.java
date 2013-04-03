package com.fick.smd.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.formbean.stockbean.StockDealDetail;

public class DaoImplStockDealDetail implements DaoInterface {
	// private static final Log log = LogFactory.getLog(DaoImplStockDealDetail.class);

	private List<StockDealDetail> details;

	/**
	 * 股票交易详情
	 * methodIndex:
	 * 1.添加详情记录；
	 * 2.……
	 */
	@Override
	public Object doProcess(Session session, int methodIndex) {
		switch (methodIndex) {
		case 1:
			return addDetails(session);
		default:
			return null;
		}
	}

	private Object addDetails(Session session) {
		for (StockDealDetail detail : details) {
			session.save(detail);
		}
		return Constants.SUCCESS;
	}

	public void setDetails(List<StockDealDetail> details) {
		this.details = details;
	}

}
