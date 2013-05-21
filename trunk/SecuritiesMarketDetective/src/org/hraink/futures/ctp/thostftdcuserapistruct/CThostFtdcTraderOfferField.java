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

public class CThostFtdcTraderOfferField extends StructObject {
	public CThostFtdcTraderOfferField() {
		super();
	}
	/// \u4ea4\u6613\u6240\u4ee3\u7801
	@Array({9}) 
	@Field(0) 
	public Pointer<Byte > ExchangeID() {
		return this.io.getPointerField(this, 0);
	}
	/// \u4ea4\u6613\u6240\u4ea4\u6613\u5458\u4ee3\u7801
	@Array({21}) 
	@Field(1) 
	public Pointer<Byte > TraderID() {
		return this.io.getPointerField(this, 1);
	}
	/// \u4f1a\u5458\u4ee3\u7801
	@Array({11}) 
	@Field(2) 
	public Pointer<Byte > ParticipantID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u5bc6\u7801
	@Array({41}) 
	@Field(3) 
	public Pointer<Byte > Password() {
		return this.io.getPointerField(this, 3);
	}
	/// \u5b89\u88c5\u7f16\u53f7
	@Field(4) 
	public int InstallID() {
		return this.io.getIntField(this, 4);
	}
	/// \u5b89\u88c5\u7f16\u53f7
	@Field(4) 
	public CThostFtdcTraderOfferField InstallID(int InstallID) {
		this.io.setIntField(this, 4, InstallID);
		return this;
	}
	/// \u672c\u5730\u62a5\u5355\u7f16\u53f7
	@Array({13}) 
	@Field(5) 
	public Pointer<Byte > OrderLocalID() {
		return this.io.getPointerField(this, 5);
	}
	/// \u4ea4\u6613\u6240\u4ea4\u6613\u5458\u8fde\u63a5\u72b6\u6001
	@Field(6) 
	public byte TraderConnectStatus() {
		return this.io.getByteField(this, 6);
	}
	/// \u4ea4\u6613\u6240\u4ea4\u6613\u5458\u8fde\u63a5\u72b6\u6001
	@Field(6) 
	public CThostFtdcTraderOfferField TraderConnectStatus(byte TraderConnectStatus) {
		this.io.setByteField(this, 6, TraderConnectStatus);
		return this;
	}
	/// \u53d1\u51fa\u8fde\u63a5\u8bf7\u6c42\u7684\u65e5\u671f
	@Array({9}) 
	@Field(7) 
	public Pointer<Byte > ConnectRequestDate() {
		return this.io.getPointerField(this, 7);
	}
	/// \u53d1\u51fa\u8fde\u63a5\u8bf7\u6c42\u7684\u65f6\u95f4
	@Array({9}) 
	@Field(8) 
	public Pointer<Byte > ConnectRequestTime() {
		return this.io.getPointerField(this, 8);
	}
	/// \u4e0a\u6b21\u62a5\u544a\u65e5\u671f
	@Array({9}) 
	@Field(9) 
	public Pointer<Byte > LastReportDate() {
		return this.io.getPointerField(this, 9);
	}
	/// \u4e0a\u6b21\u62a5\u544a\u65f6\u95f4
	@Array({9}) 
	@Field(10) 
	public Pointer<Byte > LastReportTime() {
		return this.io.getPointerField(this, 10);
	}
	/// \u5b8c\u6210\u8fde\u63a5\u65e5\u671f
	@Array({9}) 
	@Field(11) 
	public Pointer<Byte > ConnectDate() {
		return this.io.getPointerField(this, 11);
	}
	/// \u5b8c\u6210\u8fde\u63a5\u65f6\u95f4
	@Array({9}) 
	@Field(12) 
	public Pointer<Byte > ConnectTime() {
		return this.io.getPointerField(this, 12);
	}
	/// \u542f\u52a8\u65e5\u671f
	@Array({9}) 
	@Field(13) 
	public Pointer<Byte > StartDate() {
		return this.io.getPointerField(this, 13);
	}
	/// \u542f\u52a8\u65f6\u95f4
	@Array({9}) 
	@Field(14) 
	public Pointer<Byte > StartTime() {
		return this.io.getPointerField(this, 14);
	}
	/// \u4ea4\u6613\u65e5
	@Array({9}) 
	@Field(15) 
	public Pointer<Byte > TradingDay() {
		return this.io.getPointerField(this, 15);
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801
	@Array({11}) 
	@Field(16) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 16);
	}
	/// \u672c\u5e2d\u4f4d\u6700\u5927\u6210\u4ea4\u7f16\u53f7
	@Array({21}) 
	@Field(17) 
	public Pointer<Byte > MaxTradeID() {
		return this.io.getPointerField(this, 17);
	}
	/// \u672c\u5e2d\u4f4d\u6700\u5927\u62a5\u5355\u5907\u62f7
	@Array({7}) 
	@Field(18) 
	public Pointer<Byte > MaxOrderMessageReference() {
		return this.io.getPointerField(this, 18);
	}
	public CThostFtdcTraderOfferField(Pointer pointer) {
		super(pointer);
	}
}
