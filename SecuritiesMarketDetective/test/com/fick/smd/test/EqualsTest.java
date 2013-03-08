package com.fick.smd.test;

import com.fick.smd.hibernate.formbean.esperbean.StockDef;

public class EqualsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockDef def1 = new StockDef();
		def1.setStockcode("001");
		StockDef def2 = new StockDef();
		def2.setStockcode("001");
		System.out.println(def1 == def2);

	}

}
