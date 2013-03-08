package com.fick.smd.test.spring;

import com.fick.smd.springquartz.SpringContextFactory;

public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bean bean = (Bean) SpringContextFactory.getContext().getBean("bean");
		bean.test();
	}

}
