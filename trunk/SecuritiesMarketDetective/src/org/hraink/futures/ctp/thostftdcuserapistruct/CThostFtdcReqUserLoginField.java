package org.hraink.futures.ctp.thostftdcuserapistruct;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;


public class CThostFtdcReqUserLoginField extends StructObject {
	public CThostFtdcReqUserLoginField() {
		super();
	}
	/// \u4ea4\u6613\u65e5
	/// \u4ea4\u6613\u65e5
	@Array({9}) 
	@Field(0) 
	public Pointer<Byte > TradingDay() {
		return this.io.getPointerField(this, 0);
	}
	/// \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801
	@Array({11}) 
	@Field(1) 
	public Pointer<Byte > BrokerID() {
		return this.io.getPointerField(this, 1);
	}	
	
	@Array({11}) 
	@Field(1) 
	public CThostFtdcReqUserLoginField BrokerID(Pointer<Byte> brokerId) {
		this.io.getPointerField(this, 1).setCString(brokerId.getCString());
		return this;
	}
	public final String BrokerID(String brokerId) {
		BrokerID(Pointer.pointerToCString(brokerId));
		return brokerId;
	}
	/// \u7528\u6237\u4ee3\u7801
	@Array({16}) 
	@Field(2) 
	public Pointer<Byte > UserID() {
		return this.io.getPointerField(this, 2);
	}
	
	@Array({16}) 
	@Field(2) 
	public CThostFtdcReqUserLoginField UserID(Pointer<Byte> userId) {
		//this.io.setPointerField(this, 2, userId);
		this.io.getPointerField(this, 2).setCString(userId.getCString());
		return this;
	}
	
	public final String UserID(String userId) {
		UserID(Pointer.pointerToCString(userId));
		return userId;
	}
	/// \u5bc6\u7801
	@Array({41}) 
	@Field(3) 
	public Pointer<Byte > Password() {
		return this.io.getPointerField(this, 3);
	}
	
	@Array({41}) 
	@Field(3) 
	public CThostFtdcReqUserLoginField Password(Pointer<Byte> passWord) {
		this.io.getPointerField(this, 3).setCString(passWord.getCString());
		return this;
	}
	
	public final String Password(String passWord) {
		Password(Pointer.pointerToCString(passWord));
		return passWord;
	}
	
	/// \u7528\u6237\u7aef\u4ea7\u54c1\u4fe1\u606f
	@Array({11}) 
	@Field(4) 
	public Pointer<Byte > UserProductInfo() {
		return this.io.getPointerField(this, 4);
	}
	/// \u63a5\u53e3\u7aef\u4ea7\u54c1\u4fe1\u606f
	@Array({11}) 
	@Field(5) 
	public Pointer<Byte > InterfaceProductInfo() {
		return this.io.getPointerField(this, 5);
	}
	/// \u534f\u8bae\u4fe1\u606f
	@Array({11}) 
	@Field(6) 
	public Pointer<Byte > ProtocolInfo() {
		return this.io.getPointerField(this, 6);
	}
	/// Mac\u5730\u5740
	@Array({21}) 
	@Field(7) 
	public Pointer<Byte > MacAddress() {
		return this.io.getPointerField(this, 7);
	}
	/// \u52a8\u6001\u5bc6\u7801
	@Array({41}) 
	@Field(8) 
	public Pointer<Byte > OneTimePassword() {
		return this.io.getPointerField(this, 8);
	}
	/// \u7ec8\u7aefIP\u5730\u5740
	@Array({16}) 
	@Field(9) 
	public Pointer<Byte > ClientIPAddress() {
		return this.io.getPointerField(this, 9);
	}
	public CThostFtdcReqUserLoginField(Pointer pointer) {
		super(pointer);
	}
}
