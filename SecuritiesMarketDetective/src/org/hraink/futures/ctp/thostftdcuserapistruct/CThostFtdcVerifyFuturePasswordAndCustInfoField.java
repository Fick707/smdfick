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

public class CThostFtdcVerifyFuturePasswordAndCustInfoField extends StructObject {
	public CThostFtdcVerifyFuturePasswordAndCustInfoField() {
		super();
	}
	/// \u5ba2\u6237\u59d3\u540d
	@Array({51}) 
	@Field(0) 
	public Pointer<Byte > CustomerName() {
		return this.io.getPointerField(this, 0);
	}
	/// \u8bc1\u4ef6\u7c7b\u578b
	@Field(1) 
	public byte IdCardType() {
		return this.io.getByteField(this, 1);
	}
	/// \u8bc1\u4ef6\u7c7b\u578b
	@Field(1) 
	public CThostFtdcVerifyFuturePasswordAndCustInfoField IdCardType(byte IdCardType) {
		this.io.setByteField(this, 1, IdCardType);
		return this;
	}
	/// \u8bc1\u4ef6\u53f7\u7801
	@Array({51}) 
	@Field(2) 
	public Pointer<Byte > IdentifiedCardNo() {
		return this.io.getPointerField(this, 2);
	}
	/// \u5ba2\u6237\u7c7b\u578b
	@Field(3) 
	public byte CustType() {
		return this.io.getByteField(this, 3);
	}
	/// \u5ba2\u6237\u7c7b\u578b
	@Field(3) 
	public CThostFtdcVerifyFuturePasswordAndCustInfoField CustType(byte CustType) {
		this.io.setByteField(this, 3, CustType);
		return this;
	}
	/// \u6295\u8d44\u8005\u5e10\u53f7
	@Array({13}) 
	@Field(4) 
	public Pointer<Byte > AccountID() {
		return this.io.getPointerField(this, 4);
	}
	/// \u671f\u8d27\u5bc6\u7801
	@Array({41}) 
	@Field(5) 
	public Pointer<Byte > Password() {
		return this.io.getPointerField(this, 5);
	}
	public CThostFtdcVerifyFuturePasswordAndCustInfoField(Pointer pointer) {
		super(pointer);
	}
}
