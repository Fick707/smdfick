package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 前置状态 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcFrontStatusField extends StructObject {	public CThostFtdcFrontStatusField() {		super();	}	/**	 * \u524d\u7f6e\u7f16\u53f7	 */	@Field(0) 	private int FrontID() {		return this.io.getIntField(this, 0);	}	public int getFrontID() {		return FrontID();	}	/**	 * \u524d\u7f6e\u7f16\u53f7	 */	@Field(0) 	private CThostFtdcFrontStatusField FrontID(int FrontID) {		this.io.setIntField(this, 0, FrontID);		return this;	}	public void setFrontID(int frontID) {		FrontID(frontID);	}	/**	 * \u4e0a\u6b21\u62a5\u544a\u65e5\u671f	 */	@Array({9}) 	@Field(1) 	private Pointer<Byte> LastReportDate() {		return this.io.getPointerField(this, 1);	}	@Array({9})	@Field(1)	public void setLastReportDate(String lastReportDate) {		this.io.getPointerField(this, 1).setCString(lastReportDate);	}	public String getLastReportDate() {		return LastReportDate().getCString();	}	/**	 * \u4e0a\u6b21\u62a5\u544a\u65f6\u95f4	 */	@Array({9}) 	@Field(2) 	private Pointer<Byte> LastReportTime() {		return this.io.getPointerField(this, 2);	}	@Array({9})	@Field(2)	public void setLastReportTime(String lastReportTime) {		this.io.getPointerField(this, 2).setCString(lastReportTime);	}	public String getLastReportTime() {		return LastReportTime().getCString();	}	/**	 * \u662f\u5426\u6d3b\u8dc3	 */	@Field(3) 	private int IsActive() {		return this.io.getIntField(this, 3);	}	public int getIsActive() {		return IsActive();	}	/**	 * \u662f\u5426\u6d3b\u8dc3	 */	@Field(3) 	private CThostFtdcFrontStatusField IsActive(int IsActive) {		this.io.setIntField(this, 3, IsActive);		return this;	}	public void setIsActive(int isActive) {		IsActive(isActive);	}	public CThostFtdcFrontStatusField(Pointer pointer) {		super(pointer);	}}