package com.fick.smd.common;

import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockDef;

public class StockDefCommon {

	private static DaoImplStockDef dao = new DaoImplStockDef();
	private static DaoMethodTemplate dmt = new DaoMethodTemplate();

	public static void addStockDefByCode(String code) {
		dao.setStockCodes(new String[] { code });
		dmt.process(dao, 1);
	}

}
