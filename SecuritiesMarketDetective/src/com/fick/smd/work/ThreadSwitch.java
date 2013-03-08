package com.fick.smd.work;

public class ThreadSwitch {

	private static boolean STOCKWORKTHREAD = true;
	private static boolean STOCKANALYSISWORKTHREAD = true;

	public static void switchStockWorkThread(boolean run) {
		STOCKWORKTHREAD = run;
	}

	public static boolean getStockWorkThreadST() {
		return STOCKWORKTHREAD;
	}

	public static void switchStockAnalysisWorkThread(boolean run) {
		STOCKANALYSISWORKTHREAD = run;
	}

	public static boolean getStockAnalysisWorkThreadST() {
		return STOCKANALYSISWORKTHREAD;
	}

}
