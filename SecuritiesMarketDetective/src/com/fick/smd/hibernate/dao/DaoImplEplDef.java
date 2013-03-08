package com.fick.smd.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.formbean.esperbean.EplDef;

public class DaoImplEplDef implements DaoInterface {
	private static final Log log = LogFactory.getLog(DaoImplEplDef.class);

	private EplDef epl;

	/**
	 * EPL定义处理类
	 * methodIndex:
	 * 1.添加EPL；
	 * 2.……
	 */
	@Override
	public Object doProcess(Session session, int methodIndex) {
		// TODO Auto-generated method stub
		switch (methodIndex) {
		case 1:
			return addOrUpdateEpl(session);
		case 2:
			return getRunEplList(session);
		case 3:
			return getAnalysisEplList(session);
		default:
			return addOrUpdateEpl(session);
		}

		// return null;
	}

	/**
	 * 添加一条日志（测试用）
	 * 
	 * @param session
	 * @return
	 */
	private Object addOrUpdateEpl(Session session) {
		String retVal = Constants.SUCCESS;
		if (epl != null) {
			session.saveOrUpdate(epl);
			log.info("add or update epl successfully!");
		} else {
			retVal = Constants.UNSUCCESS;
			log.error("epl has not been intialized!");
		}
		return retVal;
	}

	private List<EplDef> getRunEplList(Session session) {
		List<EplDef> retList = session.createQuery("from EplDef where eplst = 3 and type = 2").list();
		return retList == null ? new ArrayList<EplDef>() : retList;
	}

	private List<EplDef> getAnalysisEplList(Session session) {
		List<EplDef> retList = session.createQuery("from EplDef where eplst = 3 and type = 1").list();
		return retList == null ? new ArrayList<EplDef>() : retList;
	}

	public void setEpl(EplDef epl) {
		this.epl = epl;
	}

}
