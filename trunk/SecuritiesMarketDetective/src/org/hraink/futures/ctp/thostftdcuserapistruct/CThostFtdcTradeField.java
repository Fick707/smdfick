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

public class CThostFtdcTradeField extends StructObject {
	public CThostFtdcTradeField() {
		super();
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801
	@Array({11}) 
	@Field(0) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 0);
	}
	/// \u6295\u8d44\u8005\u4ee3\u7801
	@Array({13}) 
	@Field(1) 
	public Pointer<Byte > InvestorID() {
		return this.io.getPointerField(this, 1);
	}
	/// \u5408\u7ea6\u4ee3\u7801
	@Array({31}) 
	@Field(2) 
	public Pointer<Byte > InstrumentID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u62a5\u5355\u5f15\u7528
	@Array({13}) 
	@Field(3) 
	public Pointer<Byte > OrderRef() {
		return this.io.getPointerField(this, 3);
	}
	/// \u7528\u6237\u4ee3\u7801
	@Array({16}) 
	@Field(4) 
	public Pointer<Byte > UserID() {
		return this.io.getPointerField(this, 4);
	}
	/// \u4ea4\u6613\u6240\u4ee3\u7801
	@Array({9}) 
	@Field(5) 
	public Pointer<Byte > ExchangeID() {
		return this.io.getPointerField(this, 5);
	}
	/// \u6210\u4ea4\u7f16\u53f7
	@Array({21}) 
	@Field(6) 
	public Pointer<Byte > TradeID() {
		return this.io.getPointerField(this, 6);
	}
	/// \u4e70\u5356\u65b9\u5411
	@Field(7) 
	public byte Direction() {
		return this.io.getByteField(this, 7);
	}
	/// \u4e70\u5356\u65b9\u5411
	@Field(7) 
	public CThostFtdcTradeField Direction(byte Direction) {
		this.io.setByteField(this, 7, Direction);
		return this;
	}
	/// \u62a5\u5355\u7f16\u53f7
	@Array({21}) 
	@Field(8) 
	public Pointer<Byte > OrderSysID() {
		return this.io.getPointerField(this, 8);
	}
	/// \u4f1a\u5458\u4ee3\u7801
	@Array({11}) 
	@Field(9) 
	public Pointer<Byte > ParticipantID() {
		return this.io.getPointerField(this, 9);
	}
	/// \u5ba2\u6237\u4ee3\u7801
	@Array({11}) 
	@Field(10) 
	public Pointer<Byte > ClientID() {
		return this.io.getPointerField(this, 10);
	}
	/// \u4ea4\u6613\u89d2\u8272
	@Field(11) 
	public byte TradingRole() {
		return this.io.getByteField(this, 11);
	}
	/// \u4ea4\u6613\u89d2\u8272
	@Field(11) 
	public CThostFtdcTradeField TradingRole(byte TradingRole) {
		this.io.setByteField(this, 11, TradingRole);
		return this;
	}
	/// \u5408\u7ea6\u5728\u4ea4\u6613\u6240\u7684\u4ee3\u7801
	@Array({31}) 
	@Field(12) 
	public Pointer<Byte > ExchangeInstID() {
		return this.io.getPointerField(this, 12);
	}
	/// \u5f00\u5e73\u6807\u5fd7
	@Field(13) 
	public byte OffsetFlag() {
		return this.io.getByteField(this, 13);
	}
	/// \u5f00\u5e73\u6807\u5fd7
	@Field(13) 
	public CThostFtdcTradeField OffsetFlag(byte OffsetFlag) {
		this.io.setByteField(this, 13, OffsetFlag);
		return this;
	}
	/// \u6295\u673a\u5957\u4fdd\u6807\u5fd7
	@Field(14) 
	public byte HedgeFlag() {
		return this.io.getByteField(this, 14);
	}
	/// \u6295\u673a\u5957\u4fdd\u6807\u5fd7
	@Field(14) 
	public CThostFtdcTradeField HedgeFlag(byte HedgeFlag) {
		this.io.setByteField(this, 14, HedgeFlag);
		return this;
	}
	/// \u4ef7\u683c
	@Field(15) 
	public double Price() {
		return this.io.getDoubleField(this, 15);
	}
	/// \u4ef7\u683c
	@Field(15) 
	public CThostFtdcTradeField Price(double Price) {
		this.io.setDoubleField(this, 15, Price);
		return this;
	}
	/// \u6570\u91cf
	@Field(16) 
	public int Volume() {
		return this.io.getIntField(this, 16);
	}
	/// \u6570\u91cf
	@Field(16) 
	public CThostFtdcTradeField Volume(int Volume) {
		this.io.setIntField(this, 16, Volume);
		return this;
	}
	/// \u6210\u4ea4\u65f6\u671f
	@Array({9}) 
	@Field(17) 
	public Pointer<Byte > TradeDate() {
		return this.io.getPointerField(this, 17);
	}
	/// \u6210\u4ea4\u65f6\u95f4
	@Array({9}) 
	@Field(18) 
	public Pointer<Byte > TradeTime() {
		return this.io.getPointerField(this, 18);
	}
	/// \u6210\u4ea4\u7c7b\u578b
	@Field(19) 
	public byte TradeType() {
		return this.io.getByteField(this, 19);
	}
	/// \u6210\u4ea4\u7c7b\u578b
	@Field(19) 
	public CThostFtdcTradeField TradeType(byte TradeType) {
		this.io.setByteField(this, 19, TradeType);
		return this;
	}
	/// \u6210\u4ea4\u4ef7\u6765\u6e90
	@Field(20) 
	public byte PriceSource() {
		return this.io.getByteField(this, 20);
	}
	/// \u6210\u4ea4\u4ef7\u6765\u6e90
	@Field(20) 
	public CThostFtdcTradeField PriceSource(byte PriceSource) {
		this.io.setByteField(this, 20, PriceSource);
		return this;
	}
	/// \u4ea4\u6613\u6240\u4ea4\u6613\u5458\u4ee3\u7801
	@Array({21}) 
	@Field(21) 
	public Pointer<Byte > TraderID() {
		return this.io.getPointerField(this, 21);
	}
	/// \u672c\u5730\u62a5\u5355\u7f16\u53f7
	@Array({13}) 
	@Field(22) 
	public Pointer<Byte > OrderLocalID() {
		return this.io.getPointerField(this, 22);
	}
	/// \u7ed3\u7b97\u4f1a\u5458\u7f16\u53f7
	@Array({11}) 
	@Field(23) 
	public Pointer<Byte > ClearingPartID() {
		return this.io.getPointerField(this, 23);
	}
	/// \u4e1a\u52a1\u5355\u5143
	@Array({21}) 
	@Field(24) 
	public Pointer<Byte > BusinessUnit() {
		return this.io.getPointerField(this, 24);
	}
	/// \u5e8f\u53f7
	@Field(25) 
	public int SequenceNo() {
		return this.io.getIntField(this, 25);
	}
	/// \u5e8f\u53f7
	@Field(25) 
	public CThostFtdcTradeField SequenceNo(int SequenceNo) {
		this.io.setIntField(this, 25, SequenceNo);
		return this;
	}
	/// \u4ea4\u6613\u65e5
	@Array({9}) 
	@Field(26) 
	public Pointer<Byte > TradingDay() {
		return this.io.getPointerField(this, 26);
	}
	/// \u7ed3\u7b97\u7f16\u53f7
	@Field(27) 
	public int SettlementID() {
		return this.io.getIntField(this, 27);
	}
	/// \u7ed3\u7b97\u7f16\u53f7
	@Field(27) 
	public CThostFtdcTradeField SettlementID(int SettlementID) {
		this.io.setIntField(this, 27, SettlementID);
		return this;
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u62a5\u5355\u7f16\u53f7
	@Field(28) 
	public int BrokerOrderSeq() {
		return this.io.getIntField(this, 28);
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u62a5\u5355\u7f16\u53f7
	@Field(28) 
	public CThostFtdcTradeField BrokerOrderSeq(int BrokerOrderSeq) {
		this.io.setIntField(this, 28, BrokerOrderSeq);
		return this;
	}
	/// \u6210\u4ea4\u6765\u6e90
	@Field(29) 
	public byte TradeSource() {
		return this.io.getByteField(this, 29);
	}
	/// \u6210\u4ea4\u6765\u6e90
	@Field(29) 
	public CThostFtdcTradeField TradeSource(byte TradeSource) {
		this.io.setByteField(this, 29, TradeSource);
		return this;
	}
	public CThostFtdcTradeField(Pointer pointer) {
		super(pointer);
	}
}
