package com.fick.smd.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.fick.smd.hibernate.formbean.stockbean.StockStorage;

public class StockStorageCommon {

	private static final Log log = LogFactory.getLog(StockStorageCommon.class);

	private static Map<String, StockStorage> stockStorageMap = new HashMap<String, StockStorage>();

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
		float cost = getBuyCostByNumAndPrice(dealNum, price);
		stockStorage.setBalance(stockStorage.getBalance() - cost);
		log.info("买入！－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
		log.info("股票" + stockStorage.getStockcode() + "在" + price + "买入" + dealNum + ",共花费:" + cost);
	}

	/**
	 * 指定仓库在指定价格卖出
	 * 
	 * @param price
	 * @param stockStorage
	 */
	public static void sellAt(float price, StockStorage stockStorage) {
		int dealNum = stockStorage.getDealnum();
		stockStorage.setTodaystate(setBit(stockStorage.getTodaystate(), SELL_STATE));
		stockStorage.setSellprice(price);
		stockStorage.setStocknum(stockStorage.getStocknum() - dealNum);
		float cost = getSellEarningByNumAndPrice(dealNum, price);
		stockStorage.setBalance(stockStorage.getBalance() + cost);
		log.info("卖出！－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
		log.info("股票" + stockStorage.getStockcode() + "在" + price + "卖出" + dealNum + ",共收益:" + cost);
	}

	/**
	 * 通过命令卖出
	 * 不设置卖出标记
	 * 不设置今天卖出价格
	 * 
	 * @param price
	 * @param stockStorage
	 */
	public static void sellAtViaCommand(float price, StockStorage stockStorage) {
		int dealNum = stockStorage.getDealnum();
		stockStorage.setStocknum(stockStorage.getStocknum() - dealNum);
		float cost = getSellEarningByNumAndPrice(dealNum, price);
		stockStorage.setBalance(stockStorage.getBalance() + cost);
		log.info("通过命令卖出！－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
		log.info("股票" + stockStorage.getStockcode() + "在" + price + "卖出" + dealNum + ",共收益:" + cost);
	}

	/**
	 * 通过命令买入
	 * 不设置买入标记
	 * 不设置今天买入价格
	 * 
	 * @param price
	 * @param stockStorage
	 */
	public static void buyAtViaCommon(float price, StockStorage stockStorage) {
		int dealNum = stockStorage.getDealnum();
		stockStorage.setLockedstocknum(stockStorage.getLockedstocknum() + dealNum);
		float cost = getBuyCostByNumAndPrice(dealNum, price);
		stockStorage.setBalance(stockStorage.getBalance() - cost);
		log.info("通过命令买入！－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
		log.info("股票" + stockStorage.getStockcode() + "在" + price + "买入" + dealNum + ",共花费:" + cost);
	}

	/**
	 * 通过socket命令，在当前价买入
	 * 
	 * @param code
	 */
	public static void buyAtByCodeViaCommand(String code) {
		Float price = StockCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_TODAY_END);
		if (price == null) {
			return;
		}
		StockStorage stockStorage = getStockStorageByCode(code);
		if (stockStorage == null) {
			return;
		}
		log.info("股票代码:" + code + ",通过命令买入！价格:" + price);
		buyAtViaCommon(price, stockStorage);
	}

	/**
	 * 通过socket命令，在当前价卖出
	 * 
	 * @param code
	 */
	public static void sellAtByCodeViaCommon(String code) {
		Float price = StockCommon.getStockPropByCodeAndType(code, StockPropType.PRICE_TODAY_END);
		if (price == null) {
			return;
		}
		StockStorage stockStorage = getStockStorageByCode(code);
		if (stockStorage == null) {
			return;
		}
		log.info("股票代码:" + code + ",通过命令卖出！价格:" + price);
		sellAtViaCommand(price, stockStorage);
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
		return (dealNum * price) * (1 + Constants.COMMISSION_RATE) + getCostOfTransferFee(dealNum);
	}

	/**
	 * 根据交易量和价格得出收益额
	 * 
	 * @param dealNum
	 * @param price
	 * @return
	 */
	public static float getSellEarningByNumAndPrice(int dealNum, float price) {
		return (dealNum * price) * (1 - Constants.COMMISSION_RATE - Constants.STAMP_TAX_RATE) - getCostOfTransferFee(dealNum);
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

	private static boolean isBitFull(int state, int position) {
		return (state & position) == position ? true : false;
	}

	public static void addStockStorage(StockStorage stockStorage) {
		stockStorageMap.put(stockStorage.getStockcode(), stockStorage);
	}

	/**
	 * 根据股票代码得到对应的仓库
	 * 
	 * @param code
	 * @return
	 */
	public static StockStorage getStockStorageByCode(String code) {
		return stockStorageMap.get(code);
	}

	/**
	 * 得到映射map，每天闭仓操作时用
	 * 
	 * @return
	 */
	public static Map<String, StockStorage> getStockStorageMap() {
		return stockStorageMap;
	}

	/**
	 * 判断该仓库今日是否已买
	 * 
	 * @param stockStorage
	 * @return
	 */
	public static boolean hasBeenBought(StockStorage stockStorage) {
		return isBitFull(stockStorage.getTodaystate(), BUY_STATE);
	}

	/**
	 * 判断指定仓库今日是否已卖
	 * 
	 * @param stockStorage
	 * @return
	 */
	public static boolean hasBeenSold(StockStorage stockStorage) {
		return isBitFull(stockStorage.getTodaystate(), SELL_STATE);
	}

	@Test
	public void testBit() {
		System.out.println(isBitFull(7, this.BUY_STATE));
	}

}
