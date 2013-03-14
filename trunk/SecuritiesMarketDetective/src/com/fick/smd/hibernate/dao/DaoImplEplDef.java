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
	private int eplId;
	private int eplSt;

	/**
	 * EPL定义处理类
	 * methodIndex:
	 * 1.添加或者更新EPL；
	 * 2.得到运行的EPL；
	 * 3.得到分析的EPL；
	 * 4.根据id得到EPL；
	 * 5.根据id和状态值更新EPL状态
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
		case 4:
			return getStockById(session);
		case 5:
			return setEplState(session);
		default:
			return null;
		}

		// return null;
	}

	/**
	 * 添加一条EPL
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

	private EplDef getStockById(Session session) {
		EplDef epl = (EplDef) session.createQuery("from EplDef where id = " + eplId).setMaxResults(1).uniqueResult();
		return epl;
	}

	private String setEplState(Session session) {
		session.createSQLQuery("update epldef set eplst = " + eplSt + " where id = " + eplId).executeUpdate();
		return Constants.SUCCESS;
	}

	public void setEpl(EplDef epl) {
		this.epl = epl;
	}

	public void setEplId(int eplId) {
		this.eplId = eplId;
	}

	public void setEplSt(int eplSt) {
		this.eplSt = eplSt;
	}

}
