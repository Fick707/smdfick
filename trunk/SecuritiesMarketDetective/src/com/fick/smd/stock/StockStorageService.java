package com.fick.smd.stock;

public interface StockStorageService {

	/**
	 * 开仓，每天开仓交易
	 */
	public void openStorages();

	/**
	 * 新建一个仓库
	 * 
	 * @param code
	 */
	public void addStorage(String code);

	/**
	 * 闭仓，每天交易结束后闭仓
	 */
	public void closeStorages();

	/**
	 * 清仓，遇到特殊情况，清仓
	 */
	public void clearStorage(String code);

}
