package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 查询交易员报盘机 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcQryTraderOfferField extends StructObject {	public CThostFtdcQryTraderOfferField() {		super();	}	/**	 * \u4ea4\u6613\u6240\u4ee3\u7801	 */	@Array({9}) 	@Field(0) 	private Pointer<Byte> ExchangeID() {		return this.io.getPointerField(this, 0);	}	@Array({9})	@Field(0)	public void setExchangeID(String exchangeID) {		this.io.getPointerField(this, 0).setCString(exchangeID);	}	public String getExchangeID() {		return ExchangeID().getCString();	}	/**	 * \u4f1a\u5458\u4ee3\u7801	 */	@Array({11}) 	@Field(1) 	private Pointer<Byte> ParticipantID() {		return this.io.getPointerField(this, 1);	}	@Array({11})	@Field(1)	public void setParticipantID(String participantID) {		this.io.getPointerField(this, 1).setCString(participantID);	}	public String getParticipantID() {		return ParticipantID().getCString();	}	/**	 * \u4ea4\u6613\u6240\u4ea4\u6613\u5458\u4ee3\u7801	 */	@Array({21}) 	@Field(2) 	private Pointer<Byte> TraderID() {		return this.io.getPointerField(this, 2);	}	@Array({21})	@Field(2)	public void setTraderID(String traderID) {		this.io.getPointerField(this, 2).setCString(traderID);	}	public String getTraderID() {		return TraderID().getCString();	}	public CThostFtdcQryTraderOfferField(Pointer pointer) {		super(pointer);	}}