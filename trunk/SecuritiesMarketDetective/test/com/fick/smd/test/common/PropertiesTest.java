package com.fick.smd.test.common;

import com.fick.smd.common.Constants;

public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Constants.getProperty("host"));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("again!");
		Constants.reload();
		System.out.println(Constants.getProperty("host"));
	}

}
