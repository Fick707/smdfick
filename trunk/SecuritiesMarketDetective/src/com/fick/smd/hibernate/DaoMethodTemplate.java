package com.fick.smd.hibernate;

import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.dao.DaoInterface;

public class DaoMethodTemplate {

	private Session session;

	public synchronized Object process(DaoInterface baseDao, int methodIndex) {
		getSssion();
		beginTransaction();
		Object retVal = doProcess(baseDao, methodIndex);
		commitTransaction(retVal);
		closeSession();
		return retVal;
	}

	private void getSssion() {
		this.session = SessionFactoryUtil.getCurrentSession();
	}

	private void beginTransaction() {
		session.beginTransaction();
	}

	private Object doProcess(DaoInterface baseDao, int methodIndex) {
		return baseDao.doProcess(session, methodIndex);
	}

	private void commitTransaction(Object result) {
		if (Constants.ROLL_BACK.equals(result)) {
			session.getTransaction().rollback();
		} else {
			session.getTransaction().commit();
		}
	}

	private void closeSession() {
		if (this.session != null && this.session.isOpen()) {
			this.session.close();
		}
	}
}
