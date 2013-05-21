package org.hraink.futures.ctp.thostftdcuserapistruct;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */

public class CThostFtdcMarketDataAsk45Field extends StructObject {
	public CThostFtdcMarketDataAsk45Field() {
		super();
	}
	/// \u7533\u5356\u4ef7\u56db
	@Field(0) 
	public double AskPrice4() {
		return this.io.getDoubleField(this, 0);
	}
	/// \u7533\u5356\u4ef7\u56db
	@Field(0) 
	public CThostFtdcMarketDataAsk45Field AskPrice4(double AskPrice4) {
		this.io.setDoubleField(this, 0, AskPrice4);
		return this;
	}
	/// \u7533\u5356\u91cf\u56db
	@Field(1) 
	public int AskVolume4() {
		return this.io.getIntField(this, 1);
	}
	/// \u7533\u5356\u91cf\u56db
	@Field(1) 
	public CThostFtdcMarketDataAsk45Field AskVolume4(int AskVolume4) {
		this.io.setIntField(this, 1, AskVolume4);
		return this;
	}
	/// \u7533\u5356\u4ef7\u4e94
	@Field(2) 
	public double AskPrice5() {
		return this.io.getDoubleField(this, 2);
	}
	/// \u7533\u5356\u4ef7\u4e94
	@Field(2) 
	public CThostFtdcMarketDataAsk45Field AskPrice5(double AskPrice5) {
		this.io.setDoubleField(this, 2, AskPrice5);
		return this;
	}
	/// \u7533\u5356\u91cf\u4e94
	@Field(3) 
	public int AskVolume5() {
		return this.io.getIntField(this, 3);
	}
	/// \u7533\u5356\u91cf\u4e94
	@Field(3) 
	public CThostFtdcMarketDataAsk45Field AskVolume5(int AskVolume5) {
		this.io.setIntField(this, 3, AskVolume5);
		return this;
	}
	public CThostFtdcMarketDataAsk45Field(Pointer pointer) {
		super(pointer);
	}
}
