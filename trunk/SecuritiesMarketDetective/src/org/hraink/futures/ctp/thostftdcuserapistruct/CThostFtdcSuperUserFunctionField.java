package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 管理用户功能权限 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcSuperUserFunctionField extends StructObject {	public CThostFtdcSuperUserFunctionField() {		super();	}	/**	 * \u7528\u6237\u4ee3\u7801	 */	@Array({16}) 	@Field(0) 	private Pointer<Byte> UserID() {		return this.io.getPointerField(this, 0);	}	@Array({16})	@Field(0)	public void setUserID(String userID) {		this.io.getPointerField(this, 0).setCString(userID);	}	public String getUserID() {		return UserID().getCString();	}	/**	 * \u529f\u80fd\u4ee3\u7801	 */	@Field(1) 	private byte FunctionCode() {		return this.io.getByteField(this, 1);	}	public char getFunctionCode() {		return (char)FunctionCode();	}	/**	 * \u529f\u80fd\u4ee3\u7801	 */	@Field(1) 	private CThostFtdcSuperUserFunctionField FunctionCode(byte FunctionCode) {		this.io.setByteField(this, 1, FunctionCode);		return this;	}	public void setFunctionCode(char functionCode) {		FunctionCode((byte)functionCode);	}	public CThostFtdcSuperUserFunctionField(Pointer pointer) {		super(pointer);	}}