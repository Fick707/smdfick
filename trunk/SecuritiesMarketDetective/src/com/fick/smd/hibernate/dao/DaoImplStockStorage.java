package com.fick.smd.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.formbean.stockbean.StockStorage;

public class DaoImplStockStorage implements DaoInterface {
	private static final Log log = LogFactory.getLog(DaoImplStockStorage.class);
	private StockStorage ss;

	/**
	 * 股票仓库操作类
	 * methodIndex:
	 * 1.得到所有正常交易的仓库；
	 * 2.……
	 */
	@Override
	public Object doProcess(Session session, int methodIndex) {
		// TODO Auto-generated method stub
		switch (methodIndex) {
		case 1:
			return getAllOpen(session);
		case 2:
			return addOrUpdateStockStorage(session);
		default:
			return null;
		}
	}

	private List<StockStorage> getAllOpen(Session session) {
		return session.createQuery("from StockStorage where storagestate = 1").list();
	}

	private String addOrUpdateStockStorage(Session session) {
		session.saveOrUpdate(ss);
		return Constants.SUCCESS;
	}

	public void setStockStorage(StockStorage ss) {
		this.ss = ss;
	}

}
