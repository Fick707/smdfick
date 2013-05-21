package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 预埋单 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcParkedOrderField extends StructObject {	public CThostFtdcParkedOrderField() {		super();	}	/**	 * \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801	 */	@Array({11}) 	@Field(0) 	private Pointer<Byte> BrokerID() {		return this.io.getPointerField(this, 0);	}	@Array({11})	@Field(0)	public void setBrokerID(String brokerID) {		this.io.getPointerField(this, 0).setCString(brokerID);	}	public String getBrokerID() {		return BrokerID().getCString();	}	/**	 * \u6295\u8d44\u8005\u4ee3\u7801	 */	@Array({13}) 	@Field(1) 	private Pointer<Byte> InvestorID() {		return this.io.getPointerField(this, 1);	}	@Array({13})	@Field(1)	public void setInvestorID(String investorID) {		this.io.getPointerField(this, 1).setCString(investorID);	}	public String getInvestorID() {		return InvestorID().getCString();	}	/**	 * \u5408\u7ea6\u4ee3\u7801	 */	@Array({31}) 	@Field(2) 	private Pointer<Byte> InstrumentID() {		return this.io.getPointerField(this, 2);	}	@Array({31})	@Field(2)	public void setInstrumentID(String instrumentID) {		this.io.getPointerField(this, 2).setCString(instrumentID);	}	public String getInstrumentID() {		return InstrumentID().getCString();	}	/**	 * \u62a5\u5355\u5f15\u7528	 */	@Array({13}) 	@Field(3) 	private Pointer<Byte> OrderRef() {		return this.io.getPointerField(this, 3);	}	@Array({13})	@Field(3)	public void setOrderRef(String orderRef) {		this.io.getPointerField(this, 3).setCString(orderRef);	}	public String getOrderRef() {		return OrderRef().getCString();	}	/**	 * \u7528\u6237\u4ee3\u7801	 */	@Array({16}) 	@Field(4) 	private Pointer<Byte> UserID() {		return this.io.getPointerField(this, 4);	}	@Array({16})	@Field(4)	public void setUserID(String userID) {		this.io.getPointerField(this, 4).setCString(userID);	}	public String getUserID() {		return UserID().getCString();	}	/**	 * \u62a5\u5355\u4ef7\u683c\u6761\u4ef6	 */	@Field(5) 	private byte OrderPriceType() {		return this.io.getByteField(this, 5);	}	public char getOrderPriceType() {		return (char)OrderPriceType();	}	/**	 * \u62a5\u5355\u4ef7\u683c\u6761\u4ef6	 */	@Field(5) 	private CThostFtdcParkedOrderField OrderPriceType(byte OrderPriceType) {		this.io.setByteField(this, 5, OrderPriceType);		return this;	}	public void setOrderPriceType(char orderPriceType) {		OrderPriceType((byte)orderPriceType);	}	/**	 * \u4e70\u5356\u65b9\u5411	 */	@Field(6) 	private byte Direction() {		return this.io.getByteField(this, 6);	}	public char getDirection() {		return (char)Direction();	}	/**	 * \u4e70\u5356\u65b9\u5411	 */	@Field(6) 	private CThostFtdcParkedOrderField Direction(byte Direction) {		this.io.setByteField(this, 6, Direction);		return this;	}	public void setDirection(char direction) {		Direction((byte)direction);	}	/**	 * \u7ec4\u5408\u5f00\u5e73\u6807\u5fd7	 */	@Array({5}) 	@Field(7) 	private Pointer<Byte> CombOffsetFlag() {		return this.io.getPointerField(this, 7);	}	@Array({5})	@Field(7)	public void setCombOffsetFlag(String combOffsetFlag) {		this.io.getPointerField(this, 7).setCString(combOffsetFlag);	}	public String getCombOffsetFlag() {		return CombOffsetFlag().getCString();	}	/**	 * \u7ec4\u5408\u6295\u673a\u5957\u4fdd\u6807\u5fd7	 */	@Array({5}) 	@Field(8) 	private Pointer<Byte> CombHedgeFlag() {		return this.io.getPointerField(this, 8);	}	@Array({5})	@Field(8)	public void setCombHedgeFlag(String combHedgeFlag) {		this.io.getPointerField(this, 8).setCString(combHedgeFlag);	}	public String getCombHedgeFlag() {		return CombHedgeFlag().getCString();	}	/**	 * \u4ef7\u683c	 */	@Field(9) 	private double LimitPrice() {		return this.io.getDoubleField(this, 9);	}	public double getLimitPrice() {		return LimitPrice();	}	/**	 * \u4ef7\u683c	 */	@Field(9) 	private CThostFtdcParkedOrderField LimitPrice(double LimitPrice) {		this.io.setDoubleField(this, 9, LimitPrice);		return this;	}	public void setLimitPrice(double limitPrice) {		LimitPrice(limitPrice);	}	/**	 * \u6570\u91cf	 */	@Field(10) 	private int VolumeTotalOriginal() {		return this.io.getIntField(this, 10);	}	public int getVolumeTotalOriginal() {		return VolumeTotalOriginal();	}	/**	 * \u6570\u91cf	 */	@Field(10) 	private CThostFtdcParkedOrderField VolumeTotalOriginal(int VolumeTotalOriginal) {		this.io.setIntField(this, 10, VolumeTotalOriginal);		return this;	}	public void setVolumeTotalOriginal(int volumeTotalOriginal) {		VolumeTotalOriginal(volumeTotalOriginal);	}	/**	 * \u6709\u6548\u671f\u7c7b\u578b	 */	@Field(11) 	private byte TimeCondition() {		return this.io.getByteField(this, 11);	}	public char getTimeCondition() {		return (char)TimeCondition();	}	/**	 * \u6709\u6548\u671f\u7c7b\u578b	 */	@Field(11) 	private CThostFtdcParkedOrderField TimeCondition(byte TimeCondition) {		this.io.setByteField(this, 11, TimeCondition);		return this;	}	public void setTimeCondition(char timeCondition) {		TimeCondition((byte)timeCondition);	}	/// GTD\u65e5\u671f	@Array({9}) 	@Field(12) 	private Pointer<Byte> GTDDate() {		return this.io.getPointerField(this, 12);	}	@Array({9})	@Field(12)	public void setGTDDate(String gTDDate) {		this.io.getPointerField(this, 12).setCString(gTDDate);	}	public String getGTDDate() {		return GTDDate().getCString();	}	/**	 * \u6210\u4ea4\u91cf\u7c7b\u578b	 */	@Field(13) 	private byte VolumeCondition() {		return this.io.getByteField(this, 13);	}	public char getVolumeCondition() {		return (char)VolumeCondition();	}	/**	 * \u6210\u4ea4\u91cf\u7c7b\u578b	 */	@Field(13) 	private CThostFtdcParkedOrderField VolumeCondition(byte VolumeCondition) {		this.io.setByteField(this, 13, VolumeCondition);		return this;	}	public void setVolumeCondition(char volumeCondition) {		VolumeCondition((byte)volumeCondition);	}	/**	 * \u6700\u5c0f\u6210\u4ea4\u91cf	 */	@Field(14) 	private int MinVolume() {		return this.io.getIntField(this, 14);	}	public int getMinVolume() {		return MinVolume();	}	/**	 * \u6700\u5c0f\u6210\u4ea4\u91cf	 */	@Field(14) 	private CThostFtdcParkedOrderField MinVolume(int MinVolume) {		this.io.setIntField(this, 14, MinVolume);		return this;	}	public void setMinVolume(int minVolume) {		MinVolume(minVolume);	}	/**	 * \u89e6\u53d1\u6761\u4ef6	 */	@Field(15) 	private byte ContingentCondition() {		return this.io.getByteField(this, 15);	}	public char getContingentCondition() {		return (char)ContingentCondition();	}	/**	 * \u89e6\u53d1\u6761\u4ef6	 */	@Field(15) 	private CThostFtdcParkedOrderField ContingentCondition(byte ContingentCondition) {		this.io.setByteField(this, 15, ContingentCondition);		return this;	}	public void setContingentCondition(char contingentCondition) {		ContingentCondition((byte)contingentCondition);	}	/**	 * \u6b62\u635f\u4ef7	 */	@Field(16) 	private double StopPrice() {		return this.io.getDoubleField(this, 16);	}	public double getStopPrice() {		return StopPrice();	}	/**	 * \u6b62\u635f\u4ef7	 */	@Field(16) 	private CThostFtdcParkedOrderField StopPrice(double StopPrice) {		this.io.setDoubleField(this, 16, StopPrice);		return this;	}	public void setStopPrice(double stopPrice) {		StopPrice(stopPrice);	}	/**	 * \u5f3a\u5e73\u539f\u56e0	 */	@Field(17) 	private byte ForceCloseReason() {		return this.io.getByteField(this, 17);	}	public char getForceCloseReason() {		return (char)ForceCloseReason();	}	/**	 * \u5f3a\u5e73\u539f\u56e0	 */	@Field(17) 	private CThostFtdcParkedOrderField ForceCloseReason(byte ForceCloseReason) {		this.io.setByteField(this, 17, ForceCloseReason);		return this;	}	public void setForceCloseReason(char forceCloseReason) {		ForceCloseReason((byte)forceCloseReason);	}	/**	 * \u81ea\u52a8\u6302\u8d77\u6807\u5fd7	 */	@Field(18) 	private int IsAutoSuspend() {		return this.io.getIntField(this, 18);	}	public int getIsAutoSuspend() {		return IsAutoSuspend();	}	/**	 * \u81ea\u52a8\u6302\u8d77\u6807\u5fd7	 */	@Field(18) 	private CThostFtdcParkedOrderField IsAutoSuspend(int IsAutoSuspend) {		this.io.setIntField(this, 18, IsAutoSuspend);		return this;	}	public void setIsAutoSuspend(int isAutoSuspend) {		IsAutoSuspend(isAutoSuspend);	}	/**	 * \u4e1a\u52a1\u5355\u5143	 */	@Array({21}) 	@Field(19) 	private Pointer<Byte> BusinessUnit() {		return this.io.getPointerField(this, 19);	}	@Array({21})	@Field(19)	public void setBusinessUnit(String businessUnit) {		this.io.getPointerField(this, 19).setCString(businessUnit);	}	public String getBusinessUnit() {		return BusinessUnit().getCString();	}	/**	 * \u8bf7\u6c42\u7f16\u53f7	 */	@Field(20) 	private int RequestID() {		return this.io.getIntField(this, 20);	}	public int getRequestID() {		return RequestID();	}	/**	 * \u8bf7\u6c42\u7f16\u53f7	 */	@Field(20) 	private CThostFtdcParkedOrderField RequestID(int RequestID) {		this.io.setIntField(this, 20, RequestID);		return this;	}	public void setRequestID(int requestID) {		RequestID(requestID);	}	/**	 * \u7528\u6237\u5f3a\u8bc4\u6807\u5fd7	 */	@Field(21) 	private int UserForceClose() {		return this.io.getIntField(this, 21);	}	public int getUserForceClose() {		return UserForceClose();	}	/**	 * \u7528\u6237\u5f3a\u8bc4\u6807\u5fd7	 */	@Field(21) 	private CThostFtdcParkedOrderField UserForceClose(int UserForceClose) {		this.io.setIntField(this, 21, UserForceClose);		return this;	}	public void setUserForceClose(int userForceClose) {		UserForceClose(userForceClose);	}	/**	 * \u4ea4\u6613\u6240\u4ee3\u7801	 */	@Array({9}) 	@Field(22) 	private Pointer<Byte> ExchangeID() {		return this.io.getPointerField(this, 22);	}	@Array({9})	@Field(22)	public void setExchangeID(String exchangeID) {		this.io.getPointerField(this, 22).setCString(exchangeID);	}	public String getExchangeID() {		return ExchangeID().getCString();	}	/**	 * \u9884\u57cb\u62a5\u5355\u7f16\u53f7	 */	@Array({13}) 	@Field(23) 	private Pointer<Byte> ParkedOrderID() {		return this.io.getPointerField(this, 23);	}	@Array({13})	@Field(23)	public void setParkedOrderID(String parkedOrderID) {		this.io.getPointerField(this, 23).setCString(parkedOrderID);	}	public String getParkedOrderID() {		return ParkedOrderID().getCString();	}	/**	 * \u7528\u6237\u7c7b\u578b	 */	@Field(24) 	private byte UserType() {		return this.io.getByteField(this, 24);	}	public char getUserType() {		return (char)UserType();	}	/**	 * \u7528\u6237\u7c7b\u578b	 */	@Field(24) 	private CThostFtdcParkedOrderField UserType(byte UserType) {		this.io.setByteField(this, 24, UserType);		return this;	}	public void setUserType(char userType) {		UserType((byte)userType);	}	/**	 * \u9884\u57cb\u5355\u72b6\u6001	 */	@Field(25) 	private byte Status() {		return this.io.getByteField(this, 25);	}	public char getStatus() {		return (char)Status();	}	/**	 * \u9884\u57cb\u5355\u72b6\u6001	 */	@Field(25) 	private CThostFtdcParkedOrderField Status(byte Status) {		this.io.setByteField(this, 25, Status);		return this;	}	public void setStatus(char status) {		Status((byte)status);	}	/**	 * \u9519\u8bef\u4ee3\u7801	 */	@Field(26) 	private int ErrorID() {		return this.io.getIntField(this, 26);	}	public int getErrorID() {		return ErrorID();	}	/**	 * \u9519\u8bef\u4ee3\u7801	 */	@Field(26) 	private CThostFtdcParkedOrderField ErrorID(int ErrorID) {		this.io.setIntField(this, 26, ErrorID);		return this;	}	public void setErrorID(int errorID) {		ErrorID(errorID);	}	/**	 * \u9519\u8bef\u4fe1\u606f	 */	@Array({81}) 	@Field(27) 	private Pointer<Byte> ErrorMsg() {		return this.io.getPointerField(this, 27);	}	@Array({81})	@Field(27)	public void setErrorMsg(String errorMsg) {		this.io.getPointerField(this, 27).setCString(errorMsg);	}	public String getErrorMsg() {		return ErrorMsg().getCString();	}	/**	 * \u4e92\u6362\u5355\u6807\u5fd7	 */	@Field(28) 	private int IsSwapOrder() {		return this.io.getIntField(this, 28);	}	public int getIsSwapOrder() {		return IsSwapOrder();	}	/**	 * \u4e92\u6362\u5355\u6807\u5fd7	 */	@Field(28) 	private CThostFtdcParkedOrderField IsSwapOrder(int IsSwapOrder) {		this.io.setIntField(this, 28, IsSwapOrder);		return this;	}	public void setIsSwapOrder(int isSwapOrder) {		IsSwapOrder(isSwapOrder);	}	public CThostFtdcParkedOrderField(Pointer pointer) {		super(pointer);	}}