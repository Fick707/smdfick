package com.fick.smd.test;

import javax.swing.JOptionPane;

import org.junit.Test;

public class SimpleTest {

	@Test
	public void testFloat() {
		float y = 3.5f;
		float c = 3f;
		float r = ((3f - 3.5f) * 100) / 3.5f;
		System.out.println(r + "% rate1");
	}

	@Test
	public void music() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "sample dialog !");
	}

}
