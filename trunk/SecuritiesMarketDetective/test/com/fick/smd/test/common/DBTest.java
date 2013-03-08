package com.fick.smd.test.common;

import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplSysChangeLog;
import com.fick.smd.hibernate.dao.DaoInterface;

public class DBTest {

	public static void main(String[] args) {
		DaoInterface dao = new DaoImplSysChangeLog();
		DaoMethodTemplate dmt = new DaoMethodTemplate();
		dmt.process(dao, 3);
	}

}
