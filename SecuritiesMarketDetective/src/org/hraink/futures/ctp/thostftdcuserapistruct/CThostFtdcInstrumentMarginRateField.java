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

public class CThostFtdcInstrumentMarginRateField extends StructObject {
	public CThostFtdcInstrumentMarginRateField() {
		super();
	}
	/// \u5408\u7ea6\u4ee3\u7801
	@Array({31}) 
	@Field(0) 
	public Pointer<Byte > InstrumentID() {
		return this.io.getPointerField(this, 0);
	}
	/// \u6295\u8d44\u8005\u8303\u56f4
	@Field(1) 
	public byte InvestorRange() {
		return this.io.getByteField(this, 1);
	}
	/// \u6295\u8d44\u8005\u8303\u56f4
	@Field(1) 
	public CThostFtdcInstrumentMarginRateField InvestorRange(byte InvestorRange) {
		this.io.setByteField(this, 1, InvestorRange);
		return this;
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801
	@Array({11}) 
	@Field(2) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u6295\u8d44\u8005\u4ee3\u7801
	@Array({13}) 
	@Field(3) 
	public Pointer<Byte > InvestorID() {
		return this.io.getPointerField(this, 3);
	}
	/// \u6295\u673a\u5957\u4fdd\u6807\u5fd7
	@Field(4) 
	public byte HedgeFlag() {
		return this.io.getByteField(this, 4);
	}
	/// \u6295\u673a\u5957\u4fdd\u6807\u5fd7
	@Field(4) 
	public CThostFtdcInstrumentMarginRateField HedgeFlag(byte HedgeFlag) {
		this.io.setByteField(this, 4, HedgeFlag);
		return this;
	}
	/// \u591a\u5934\u4fdd\u8bc1\u91d1\u7387
	@Field(5) 
	public double LongMarginRatioByMoney() {
		return this.io.getDoubleField(this, 5);
	}
	/// \u591a\u5934\u4fdd\u8bc1\u91d1\u7387
	@Field(5) 
	public CThostFtdcInstrumentMarginRateField LongMarginRatioByMoney(double LongMarginRatioByMoney) {
		this.io.setDoubleField(this, 5, LongMarginRatioByMoney);
		return this;
	}
	/// \u591a\u5934\u4fdd\u8bc1\u91d1\u8d39
	@Field(6) 
	public double LongMarginRatioByVolume() {
		return this.io.getDoubleField(this, 6);
	}
	/// \u591a\u5934\u4fdd\u8bc1\u91d1\u8d39
	@Field(6) 
	public CThostFtdcInstrumentMarginRateField LongMarginRatioByVolume(double LongMarginRatioByVolume) {
		this.io.setDoubleField(this, 6, LongMarginRatioByVolume);
		return this;
	}
	/// \u7a7a\u5934\u4fdd\u8bc1\u91d1\u7387
	@Field(7) 
	public double ShortMarginRatioByMoney() {
		return this.io.getDoubleField(this, 7);
	}
	/// \u7a7a\u5934\u4fdd\u8bc1\u91d1\u7387
	@Field(7) 
	public CThostFtdcInstrumentMarginRateField ShortMarginRatioByMoney(double ShortMarginRatioByMoney) {
		this.io.setDoubleField(this, 7, ShortMarginRatioByMoney);
		return this;
	}
	/// \u7a7a\u5934\u4fdd\u8bc1\u91d1\u8d39
	@Field(8) 
	public double ShortMarginRatioByVolume() {
		return this.io.getDoubleField(this, 8);
	}
	/// \u7a7a\u5934\u4fdd\u8bc1\u91d1\u8d39
	@Field(8) 
	public CThostFtdcInstrumentMarginRateField ShortMarginRatioByVolume(double ShortMarginRatioByVolume) {
		this.io.setDoubleField(this, 8, ShortMarginRatioByVolume);
		return this;
	}
	/// \u662f\u5426\u76f8\u5bf9\u4ea4\u6613\u6240\u6536\u53d6
	@Field(9) 
	public int IsRelative() {
		return this.io.getIntField(this, 9);
	}
	/// \u662f\u5426\u76f8\u5bf9\u4ea4\u6613\u6240\u6536\u53d6
	@Field(9) 
	public CThostFtdcInstrumentMarginRateField IsRelative(int IsRelative) {
		this.io.setIntField(this, 9, IsRelative);
		return this;
	}
	public CThostFtdcInstrumentMarginRateField(Pointer pointer) {
		super(pointer);
	}
}
