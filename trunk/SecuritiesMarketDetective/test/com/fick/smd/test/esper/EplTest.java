package com.fick.smd.test.esper;

import org.junit.Test;

import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplEplDef;
import com.fick.smd.hibernate.formbean.esperbean.EplDef;

public class EplTest {
	DaoImplEplDef dao = new DaoImplEplDef();
	DaoMethodTemplate dmt = new DaoMethodTemplate();

	@Test
	public void addOrUpdateEpl() {
		EplDef epl = new EplDef();
		epl.setId(1);
		epl.setEplname("epl基本查询");
		epl.setEplrun("select code,name,datetime, price_current as price,max(price_highest) as price_max,min(price_lowest) as price_min from Stock.win:time(10 hours) group by (code)");
		epl.setEplshow("select code,name,datetime, price_current as price,max(price_highest) as price_max,min(price_lowest) as price_min from Stock.win:time(10 hours) group by (code)");
		epl.setEplst(3);
		dao.setEpl(epl);
		dmt.process(dao, 1);
	}

}
