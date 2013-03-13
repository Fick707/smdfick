package com.fick.smd.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.fick.smd.common.Constants;
import com.fick.smd.hibernate.formbean.stockbean.StockDef;
import com.fick.smd.network.ConnectionFactory;

public class DaoImplStockDef implements DaoInterface {
	private static final Log log = LogFactory.getLog(DaoImplStockDef.class);

	String[] stockCodes;

	/**
	 * 股票处理类
	 * methodIndex:
	 * 1.添加关注的股票(s)（默认）；
	 * 2.打印出所有股票代码信息；
	 * 3.得到处于交易状态的股票代码列表
	 * 4.得到处于分析状态的股票代码列表
	 * 5.得到处于分析状态的指数代码列表
	 */
	@Override
	public Object doProcess(Session session, int methodIndex) {
		// TODO Auto-generated method stub
		switch (methodIndex) {
		case 1:
			return addStocks(session);
		case 2:
			return printAllStockDef(session);
		case 3:
			return getRunStockDefList(session);
		case 4:
			return getAnalysisStockDefList(session);
		case 5:
			return getAnalysisBigStockDefList(session);
		default:
			return null;
		}

		// return null;
	}

	/**
	 * 添加一条日志（测试用）
	 * 
	 * @param session
	 * @return
	 */
	private Object addStocks(Session session) {
		List<String> stockList = getAllStockDefList(session);
		for (String temp : stockCodes) {
			if (stockList.contains(temp) || stockList.contains(temp.replace("type_0", ""))) {
				continue;
			} else {
				StockDef stock = new StockDef();
				if (temp.indexOf("type_0") > -1) {
					temp = temp.replace("type_0", "");
					stock.setType(0);
				} else {
					stock.setType(1);
				}
				stock.setStockcode(temp);
				stock.setStockname(ConnectionFactory.getServiceCommon().getStockNameByCode(temp, ConnectionFactory.newConnectionInstant(temp)));
				// System.out.println(stock.getStockname());
				session.saveOrUpdate(stock);
				stockList.add(temp);
				log.info("add stocks successfully!");
			}
		}
		return Constants.SUCCESS;
	}

	private List<String> getRunStockDefList(Session session) {
		List<StockDef> resultList = session.createQuery("from StockDef where type = 1 and stockst = 3").list();
		List<String> stockCodes = new ArrayList<String>();
		if (resultList != null) {
			for (StockDef temp : resultList) {
				stockCodes.add(temp.getStockcode());
			}
		}
		return stockCodes;
	}

	private List<String> getAllStockDefList(Session session) {
		List<StockDef> resultList = session.createQuery("from StockDef").list();
		List<String> stockCodes = new ArrayList<String>();
		if (resultList != null) {
			for (StockDef temp : resultList) {
				stockCodes.add(temp.getStockcode());
			}
		}
		return stockCodes;
	}

	private List<String> getAnalysisStockDefList(Session session) {
		List<StockDef> resultList = session.createQuery("from StockDef where type = 1 and stockst = 1").list();
		List<String> stockCodes = new ArrayList<String>();
		if (resultList != null) {
			for (StockDef temp : resultList) {
				stockCodes.add(temp.getStockcode());
			}
		}
		return stockCodes;
	}

	private List<String> getAnalysisBigStockDefList(Session session) {
		List<StockDef> resultList = session.createQuery("from StockDef where type = 0 and stockst = 1").list();
		List<String> stockCodes = new ArrayList<String>();
		if (resultList != null) {
			for (StockDef temp : resultList) {
				stockCodes.add("s_" + temp.getStockcode());
			}
		}
		return stockCodes;
	}

	private Object printAllStockDef(Session session) {
		List<String> stockCodes = getRunStockDefList(session);
		for (String temp : stockCodes) {
			System.out.println(temp);
		}
		return Constants.SUCCESS;
	}

	public void setStockCodes(String[] stockCodes) {
		this.stockCodes = stockCodes;
	}

}
