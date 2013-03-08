package com.fick.smd.springquartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextFactory {

	private static ApplicationContext springContext;

	public static ApplicationContext getContext() {
		if (springContext == null) {
			// String temp = Thread.currentThread().getContextClassLoader().getResource("springcontext.xml").toString();
			springContext = new ClassPathXmlApplicationContext(new String[] { "spring_context.xml", "spring_context_quartz.xml" });
		}
		return springContext;
	}

}
