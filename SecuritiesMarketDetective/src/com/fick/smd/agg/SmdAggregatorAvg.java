package com.fick.smd.agg;

import com.fick.smd.hibernate.formbean.stockbean.Stock;

public class SmdAggregatorAvg implements SmdAggregator {

	private float count = 0;
	private int num = 0;

	@Override
	public void enter(Stock stock) {
		// TODO Auto-generated method stub
		count += stock.getPrice_current();
		num++;
	}

	@Override
	public Float getValue() {
		// TODO Auto-generated method stub
		if (num == 0) {
			return 0.0f;
		}
		return count / num;
	}

}
