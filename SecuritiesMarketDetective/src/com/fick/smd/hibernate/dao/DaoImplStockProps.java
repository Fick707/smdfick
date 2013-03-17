package com.fick.smd.hibernate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.formbean.stockbean.StockProps;

public class DaoImplStockProps implements DaoInterface {
	private static final Log log = LogFactory.getLog(DaoImplStockProps.class);

	private List<StockProps> props;

	/**
	 * 股票属性
	 * methodIndex:
	 * 1.得到平均振幅；
	 * 2.……
	 */
	@Override
	public Object doProcess(Session session, int methodIndex) {
		// TODO Auto-generated method stub
		switch (methodIndex) {
		case 1:
			return avgMaxRateCurr(session);
		case 2:
			return addProps(session);
			/* 
			* case 3:
			* return getAnalysisEplList(session);
			*/
		default:
			return null;
		}

		// return null;
	}

	private List avgMaxRateCurr(Session session) {
		return session.createSQLQuery("select stockcode,avg(maxrate) from stockprops group by stockcode").list();
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
