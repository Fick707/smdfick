package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 查询错误报单操作 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcQryErrOrderActionField extends StructObject {	public CThostFtdcQryErrOrderActionField() {		super();	}	/**	 * \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801	 */	@Array({11}) 	@Field(0) 	private Pointer<Byte> BrokerID() {		return this.io.getPointerField(this, 0);	}	@Array({11})	@Field(0)	public void setBrokerID(String brokerID) {		this.io.getPointerField(this, 0).setCString(brokerID);	}	public String getBrokerID() {		return BrokerID().getCString();	}	/**	 * \u6295\u8d44\u8005\u4ee3\u7801	 */	@Array({13}) 	@Field(1) 	private Pointer<Byte> InvestorID() {		return this.io.getPointerField(this, 1);	}	@Array({13})	@Field(1)	public void setInvestorID(String investorID) {		this.io.getPointerField(this, 1).setCString(investorID);	}	public String getInvestorID() {		return InvestorID().getCString();	}	public CThostFtdcQryErrOrderActionField(Pointer pointer) {		super(pointer);	}}