package com.fick.smd.hibernate.dao;

import org.hibernate.Session;

public interface DaoInterface {

	public Object doProcess(Session session, int methodIndex);
}
