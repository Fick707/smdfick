package com.fick.smd.esper;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.core.thread.ThreadingOption;
import com.fick.smd.common.CommonUtils;
import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplEplDef;
import com.fick.smd.hibernate.dao.DaoImplStockDef;
import com.fick.smd.hibernate.formbean.esperbean.EplDef;
import com.fick.smd.hibernate.formbean.esperbean.Stock;

public class EsperEngine {

	private static final Log log = LogFactory.getLog(EsperEngine.class);

	/**
	 * 引擎标识信息
	 */
	private static final String ENGINE_URI;

	/**
	 * 事件类型所在包名
	 */
	private static final String[] PACKEGES;

	/**
	 * 事件类型
	 */
	private static final Class[] EVENTS;
	static {
		ENGINE_URI = Constants.getProperty("ENGINEURI");
		PACKEGES = new String[] { "com.fick.smd.hibernate.formbean.esperbean" };
		EVENTS = new Class[] { Stock.class };
	}

	private EPServiceProvider engine;

	private final Configuration engineConfig;

	private DaoMethodTemplate dmt = new DaoMethodTemplate();

	private DaoImplEplDef dao = new DaoImplEplDef();

	private DaoImplStockDef stockDao = new DaoImplStockDef();

	/**
	 * 初始化引擎
	 */
	public EsperEngine() {
		engineConfig = new Configuration();
		// 将包导入
		for (String temp : PACKEGES) {
			engineConfig.addImport(temp);
		}
		// 添加事件类型

		for (Class clazz : EVENTS) {
			engineConfig.addEventType(clazz);
		}

		ThreadingOption.isThreadingEnabled = true;
		engineConfig.getEngineDefaults().getThreading().setThreadPoolInbound(true);
		engineConfig.getEngineDefaults().getThreading().setThreadPoolInboundNumThreads(2);
		engineConfig.getEngineDefaults().getThreading().setThreadPoolOutbound(true);
		engineConfig.getEngineDefaults().getThreading().setThreadPoolOutboundNumThreads(2);

		log.info("engine startup successfully,wait for initial it……");
	}

	public void startEngine() {

		engine = EPServiceProviderManager.getProvider(ENGINE_URI, engineConfig);
		engine.initialize();
		initEpl();
		initAnalysisEpl();
		log.info("start engine successfully!");
	}

	private void initEpl() {
		// TODO Auto-generated method stub
		List<EplDef> eplList = (List<EplDef>) dmt.process(dao, 2);
		List<String> stocks = (List<String>) dmt.process(stockDao, 3);
		if (stocks != null && stocks.size() > 0) {
			String s = CommonUtils.getStringFromList(stocks);
			for (EplDef epl : eplList) {
				epl.setEplrun(epl.getEplrun().replace("?", s));
				EPStatement stmt = engine.getEPAdministrator().createEPL(epl.getEplrun(), epl.getId());
				UpdateListener listener = (UpdateListener) getInstant(epl.getListenerclassname());
				stmt.addListener(listener);
				log.info("initial epl " + epl.getId() + ":" + epl.getEplname() + ":" + epl.getEplshow() + " successfully!");
			}
			log.info("initial epls successfully!");
		} else {
			log.info("no run epls!");
		}
	}

	private void initAnalysisEpl() {
		// TODO Auto-generated method stub
		List<EplDef> eplList = (List<EplDef>) dmt.process(dao, 3);
		List<String> stocks = (List<String>) dmt.process(stockDao, 4);
		if (stocks != null && stocks.size() > 0) {
			String s = CommonUtils.getStringFromList(stocks);
			for (EplDef epl : eplList) {
				epl.setEplrun(epl.getEplrun().replace("?", s));
				EPStatement stmt = engine.getEPAdministrator().createEPL(epl.getEplrun(), epl.getId());
				UpdateListener listener = (UpdateListener) getInstant(epl.getListenerclassname());
				stmt.addListener(listener);
				log.info("initial analysis epl " + epl.getId() + ":" + epl.getEplname() + ":" + epl.getEplshow() + " successfully!");
			}
			log.info("initial analysis epls successfully!");
		} else {
			log.info("no analysis epls!");
		}
	}

	private Object getInstant(String className) {
		Object instant = null;
		try {
			Class clazz = Class.forName(className);
			instant = clazz.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(className + " can not be found,updatelistener can not be loaded!");
			destoryEngine();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("updatelistener can not be loaded!");
			destoryEngine();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("updatelistener can not be loaded!");
			destoryEngine();
		}
		return instant;
	}

	private void destoryEngine() {
		engine.destroy();
	}
}
