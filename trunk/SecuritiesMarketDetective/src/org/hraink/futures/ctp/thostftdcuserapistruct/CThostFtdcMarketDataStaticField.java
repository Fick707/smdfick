package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 行情静态属性 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcMarketDataStaticField extends StructObject {	public CThostFtdcMarketDataStaticField() {		super();	}	/**	 * \u4eca\u5f00\u76d8	 */	@Field(0) 	private double OpenPrice() {		return this.io.getDoubleField(this, 0);	}	public double getOpenPrice() {		return OpenPrice();	}	/**	 * \u4eca\u5f00\u76d8	 */	@Field(0) 	private CThostFtdcMarketDataStaticField OpenPrice(double OpenPrice) {		this.io.setDoubleField(this, 0, OpenPrice);		return this;	}	public void setOpenPrice(double openPrice) {		OpenPrice(openPrice);	}	/**	 * \u6700\u9ad8\u4ef7	 */	@Field(1) 	private double HighestPrice() {		return this.io.getDoubleField(this, 1);	}	public double getHighestPrice() {		return HighestPrice();	}	/**	 * \u6700\u9ad8\u4ef7	 */	@Field(1) 	private CThostFtdcMarketDataStaticField HighestPrice(double HighestPrice) {		this.io.setDoubleField(this, 1, HighestPrice);		return this;	}	public void setHighestPrice(double highestPrice) {		HighestPrice(highestPrice);	}	/**	 * \u6700\u4f4e\u4ef7	 */	@Field(2) 	private double LowestPrice() {		return this.io.getDoubleField(this, 2);	}	public double getLowestPrice() {		return LowestPrice();	}	/**	 * \u6700\u4f4e\u4ef7	 */	@Field(2) 	private CThostFtdcMarketDataStaticField LowestPrice(double LowestPrice) {		this.io.setDoubleField(this, 2, LowestPrice);		return this;	}	public void setLowestPrice(double lowestPrice) {		LowestPrice(lowestPrice);	}	/**	 * \u4eca\u6536\u76d8	 */	@Field(3) 	private double ClosePrice() {		return this.io.getDoubleField(this, 3);	}	public double getClosePrice() {		return ClosePrice();	}	/**	 * \u4eca\u6536\u76d8	 */	@Field(3) 	private CThostFtdcMarketDataStaticField ClosePrice(double ClosePrice) {		this.io.setDoubleField(this, 3, ClosePrice);		return this;	}	public void setClosePrice(double closePrice) {		ClosePrice(closePrice);	}	/**	 * \u6da8\u505c\u677f\u4ef7	 */	@Field(4) 	private double UpperLimitPrice() {		return this.io.getDoubleField(this, 4);	}	public double getUpperLimitPrice() {		return UpperLimitPrice();	}	/**	 * \u6da8\u505c\u677f\u4ef7	 */	@Field(4) 	private CThostFtdcMarketDataStaticField UpperLimitPrice(double UpperLimitPrice) {		this.io.setDoubleField(this, 4, UpperLimitPrice);		return this;	}	public void setUpperLimitPrice(double upperLimitPrice) {		UpperLimitPrice(upperLimitPrice);	}	/**	 * \u8dcc\u505c\u677f\u4ef7	 */	@Field(5) 	private double LowerLimitPrice() {		return this.io.getDoubleField(this, 5);	}	public double getLowerLimitPrice() {		return LowerLimitPrice();	}	/**	 * \u8dcc\u505c\u677f\u4ef7	 */	@Field(5) 	private CThostFtdcMarketDataStaticField LowerLimitPrice(double LowerLimitPrice) {		this.io.setDoubleField(this, 5, LowerLimitPrice);		return this;	}	public void setLowerLimitPrice(double lowerLimitPrice) {		LowerLimitPrice(lowerLimitPrice);	}	/**	 * \u672c\u6b21\u7ed3\u7b97\u4ef7	 */	@Field(6) 	private double SettlementPrice() {		return this.io.getDoubleField(this, 6);	}	public double getSettlementPrice() {		return SettlementPrice();	}	/**	 * \u672c\u6b21\u7ed3\u7b97\u4ef7	 */	@Field(6) 	private CThostFtdcMarketDataStaticField SettlementPrice(double SettlementPrice) {		this.io.setDoubleField(this, 6, SettlementPrice);		return this;	}	public void setSettlementPrice(double settlementPrice) {		SettlementPrice(settlementPrice);	}	/**	 * \u4eca\u865a\u5b9e\u5ea6	 */	@Field(7) 	private double CurrDelta() {		return this.io.getDoubleField(this, 7);	}	public double getCurrDelta() {		return CurrDelta();	}	/**	 * \u4eca\u865a\u5b9e\u5ea6	 */	@Field(7) 	private CThostFtdcMarketDataStaticField CurrDelta(double CurrDelta) {		this.io.setDoubleField(this, 7, CurrDelta);		return this;	}	public void setCurrDelta(double currDelta) {		CurrDelta(currDelta);	}	public CThostFtdcMarketDataStaticField(Pointer pointer) {		super(pointer);	}}