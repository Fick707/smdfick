package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 经纪公司用户功能权限 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcBrokerUserFunctionField extends StructObject {	public CThostFtdcBrokerUserFunctionField() {		super();	}	/**	 * \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801	 */	@Array({11}) 	@Field(0) 	private Pointer<Byte> BrokerID() {		return this.io.getPointerField(this, 0);	}	@Array({11})	@Field(0)	public void setBrokerID(String brokerID) {		this.io.getPointerField(this, 0).setCString(brokerID);	}	public String getBrokerID() {		return BrokerID().getCString();	}	/**	 * \u7528\u6237\u4ee3\u7801	 */	@Array({16}) 	@Field(1) 	private Pointer<Byte> UserID() {		return this.io.getPointerField(this, 1);	}	@Array({16})	@Field(1)	public void setUserID(String userID) {		this.io.getPointerField(this, 1).setCString(userID);	}	public String getUserID() {		return UserID().getCString();	}	/**	 * \u7ecf\u7eaa\u516c\u53f8\u529f\u80fd\u4ee3\u7801	 */	@Field(2) 	private byte BrokerFunctionCode() {		return this.io.getByteField(this, 2);	}	public char getBrokerFunctionCode() {		return (char)BrokerFunctionCode();	}	/**	 * \u7ecf\u7eaa\u516c\u53f8\u529f\u80fd\u4ee3\u7801	 */	@Field(2) 	private CThostFtdcBrokerUserFunctionField BrokerFunctionCode(byte BrokerFunctionCode) {		this.io.setByteField(this, 2, BrokerFunctionCode);		return this;	}	public void setBrokerFunctionCode(char brokerFunctionCode) {		BrokerFunctionCode((byte)brokerFunctionCode);	}	public CThostFtdcBrokerUserFunctionField(Pointer pointer) {		super(pointer);	}}