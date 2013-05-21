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

public class CThostFtdcExchangeOrderActionErrorField extends StructObject {
	public CThostFtdcExchangeOrderActionErrorField() {
		super();
	}
	/// \u4ea4\u6613\u6240\u4ee3\u7801
	@Array({9}) 
	@Field(0) 
	public Pointer<Byte > ExchangeID() {
		return this.io.getPointerField(this, 0);
	}
	/// \u62a5\u5355\u7f16\u53f7
	@Array({21}) 
	@Field(1) 
	public Pointer<Byte > OrderSysID() {
		return this.io.getPointerField(this, 1);
	}
	/// \u4ea4\u6613\u6240\u4ea4\u6613\u5458\u4ee3\u7801
	@Array({21}) 
	@Field(2) 
	public Pointer<Byte > TraderID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u5b89\u88c5\u7f16\u53f7
	@Field(3) 
	public int InstallID() {
		return this.io.getIntField(this, 3);
	}
	/// \u5b89\u88c5\u7f16\u53f7
	@Field(3) 
	public CThostFtdcExchangeOrderActionErrorField InstallID(int InstallID) {
		this.io.setIntField(this, 3, InstallID);
		return this;
	}
	/// \u672c\u5730\u62a5\u5355\u7f16\u53f7
	@Array({13}) 
	@Field(4) 
	public Pointer<Byte > OrderLocalID() {
		return this.io.getPointerField(this, 4);
	}
	/// \u64cd\u4f5c\u672c\u5730\u7f16\u53f7
	@Array({13}) 
	@Field(5) 
	public Pointer<Byte > ActionLocalID() {
		return this.io.getPointerField(this, 5);
	}
	/// \u9519\u8bef\u4ee3\u7801
	@Field(6) 
	public int ErrorID() {
		return this.io.getIntField(this, 6);
	}
	/// \u9519\u8bef\u4ee3\u7801
	@Field(6) 
	public CThostFtdcExchangeOrderActionErrorField ErrorID(int ErrorID) {
		this.io.setIntField(this, 6, ErrorID);
		return this;
	}
	/// \u9519\u8bef\u4fe1\u606f
	@Array({81}) 
	@Field(7) 
	public Pointer<Byte > ErrorMsg() {
		return this.io.getPointerField(this, 7);
	}
	public CThostFtdcExchangeOrderActionErrorField(Pointer pointer) {
		super(pointer);
	}
}
