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

public class CThostFtdcInvestorPositionCombineDetailField extends StructObject {
	public CThostFtdcInvestorPositionCombineDetailField() {
		super();
	}
	/// \u4ea4\u6613\u65e5
	@Array({9}) 
	@Field(0) 
	public Pointer<Byte > TradingDay() {
		return this.io.getPointerField(this, 0);
	}
	/// \u5f00\u4ed3\u65e5\u671f
	@Array({9}) 
	@Field(1) 
	public Pointer<Byte > OpenDate() {
		return this.io.getPointerField(this, 1);
	}
	/// \u4ea4\u6613\u6240\u4ee3\u7801
	@Array({9}) 
	@Field(2) 
	public Pointer<Byte > ExchangeID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u7ed3\u7b97\u7f16\u53f7
	@Field(3) 
	public int SettlementID() {
		return this.io.getIntField(this, 3);
	}
	/// \u7ed3\u7b97\u7f16\u53f7
	@Field(3) 
	public CThostFtdcInvestorPositionCombineDetailField SettlementID(int SettlementID) {
		this.io.setIntField(this, 3, SettlementID);
		return this;
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801
	@Array({11}) 
	@Field(4) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 4);
	}
	/// \u6295\u8d44\u8005\u4ee3\u7801
	@Array({13}) 
	@Field(5) 
	public Pointer<Byte > InvestorID() {
		return this.io.getPointerField(this, 5);
	}
	/// \u7ec4\u5408\u7f16\u53f7
	@Array({21}) 
	@Field(6) 
	public Pointer<Byte > ComTradeID() {
		return this.io.getPointerField(this, 6);
	}
	/// \u64ae\u5408\u7f16\u53f7
	@Array({21}) 
	@Field(7) 
	public Pointer<Byte > TradeID() {
		return this.io.getPointerField(this, 7);
	}
	/// \u5408\u7ea6\u4ee3\u7801
	@Array({31}) 
	@Field(8) 
	public Pointer<Byte > InstrumentID() {
		return this.io.getPointerField(this, 8);
	}
	/// \u6295\u673a\u5957\u4fdd\u6807\u5fd7
	@Field(9) 
	public byte HedgeFlag() {
		return this.io.getByteField(this, 9);
	}
	/// \u6295\u673a\u5957\u4fdd\u6807\u5fd7
	@Field(9) 
	public CThostFtdcInvestorPositionCombineDetailField HedgeFlag(byte HedgeFlag) {
		this.io.setByteField(this, 9, HedgeFlag);
		return this;
	}
	/// \u4e70\u5356
	@Field(10) 
	public byte Direction() {
		return this.io.getByteField(this, 10);
	}
	/// \u4e70\u5356
	@Field(10) 
	public CThostFtdcInvestorPositionCombineDetailField Direction(byte Direction) {
		this.io.setByteField(this, 10, Direction);
		return this;
	}
	/// \u6301\u4ed3\u91cf
	@Field(11) 
	public int TotalAmt() {
		return this.io.getIntField(this, 11);
	}
	/// \u6301\u4ed3\u91cf
	@Field(11) 
	public CThostFtdcInvestorPositionCombineDetailField TotalAmt(int TotalAmt) {
		this.io.setIntField(this, 11, TotalAmt);
		return this;
	}
	/// \u6295\u8d44\u8005\u4fdd\u8bc1\u91d1
	@Field(12) 
	public double Margin() {
		return this.io.getDoubleField(this, 12);
	}
	/// \u6295\u8d44\u8005\u4fdd\u8bc1\u91d1
	@Field(12) 
	public CThostFtdcInvestorPositionCombineDetailField Margin(double Margin) {
		this.io.setDoubleField(this, 12, Margin);
		return this;
	}
	/// \u4ea4\u6613\u6240\u4fdd\u8bc1\u91d1
	@Field(13) 
	public double ExchMargin() {
		return this.io.getDoubleField(this, 13);
	}
	/// \u4ea4\u6613\u6240\u4fdd\u8bc1\u91d1
	@Field(13) 
	public CThostFtdcInvestorPositionCombineDetailField ExchMargin(double ExchMargin) {
		this.io.setDoubleField(this, 13, ExchMargin);
		return this;
	}
	/// \u4fdd\u8bc1\u91d1\u7387
	@Field(14) 
	public double MarginRateByMoney() {
		return this.io.getDoubleField(this, 14);
	}
	/// \u4fdd\u8bc1\u91d1\u7387
	@Field(14) 
	public CThostFtdcInvestorPositionCombineDetailField MarginRateByMoney(double MarginRateByMoney) {
		this.io.setDoubleField(this, 14, MarginRateByMoney);
		return this;
	}
	/// \u4fdd\u8bc1\u91d1\u7387(\u6309\u624b\u6570)
	@Field(15) 
	public double MarginRateByVolume() {
		return this.io.getDoubleField(this, 15);
	}
	/// \u4fdd\u8bc1\u91d1\u7387(\u6309\u624b\u6570)
	@Field(15) 
	public CThostFtdcInvestorPositionCombineDetailField MarginRateByVolume(double MarginRateByVolume) {
		this.io.setDoubleField(this, 15, MarginRateByVolume);
		return this;
	}
	/// \u5355\u817f\u7f16\u53f7
	@Field(16) 
	public int LegID() {
		return this.io.getIntField(this, 16);
	}
	/// \u5355\u817f\u7f16\u53f7
	@Field(16) 
	public CThostFtdcInvestorPositionCombineDetailField LegID(int LegID) {
		this.io.setIntField(this, 16, LegID);
		return this;
	}
	/// \u5355\u817f\u4e58\u6570
	@Field(17) 
	public int LegMultiple() {
		return this.io.getIntField(this, 17);
	}
	/// \u5355\u817f\u4e58\u6570
	@Field(17) 
	public CThostFtdcInvestorPositionCombineDetailField LegMultiple(int LegMultiple) {
		this.io.setIntField(this, 17, LegMultiple);
		return this;
	}
	/// \u7ec4\u5408\u6301\u4ed3\u5408\u7ea6\u7f16\u7801
	@Array({31}) 
	@Field(18) 
	public Pointer<Byte > CombInstrumentID() {
		return this.io.getPointerField(this, 18);
	}
	public CThostFtdcInvestorPositionCombineDetailField(Pointer pointer) {
		super(pointer);
	}
}
