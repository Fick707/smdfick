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

public class CThostFtdcUserSessionField extends StructObject {
	public CThostFtdcUserSessionField() {
		super();
	}
	/// \u524d\u7f6e\u7f16\u53f7
	@Field(0) 
	public int FrontID() {
		return this.io.getIntField(this, 0);
	}
	/// \u524d\u7f6e\u7f16\u53f7
	@Field(0) 
	public CThostFtdcUserSessionField FrontID(int FrontID) {
		this.io.setIntField(this, 0, FrontID);
		return this;
	}
	/// \u4f1a\u8bdd\u7f16\u53f7
	@Field(1) 
	public int SessionID() {
		return this.io.getIntField(this, 1);
	}
	/// \u4f1a\u8bdd\u7f16\u53f7
	@Field(1) 
	public CThostFtdcUserSessionField SessionID(int SessionID) {
		this.io.setIntField(this, 1, SessionID);
		return this;
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801
	@Array({11}) 
	@Field(2) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u7528\u6237\u4ee3\u7801
	@Array({16}) 
	@Field(3) 
	public Pointer<Byte > UserID() {
		return this.io.getPointerField(this, 3);
	}
	/// \u767b\u5f55\u65e5\u671f
	@Array({9}) 
	@Field(4) 
	public Pointer<Byte > LoginDate() {
		return this.io.getPointerField(this, 4);
	}
	/// \u767b\u5f55\u65f6\u95f4
	@Array({9}) 
	@Field(5) 
	public Pointer<Byte > LoginTime() {
		return this.io.getPointerField(this, 5);
	}
	/// IP\u5730\u5740
	@Array({16}) 
	@Field(6) 
	public Pointer<Byte > IPAddress() {
		return this.io.getPointerField(this, 6);
	}
	/// \u7528\u6237\u7aef\u4ea7\u54c1\u4fe1\u606f
	@Array({11}) 
	@Field(7) 
	public Pointer<Byte > UserProductInfo() {
		return this.io.getPointerField(this, 7);
	}
	/// \u63a5\u53e3\u7aef\u4ea7\u54c1\u4fe1\u606f
	@Array({11}) 
	@Field(8) 
	public Pointer<Byte > InterfaceProductInfo() {
		return this.io.getPointerField(this, 8);
	}
	/// \u534f\u8bae\u4fe1\u606f
	@Array({11}) 
	@Field(9) 
	public Pointer<Byte > ProtocolInfo() {
		return this.io.getPointerField(this, 9);
	}
	/// Mac\u5730\u5740
	@Array({21}) 
	@Field(10) 
	public Pointer<Byte > MacAddress() {
		return this.io.getPointerField(this, 10);
	}
	public CThostFtdcUserSessionField(Pointer pointer) {
		super(pointer);
	}
}
