package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 查询行情 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcQryDepthMarketDataField extends StructObject {	public CThostFtdcQryDepthMarketDataField() {		super();	}	/**	 * \u5408\u7ea6\u4ee3\u7801	 */	@Array({31}) 	@Field(0) 	private Pointer<Byte> InstrumentID() {		return this.io.getPointerField(this, 0);	}	@Array({31})	@Field(0)	public void setInstrumentID(String instrumentID) {		this.io.getPointerField(this, 0).setCString(instrumentID);	}	public String getInstrumentID() {		return InstrumentID().getCString();	}	public CThostFtdcQryDepthMarketDataField(Pointer pointer) {		super(pointer);	}}