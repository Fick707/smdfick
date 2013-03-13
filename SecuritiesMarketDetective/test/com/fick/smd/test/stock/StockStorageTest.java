package com.fick.smd.test.stock;

import java.util.List;

import org.junit.Test;

import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockStorage;
import com.fick.smd.hibernate.formbean.stockbean.StockStorage;

public class StockStorageTest {
	private DaoImplStockStorage dao = new DaoImplStockStorage();
	private DaoMethodTemplate dmt = new DaoMethodTemplate();

	@Test
	public void testAdd() {
		StockStorage ss = new StockStorage();
		ss.setStockcode("sh600000");
		ss.setInvestment(15000f);
		ss.setBalance(15000f);
		ss.setDealnum(500);
		ss.setLockedstocknum(0);
		ss.setStocknum(0);
		ss.setStoragestate(1);
		dao.setStockStorage(ss);
		dmt.process(dao, 2);
	}

	@Test
	public void testGet() {
		List<StockStorage> list = (List<StockStorage>) dmt.process(dao, 1);
		for (StockStorage temp : list) {
			System.out.println(temp.getStockcode());
			System.out.println(temp.getId());
			System.out.println(temp.getInvestment());
			System.out.println(temp.getBalance());
			System.out.println(temp.getBuyprice());
			System.out.println(Integer.toBinaryString(3));
		}
	}
}
