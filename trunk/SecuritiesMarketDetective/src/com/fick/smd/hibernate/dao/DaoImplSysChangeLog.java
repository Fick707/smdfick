package com.fick.smd.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.formbean.sysbean.SysChangeLog;

public class DaoImplSysChangeLog implements DaoInterface {

	/**
	 * 关于系统更新日志的处理类
	 * methodIndex:
	 * 1.查询所有日志内容并输出；
	 * 2.……
	 */
	@Override
	public Object doProcess(Session session, int methodIndex) {
		// TODO Auto-generated method stub
		switch (methodIndex) {
		case 1:
			return printAllLog(session);
		case 2:
			return addLog(session);
		case 3:
			return getLastedVersion(session);
		default:
			return printAllLog(session);
		}

		// return null;
	}

	/**
	 * 添加一条日志（测试用）
	 * 
	 * @param session
	 * @return
	 */
	private Object addLog(Session session) {
		SysChangeLog log = new SysChangeLog();
		log.setVersion("1.0.1");
		log.setOperator("宋飞");
		log.setRemark("测试用");
		session.saveOrUpdate(log);
		System.out.println("添加成功");
		return Constants.SUCCESS;
	}

	private Object printAllLog(Session session) {
		List<SysChangeLog> resultList = session.createQuery("from SysChangeLog").list();
		if (resultList != null) {
			for (SysChangeLog log : resultList) {
				System.out.println("版本信息:" + log.getVersion());
				System.out.println("版本作者:" + log.getAuthor());
				System.out.println("日志更新:" + log.getOperator());
				System.out.println("更新备注:" + log.getRemark());
				System.out.println("日志时间:" + log.getUpdatedt());
				System.out.println("-----------------------------------------");
			}
		}
		return Constants.SUCCESS;
	}

	private Object getLastedVersion(Session session) {
		SysChangeLog log = (SysChangeLog) session.createQuery("from SysChangeLog order by id desc").setMaxResults(1).uniqueResult();
		if (log != null) {
			System.out.println("版本信息:" + log.getVersion());
			System.out.println("版本作者:" + log.getAuthor());
			System.out.println("日志更新:" + log.getOperator());
			System.out.println("更新备注:" + log.getRemark());
			System.out.println("日志时间:" + log.getUpdatedt());
			System.out.println("-----------------------------------------");
		}
		return Constants.SUCCESS;
	}

}
