package com.fick.smd.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.formbean.esperbean.StockProps;

public class DaoImplStockProps implements DaoInterface {
	private static final Log log = LogFactory.getLog(DaoImplStockProps.class);

	private List<StockProps> props;

	/**
	 * 股票每天最大涨跌幅度
	 * methodIndex:
	 * 1.添加EPL；
	 * 2.……
	 */
	@Override
	public Object doProcess(Session session, int methodIndex) {
		// TODO Auto-generated method stub
		switch (methodIndex) {
		case 1:
			return ratesToday(session);
		case 2:
			return addProps(session);
			/* 
			* case 3:
			* return getAnalysisEplList(session);
			*/
		default:
			return ratesToday(session);
		}

		// return null;
	}

	private List ratesToday(Session session) {
		return session.createSQLQuery("select stockcode,maxrate from stockmaxrate where updatedate > curdate()").list();
	}

	private Object addProps(Session session) {
		for (StockProps rate : props) {
			session.save(rate);
		}
		return Constants.SUCCESS;
	}

	public void setProps(List<StockProps> props) {
		this.props = props;
	}

}
