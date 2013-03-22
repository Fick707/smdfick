package com.fick.smd.test.stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fick.smd.esper.input.InputAdapter;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockDef;
import com.fick.smd.hibernate.dao.DaoImplStockProps;
import com.fick.smd.hibernate.formbean.stockbean.Stock;
import com.fick.smd.hibernate.formbean.stockbean.StockProps;
import com.fick.smd.network.Connection;
import com.fick.smd.network.ConnectionFactory;

public class StockTest {
	DaoImplStockDef dao = new DaoImplStockDef();
	DaoMethodTemplate dmt = new DaoMethodTemplate();
	DaoImplStockProps smrdao = new DaoImplStockProps();

	/**
	 * @param args
	 *            根据股票代码，添加关注股票
	 *            如果代码前有type_0,则表明添加的是指数
	 */
	@Test
	public void addStockDefs() {
		// TODO Auto-generated method stub
		dao.setStockCodes(new String[] { "sh600446", "type_0sh000001",
				"sz000002", "sh601901", "sh600000", "sh601166",
				"sh600036", "sh600008", "sz002431", "sh600894" });
		dmt.process(dao, 1);
	}

	@Test
	public void testPrintStockDefs() {
		dmt.process(dao, 2);
	}

	@Test
	public void getStockInofByCode() {
		String code = "sh600446";
		Connection connection = ConnectionFactory.newConnectionInstant(code);
		Stock stock = ConnectionFactory.getServiceCommon().getStockInfoByCode(code, connection);
		System.out.println(stock.getName());
	}

	@Test
	public void sendStockEvent() {
		String code = "sh600446";
		Connection connection = ConnectionFactory.newConnectionInstant(code);
		Stock stock = ConnectionFactory.getServiceCommon().getStockInfoByCode(code, connection);
		InputAdapter.sendEvent(stock);
	}

	@Test
	public void getAnalysisStocks() {
		List<String> stocks = (List<String>) dmt.process(dao, 4);
		String s = Arrays.deepToString(stocks.toArray());
		System.out.println(s.substring(1, s.length() - 1));
	}

	@Test
	public void addRatesTest() {
		Map<String, Float> rateMap = new HashMap<String, Float>();
		rateMap.put("sh6008", 1.23F);
		rateMap.put("sh6038", 1.243F);
		rateMap.put("sh60408", 14.23F);

		List<StockProps> rates = new ArrayList<StockProps>();
		StockProps rate;
		for (String key : rateMap.keySet()) {
			rate = new StockProps();
			rate.setStockcode(key);
			rate.setMaxrate(rateMap.get(key));
			rates.add(rate);
		}
		smrdao.setProps(rates);
		dmt.process(smrdao, 2);
	}
}
