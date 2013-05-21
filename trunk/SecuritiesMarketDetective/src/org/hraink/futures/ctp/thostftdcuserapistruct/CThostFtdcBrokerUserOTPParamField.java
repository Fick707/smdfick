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

public class CThostFtdcBrokerUserOTPParamField extends StructObject {
	public CThostFtdcBrokerUserOTPParamField() {
		super();
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801
	@Array({11}) 
	@Field(0) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 0);
	}
	/// \u7528\u6237\u4ee3\u7801
	@Array({16}) 
	@Field(1) 
	public Pointer<Byte > UserID() {
		return this.io.getPointerField(this, 1);
	}
	/// \u52a8\u6001\u4ee4\u724c\u63d0\u4f9b\u5546
	@Array({2}) 
	@Field(2) 
	public Pointer<Byte > OTPVendorsID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u52a8\u6001\u4ee4\u724c\u5e8f\u5217\u53f7
	@Array({17}) 
	@Field(3) 
	public Pointer<Byte > SerialNumber() {
		return this.io.getPointerField(this, 3);
	}
	/// \u4ee4\u724c\u5bc6\u94a5
	@Array({41}) 
	@Field(4) 
	public Pointer<Byte > AuthKey() {
		return this.io.getPointerField(this, 4);
	}
	/// \u6f02\u79fb\u503c
	@Field(5) 
	public int LastDrift() {
		return this.io.getIntField(this, 5);
	}
	/// \u6f02\u79fb\u503c
	@Field(5) 
	public CThostFtdcBrokerUserOTPParamField LastDrift(int LastDrift) {
		this.io.setIntField(this, 5, LastDrift);
		return this;
	}
	/// \u6210\u529f\u503c
	@Field(6) 
	public int LastSuccess() {
		return this.io.getIntField(this, 6);
	}
	/// \u6210\u529f\u503c
	@Field(6) 
	public CThostFtdcBrokerUserOTPParamField LastSuccess(int LastSuccess) {
		this.io.setIntField(this, 6, LastSuccess);
		return this;
	}
	/// \u52a8\u6001\u4ee4\u724c\u7c7b\u578b
	@Field(7) 
	public byte OTPType() {
		return this.io.getByteField(this, 7);
	}
	/// \u52a8\u6001\u4ee4\u724c\u7c7b\u578b
	@Field(7) 
	public CThostFtdcBrokerUserOTPParamField OTPType(byte OTPType) {
		this.io.setByteField(this, 7, OTPType);
		return this;
	}
	public CThostFtdcBrokerUserOTPParamField(Pointer pointer) {
		super(pointer);
	}
}
