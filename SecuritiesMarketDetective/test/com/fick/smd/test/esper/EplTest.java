package com.fick.smd.test.esper;

import org.junit.Test;

import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplEplDef;
import com.fick.smd.hibernate.formbean.esperbean.EplDef;

public class EplTest {
	DaoImplEplDef dao = new DaoImplEplDef();
	DaoMethodTemplate dmt = new DaoMethodTemplate();

	@Test
	public void addNewEpl() {
		EplDef epl = new EplDef();
		epl.setEplname("epl模式匹配测试");
		epl.setEplrun("select b from pattern[every a = Stock -> every b = Stock(b.code = a.code)]");
		epl.setEplshow("select b from pattern[every a = Stock -> every b = Stock(b.code = a.code)]");
		epl.setListenerclassname("com.fick.smd.esper.listener.MyPatternListener");
		epl.setEplst(3);
		dao.setEpl(epl);
		dmt.process(dao, 1);
	}

	@Test
	public void setEplSt() {
		// 设置id及状态值
		dao.setEplId(1);
		dao.setEplSt(1);
		EplDef epl = (EplDef) dmt.process(dao, 5);
	}

}
