package com.fick.smd.agg;

import com.fick.smd.hibernate.formbean.stockbean.Stock;

public interface SmdAggregator {

	public void enter(Stock stock);

	public Object getValue();

}
