package org.hraink.futures.ctp.thostftdcuserapistruct;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */

public class CThostFtdcQryExchangeOrderActionField extends StructObject {
	public CThostFtdcQryExchangeOrderActionField() {
		super();
	}
	/// \u4f1a\u5458\u4ee3\u7801
	@Array({11}) 
	@Field(0) 
	public Pointer<Byte > ParticipantID() {
		return this.io.getPointerField(this, 0);
	}
	/// \u5ba2\u6237\u4ee3\u7801
	@Array({11}) 
	@Field(1) 
	public Pointer<Byte > ClientID() {
		return this.io.getPointerField(this, 1);
	}
	/// \u4ea4\u6613\u6240\u4ee3\u7801
	@Array({9}) 
	@Field(2) 
	public Pointer<Byte > ExchangeID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u4ea4\u6613\u6240\u4ea4\u6613\u5458\u4ee3\u7801
	@Array({21}) 
	@Field(3) 
	public Pointer<Byte > TraderID() {
		return this.io.getPointerField(this, 3);
	}
	public CThostFtdcQryExchangeOrderActionField(Pointer pointer) {
		super(pointer);
	}
}
