package com.fick.smd.common;

import org.junit.Test;

import com.fick.smd.hibernate.formbean.stockbean.StockStorage;

public class StockStorageCommon {

	// 买入
	private static final int BUY_STATE = 1;
	// 卖出
	private static final int SELL_STATE = 2;
	// 买入确认
	private static final int BUY_CONFIRM_STATE = 4;
	// 卖出确认
	private static final int SLL_CONFIRM_STATE = 8;

	/**
	 * 指定股票在指定价格买入
	 * 
	 * @param price
	 * @param stockStorage
	 */
	public static void buyAt(float price, StockStorage stockStorage) {
		int dealNum = stockStorage.getDealnum();
		stockStorage.setTodaystate(setBit(stockStorage.getTodaystate(), BUY_STATE));
		stockStorage.setBuyprice(price);
		stockStorage.setLockedstocknum(stockStorage.getLockedstocknum() + dealNum);
		stockStorage.setBalance(stockStorage.getBalance() - getBuyCostByNumAndPrice(dealNum, price));
	}

	/**
	 * 根据交易量得出过户费用
	 * 
	 * @param num
	 * @return
	 */
	public static float getCostOfTransferFee(int num) {
		int sum = num % 1000 == 0 ? num / 1000 : num / 1000 + 1;
		return sum * Constants.TRANSFER_FEE;
	}

	/**
	 * 根据交易量和价格得出成本费用
	 * 
	 * @param dealNum
	 * @param price
	 * @return
	 */
	public static float getBuyCostByNumAndPrice(int dealNum, float price) {
		return (dealNum * price * Constants.COMMISSION_RATE) + getCostOfTransferFee(dealNum);
	}

	/**
	 * 根据交易量和价格得出收益额
	 * 
	 * @param dealNum
	 * @param price
	 * @return
	 */
	public static float getSellCostByNumAndPrice(int dealNum, float price) {
		return (dealNum * price * (Constants.COMMISSION_RATE + Constants.STAMP_TAX_RATE)) + getCostOfTransferFee(dealNum);
	}

	/**
	 * 设置位状态
	 * 
	 * @param src
	 * @param full
	 * @return
	 */
	private static int setBit(int src, int full) {
		return src | full;
	}

	@Test
	public void testBit() {
		System.out.println(getCostOfTransferFee(2002));
	}

}
