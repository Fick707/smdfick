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

public class CThostFtdcOpenAccountField extends StructObject {
	public CThostFtdcOpenAccountField() {
		super();
	}
	/// \u4e1a\u52a1\u529f\u80fd\u7801
	@Array({7}) 
	@Field(0) 
	public Pointer<Byte > TradeCode() {
		return this.io.getPointerField(this, 0);
	}
	/// \u94f6\u884c\u4ee3\u7801
	@Array({4}) 
	@Field(1) 
	public Pointer<Byte > BankID() {
		return this.io.getPointerField(this, 1);
	}
	/// \u94f6\u884c\u5206\u652f\u673a\u6784\u4ee3\u7801
	@Array({5}) 
	@Field(2) 
	public Pointer<Byte > BankBranchID() {
		return this.io.getPointerField(this, 2);
	}
	/// \u671f\u5546\u4ee3\u7801
	@Array({11}) 
	@Field(3) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 3);
	}
	/// \u671f\u5546\u5206\u652f\u673a\u6784\u4ee3\u7801
	@Array({31}) 
	@Field(4) 
	public Pointer<Byte > BrokerBranchID() {
		return this.io.getPointerField(this, 4);
	}
	/// \u4ea4\u6613\u65e5\u671f
	@Array({9}) 
	@Field(5) 
	public Pointer<Byte > TradeDate() {
		return this.io.getPointerField(this, 5);
	}
	/// \u4ea4\u6613\u65f6\u95f4
	@Array({9}) 
	@Field(6) 
	public Pointer<Byte > TradeTime() {
		return this.io.getPointerField(this, 6);
	}
	/// \u94f6\u884c\u6d41\u6c34\u53f7
	@Array({13}) 
	@Field(7) 
	public Pointer<Byte > BankSerial() {
		return this.io.getPointerField(this, 7);
	}
	/// \u4ea4\u6613\u7cfb\u7edf\u65e5\u671f
	@Array({9}) 
	@Field(8) 
	public Pointer<Byte > TradingDay() {
		return this.io.getPointerField(this, 8);
	}
	/// \u94f6\u671f\u5e73\u53f0\u6d88\u606f\u6d41\u6c34\u53f7
	@Field(9) 
	public int PlateSerial() {
		return this.io.getIntField(this, 9);
	}
	/// \u94f6\u671f\u5e73\u53f0\u6d88\u606f\u6d41\u6c34\u53f7
	@Field(9) 
	public CThostFtdcOpenAccountField PlateSerial(int PlateSerial) {
		this.io.setIntField(this, 9, PlateSerial);
		return this;
	}
	/// \u6700\u540e\u5206\u7247\u6807\u5fd7
	@Field(10) 
	public byte LastFragment() {
		return this.io.getByteField(this, 10);
	}
	/// \u6700\u540e\u5206\u7247\u6807\u5fd7
	@Field(10) 
	public CThostFtdcOpenAccountField LastFragment(byte LastFragment) {
		this.io.setByteField(this, 10, LastFragment);
		return this;
	}
	/// \u4f1a\u8bdd\u53f7
	@Field(11) 
	public int SessionID() {
		return this.io.getIntField(this, 11);
	}
	/// \u4f1a\u8bdd\u53f7
	@Field(11) 
	public CThostFtdcOpenAccountField SessionID(int SessionID) {
		this.io.setIntField(this, 11, SessionID);
		return this;
	}
	/// \u5ba2\u6237\u59d3\u540d
	@Array({51}) 
	@Field(12) 
	public Pointer<Byte > CustomerName() {
		return this.io.getPointerField(this, 12);
	}
	/// \u8bc1\u4ef6\u7c7b\u578b
	@Field(13) 
	public byte IdCardType() {
		return this.io.getByteField(this, 13);
	}
	/// \u8bc1\u4ef6\u7c7b\u578b
	@Field(13) 
	public CThostFtdcOpenAccountField IdCardType(byte IdCardType) {
		this.io.setByteField(this, 13, IdCardType);
		return this;
	}
	/// \u8bc1\u4ef6\u53f7\u7801
	@Array({51}) 
	@Field(14) 
	public Pointer<Byte > IdentifiedCardNo() {
		return this.io.getPointerField(this, 14);
	}
	/// \u6027\u522b
	@Field(15) 
	public byte Gender() {
		return this.io.getByteField(this, 15);
	}
	/// \u6027\u522b
	@Field(15) 
	public CThostFtdcOpenAccountField Gender(byte Gender) {
		this.io.setByteField(this, 15, Gender);
		return this;
	}
	/// \u56fd\u5bb6\u4ee3\u7801
	@Array({21}) 
	@Field(16) 
	public Pointer<Byte > CountryCode() {
		return this.io.getPointerField(this, 16);
	}
	/// \u5ba2\u6237\u7c7b\u578b
	@Field(17) 
	public byte CustType() {
		return this.io.getByteField(this, 17);
	}
	/// \u5ba2\u6237\u7c7b\u578b
	@Field(17) 
	public CThostFtdcOpenAccountField CustType(byte CustType) {
		this.io.setByteField(this, 17, CustType);
		return this;
	}
	/// \u5730\u5740
	@Array({101}) 
	@Field(18) 
	public Pointer<Byte > Address() {
		return this.io.getPointerField(this, 18);
	}
	/// \u90ae\u7f16
	@Array({7}) 
	@Field(19) 
	public Pointer<Byte > ZipCode() {
		return this.io.getPointerField(this, 19);
	}
	/// \u7535\u8bdd\u53f7\u7801
	@Array({41}) 
	@Field(20) 
	public Pointer<Byte > Telephone() {
		return this.io.getPointerField(this, 20);
	}
	/// \u624b\u673a
	@Array({21}) 
	@Field(21) 
	public Pointer<Byte > MobilePhone() {
		return this.io.getPointerField(this, 21);
	}
	/// \u4f20\u771f
	@Array({41}) 
	@Field(22) 
	public Pointer<Byte > Fax() {
		return this.io.getPointerField(this, 22);
	}
	/// \u7535\u5b50\u90ae\u4ef6
	@Array({41}) 
	@Field(23) 
	public Pointer<Byte > EMail() {
		return this.io.getPointerField(this, 23);
	}
	/// \u8d44\u91d1\u8d26\u6237\u72b6\u6001
	@Field(24) 
	public byte MoneyAccountStatus() {
		return this.io.getByteField(this, 24);
	}
	/// \u8d44\u91d1\u8d26\u6237\u72b6\u6001
	@Field(24) 
	public CThostFtdcOpenAccountField MoneyAccountStatus(byte MoneyAccountStatus) {
		this.io.setByteField(this, 24, MoneyAccountStatus);
		return this;
	}
	/// \u94f6\u884c\u5e10\u53f7
	@Array({41}) 
	@Field(25) 
	public Pointer<Byte > BankAccount() {
		return this.io.getPointerField(this, 25);
	}
	/// \u94f6\u884c\u5bc6\u7801
	@Array({41}) 
	@Field(26) 
	public Pointer<Byte > BankPassWord() {
		return this.io.getPointerField(this, 26);
	}
	/// \u6295\u8d44\u8005\u5e10\u53f7
	@Array({13}) 
	@Field(27) 
	public Pointer<Byte > AccountID() {
		return this.io.getPointerField(this, 27);
	}
	/// \u671f\u8d27\u5bc6\u7801
	@Array({41}) 
	@Field(28) 
	public Pointer<Byte > Password() {
		return this.io.getPointerField(this, 28);
	}
	/// \u5b89\u88c5\u7f16\u53f7
	@Field(29) 
	public int InstallID() {
		return this.io.getIntField(this, 29);
	}
	/// \u5b89\u88c5\u7f16\u53f7
	@Field(29) 
	public CThostFtdcOpenAccountField InstallID(int InstallID) {
		this.io.setIntField(this, 29, InstallID);
		return this;
	}
	/// \u9a8c\u8bc1\u5ba2\u6237\u8bc1\u4ef6\u53f7\u7801\u6807\u5fd7
	@Field(30) 
	public byte VerifyCertNoFlag() {
		return this.io.getByteField(this, 30);
	}
	/// \u9a8c\u8bc1\u5ba2\u6237\u8bc1\u4ef6\u53f7\u7801\u6807\u5fd7
	@Field(30) 
	public CThostFtdcOpenAccountField VerifyCertNoFlag(byte VerifyCertNoFlag) {
		this.io.setByteField(this, 30, VerifyCertNoFlag);
		return this;
	}
	/// \u5e01\u79cd\u4ee3\u7801
	@Array({4}) 
	@Field(31) 
	public Pointer<Byte > CurrencyID() {
		return this.io.getPointerField(this, 31);
	}
	/// \u6c47\u949e\u6807\u5fd7
	@Field(32) 
	public byte CashExchangeCode() {
		return this.io.getByteField(this, 32);
	}
	/// \u6c47\u949e\u6807\u5fd7
	@Field(32) 
	public CThostFtdcOpenAccountField CashExchangeCode(byte CashExchangeCode) {
		this.io.setByteField(this, 32, CashExchangeCode);
		return this;
	}
	/// \u6458\u8981
	@Array({36}) 
	@Field(33) 
	public Pointer<Byte > Digest() {
		return this.io.getPointerField(this, 33);
	}
	/// \u94f6\u884c\u5e10\u53f7\u7c7b\u578b
	@Field(34) 
	public byte BankAccType() {
		return this.io.getByteField(this, 34);
	}
	/// \u94f6\u884c\u5e10\u53f7\u7c7b\u578b
	@Field(34) 
	public CThostFtdcOpenAccountField BankAccType(byte BankAccType) {
		this.io.setByteField(this, 34, BankAccType);
		return this;
	}
	/// \u6e20\u9053\u6807\u5fd7
	@Array({3}) 
	@Field(35) 
	public Pointer<Byte > DeviceID() {
		return this.io.getPointerField(this, 35);
	}
	/// \u671f\u8d27\u5355\u4f4d\u5e10\u53f7\u7c7b\u578b
	@Field(36) 
	public byte BankSecuAccType() {
		return this.io.getByteField(this, 36);
	}
	/// \u671f\u8d27\u5355\u4f4d\u5e10\u53f7\u7c7b\u578b
	@Field(36) 
	public CThostFtdcOpenAccountField BankSecuAccType(byte BankSecuAccType) {
		this.io.setByteField(this, 36, BankSecuAccType);
		return this;
	}
	/// \u671f\u8d27\u516c\u53f8\u94f6\u884c\u7f16\u7801
	@Array({33}) 
	@Field(37) 
	public Pointer<Byte > BrokerIDByBank() {
		return this.io.getPointerField(this, 37);
	}
	/// \u671f\u8d27\u5355\u4f4d\u5e10\u53f7
	@Array({41}) 
	@Field(38) 
	public Pointer<Byte > BankSecuAcc() {
		return this.io.getPointerField(this, 38);
	}
	/// \u94f6\u884c\u5bc6\u7801\u6807\u5fd7
	@Field(39) 
	public byte BankPwdFlag() {
		return this.io.getByteField(this, 39);
	}
	/// \u94f6\u884c\u5bc6\u7801\u6807\u5fd7
	@Field(39) 
	public CThostFtdcOpenAccountField BankPwdFlag(byte BankPwdFlag) {
		this.io.setByteField(this, 39, BankPwdFlag);
		return this;
	}
	/// \u671f\u8d27\u8d44\u91d1\u5bc6\u7801\u6838\u5bf9\u6807\u5fd7
	@Field(40) 
	public byte SecuPwdFlag() {
		return this.io.getByteField(this, 40);
	}
	/// \u671f\u8d27\u8d44\u91d1\u5bc6\u7801\u6838\u5bf9\u6807\u5fd7
	@Field(40) 
	public CThostFtdcOpenAccountField SecuPwdFlag(byte SecuPwdFlag) {
		this.io.setByteField(this, 40, SecuPwdFlag);
		return this;
	}
	/// \u4ea4\u6613\u67dc\u5458
	@Array({17}) 
	@Field(41) 
	public Pointer<Byte > OperNo() {
		return this.io.getPointerField(this, 41);
	}
	/// \u4ea4\u6613ID
	@Field(42) 
	public int TID() {
		return this.io.getIntField(this, 42);
	}
	/// \u4ea4\u6613ID
	@Field(42) 
	public CThostFtdcOpenAccountField TID(int TID) {
		this.io.setIntField(this, 42, TID);
		return this;
	}
	/// \u7528\u6237\u6807\u8bc6
	@Array({16}) 
	@Field(43) 
	public Pointer<Byte > UserID() {
		return this.io.getPointerField(this, 43);
	}
	/// \u9519\u8bef\u4ee3\u7801
	@Field(44) 
	public int ErrorID() {
		return this.io.getIntField(this, 44);
	}
	/// \u9519\u8bef\u4ee3\u7801
	@Field(44) 
	public CThostFtdcOpenAccountField ErrorID(int ErrorID) {
		this.io.setIntField(this, 44, ErrorID);
		return this;
	}
	/// \u9519\u8bef\u4fe1\u606f
	@Array({81}) 
	@Field(45) 
	public Pointer<Byte > ErrorMsg() {
		return this.io.getPointerField(this, 45);
	}
	public CThostFtdcOpenAccountField(Pointer pointer) {
		super(pointer);
	}
}
