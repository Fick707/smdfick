package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 查询报单 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcQryHisOrderField extends StructObject {	public CThostFtdcQryHisOrderField() {		super();	}	/**	 * \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801	 */	@Array({11}) 	@Field(0) 	private Pointer<Byte> BrokerID() {		return this.io.getPointerField(this, 0);	}	@Array({11})	@Field(0)	public void setBrokerID(String brokerID) {		this.io.getPointerField(this, 0).setCString(brokerID);	}	public String getBrokerID() {		return BrokerID().getCString();	}	/**	 * \u6295\u8d44\u8005\u4ee3\u7801	 */	@Array({13}) 	@Field(1) 	private Pointer<Byte> InvestorID() {		return this.io.getPointerField(this, 1);	}	@Array({13})	@Field(1)	public void setInvestorID(String investorID) {		this.io.getPointerField(this, 1).setCString(investorID);	}	public String getInvestorID() {		return InvestorID().getCString();	}	/**	 * \u5408\u7ea6\u4ee3\u7801	 */	@Array({31}) 	@Field(2) 	private Pointer<Byte> InstrumentID() {		return this.io.getPointerField(this, 2);	}	@Array({31})	@Field(2)	public void setInstrumentID(String instrumentID) {		this.io.getPointerField(this, 2).setCString(instrumentID);	}	public String getInstrumentID() {		return InstrumentID().getCString();	}	/**	 * \u4ea4\u6613\u6240\u4ee3\u7801	 */	@Array({9}) 	@Field(3) 	private Pointer<Byte> ExchangeID() {		return this.io.getPointerField(this, 3);	}	@Array({9})	@Field(3)	public void setExchangeID(String exchangeID) {		this.io.getPointerField(this, 3).setCString(exchangeID);	}	public String getExchangeID() {		return ExchangeID().getCString();	}	/**	 * \u62a5\u5355\u7f16\u53f7	 */	@Array({21}) 	@Field(4) 	private Pointer<Byte> OrderSysID() {		return this.io.getPointerField(this, 4);	}	@Array({21})	@Field(4)	public void setOrderSysID(String orderSysID) {		this.io.getPointerField(this, 4).setCString(orderSysID);	}	public String getOrderSysID() {		return OrderSysID().getCString();	}	/**	 * \u5f00\u59cb\u65f6\u95f4	 */	@Array({9}) 	@Field(5) 	private Pointer<Byte> InsertTimeStart() {		return this.io.getPointerField(this, 5);	}	@Array({9})	@Field(5)	public void setInsertTimeStart(String insertTimeStart) {		this.io.getPointerField(this, 5).setCString(insertTimeStart);	}	public String getInsertTimeStart() {		return InsertTimeStart().getCString();	}	/**	 * \u7ed3\u675f\u65f6\u95f4	 */	@Array({9}) 	@Field(6) 	private Pointer<Byte> InsertTimeEnd() {		return this.io.getPointerField(this, 6);	}	@Array({9})	@Field(6)	public void setInsertTimeEnd(String insertTimeEnd) {		this.io.getPointerField(this, 6).setCString(insertTimeEnd);	}	public String getInsertTimeEnd() {		return InsertTimeEnd().getCString();	}	/**	 * \u4ea4\u6613\u65e5	 */	@Array({9}) 	@Field(7) 	private Pointer<Byte> TradingDay() {		return this.io.getPointerField(this, 7);	}	@Array({9})	@Field(7)	public void setTradingDay(String tradingDay) {		this.io.getPointerField(this, 7).setCString(tradingDay);	}	public String getTradingDay() {		return TradingDay().getCString();	}	/**	 * \u7ed3\u7b97\u7f16\u53f7	 */	@Field(8) 	private int SettlementID() {		return this.io.getIntField(this, 8);	}	public int getSettlementID() {		return SettlementID();	}	/**	 * \u7ed3\u7b97\u7f16\u53f7	 */	@Field(8) 	private CThostFtdcQryHisOrderField SettlementID(int SettlementID) {		this.io.setIntField(this, 8, SettlementID);		return this;	}	public void setSettlementID(int settlementID) {		SettlementID(settlementID);	}	public CThostFtdcQryHisOrderField(Pointer pointer) {		super(pointer);	}}