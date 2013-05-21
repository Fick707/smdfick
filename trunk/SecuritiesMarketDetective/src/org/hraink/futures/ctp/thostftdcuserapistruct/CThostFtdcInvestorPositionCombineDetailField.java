package org.hraink.futures.ctp.thostftdcuserapistruct;import org.bridj.Pointer;import org.bridj.StructObject;import org.bridj.ann.Array;import org.bridj.ann.Field;import org.bridj.ann.Library;/** * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br> * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br> * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> . *//** * 投资者组合持仓明细 * @author Hraink E-mail:Hraink@Gmail.com * @version 2013-1-31 下午11:24:11 */public class CThostFtdcInvestorPositionCombineDetailField extends StructObject {	public CThostFtdcInvestorPositionCombineDetailField() {		super();	}	/**	 * \u4ea4\u6613\u65e5	 */	@Array({9}) 	@Field(0) 	private Pointer<Byte> TradingDay() {		return this.io.getPointerField(this, 0);	}	@Array({9})	@Field(0)	public void setTradingDay(String tradingDay) {		this.io.getPointerField(this, 0).setCString(tradingDay);	}	public String getTradingDay() {		return TradingDay().getCString();	}	/**	 * \u5f00\u4ed3\u65e5\u671f	 */	@Array({9}) 	@Field(1) 	private Pointer<Byte> OpenDate() {		return this.io.getPointerField(this, 1);	}	@Array({9})	@Field(1)	public void setOpenDate(String openDate) {		this.io.getPointerField(this, 1).setCString(openDate);	}	public String getOpenDate() {		return OpenDate().getCString();	}	/**	 * \u4ea4\u6613\u6240\u4ee3\u7801	 */	@Array({9}) 	@Field(2) 	private Pointer<Byte> ExchangeID() {		return this.io.getPointerField(this, 2);	}	@Array({9})	@Field(2)	public void setExchangeID(String exchangeID) {		this.io.getPointerField(this, 2).setCString(exchangeID);	}	public String getExchangeID() {		return ExchangeID().getCString();	}	/**	 * \u7ed3\u7b97\u7f16\u53f7	 */	@Field(3) 	private int SettlementID() {		return this.io.getIntField(this, 3);	}	public int getSettlementID() {		return SettlementID();	}	/**	 * \u7ed3\u7b97\u7f16\u53f7	 */	@Field(3) 	private CThostFtdcInvestorPositionCombineDetailField SettlementID(int SettlementID) {		this.io.setIntField(this, 3, SettlementID);		return this;	}	public void setSettlementID(int settlementID) {		SettlementID(settlementID);	}	/**	 * \u7ecf\u7eaa\u516c\u53f8\u4ee3\u7801	 */	@Array({11}) 	@Field(4) 	private Pointer<Byte> BrokerID() {		return this.io.getPointerField(this, 4);	}	@Array({11})	@Field(4)	public void setBrokerID(String brokerID) {		this.io.getPointerField(this, 4).setCString(brokerID);	}	public String getBrokerID() {		return BrokerID().getCString();	}	/**	 * \u6295\u8d44\u8005\u4ee3\u7801	 */	@Array({13}) 	@Field(5) 	private Pointer<Byte> InvestorID() {		return this.io.getPointerField(this, 5);	}	@Array({13})	@Field(5)	public void setInvestorID(String investorID) {		this.io.getPointerField(this, 5).setCString(investorID);	}	public String getInvestorID() {		return InvestorID().getCString();	}	/**	 * \u7ec4\u5408\u7f16\u53f7	 */	@Array({21}) 	@Field(6) 	private Pointer<Byte> ComTradeID() {		return this.io.getPointerField(this, 6);	}	@Array({21})	@Field(6)	public void setComTradeID(String comTradeID) {		this.io.getPointerField(this, 6).setCString(comTradeID);	}	public String getComTradeID() {		return ComTradeID().getCString();	}	/**	 * \u64ae\u5408\u7f16\u53f7	 */	@Array({21}) 	@Field(7) 	private Pointer<Byte> TradeID() {		return this.io.getPointerField(this, 7);	}	@Array({21})	@Field(7)	public void setTradeID(String tradeID) {		this.io.getPointerField(this, 7).setCString(tradeID);	}	public String getTradeID() {		return TradeID().getCString();	}	/**	 * \u5408\u7ea6\u4ee3\u7801	 */	@Array({31}) 	@Field(8) 	private Pointer<Byte> InstrumentID() {		return this.io.getPointerField(this, 8);	}	@Array({31})	@Field(8)	public void setInstrumentID(String instrumentID) {		this.io.getPointerField(this, 8).setCString(instrumentID);	}	public String getInstrumentID() {		return InstrumentID().getCString();	}	/**	 * \u6295\u673a\u5957\u4fdd\u6807\u5fd7	 */	@Field(9) 	private byte HedgeFlag() {		return this.io.getByteField(this, 9);	}	public char getHedgeFlag() {		return (char)HedgeFlag();	}	/**	 * \u6295\u673a\u5957\u4fdd\u6807\u5fd7	 */	@Field(9) 	private CThostFtdcInvestorPositionCombineDetailField HedgeFlag(byte HedgeFlag) {		this.io.setByteField(this, 9, HedgeFlag);		return this;	}	public void setHedgeFlag(char hedgeFlag) {		HedgeFlag((byte)hedgeFlag);	}	/**	 * \u4e70\u5356	 */	@Field(10) 	private byte Direction() {		return this.io.getByteField(this, 10);	}	public char getDirection() {		return (char)Direction();	}	/**	 * \u4e70\u5356	 */	@Field(10) 	private CThostFtdcInvestorPositionCombineDetailField Direction(byte Direction) {		this.io.setByteField(this, 10, Direction);		return this;	}	public void setDirection(char direction) {		Direction((byte)direction);	}	/**	 * \u6301\u4ed3\u91cf	 */	@Field(11) 	private int TotalAmt() {		return this.io.getIntField(this, 11);	}	public int getTotalAmt() {		return TotalAmt();	}	/**	 * \u6301\u4ed3\u91cf	 */	@Field(11) 	private CThostFtdcInvestorPositionCombineDetailField TotalAmt(int TotalAmt) {		this.io.setIntField(this, 11, TotalAmt);		return this;	}	public void setTotalAmt(int totalAmt) {		TotalAmt(totalAmt);	}	/**	 * \u6295\u8d44\u8005\u4fdd\u8bc1\u91d1	 */	@Field(12) 	private double Margin() {		return this.io.getDoubleField(this, 12);	}	public double getMargin() {		return Margin();	}	/**	 * \u6295\u8d44\u8005\u4fdd\u8bc1\u91d1	 */	@Field(12) 	private CThostFtdcInvestorPositionCombineDetailField Margin(double Margin) {		this.io.setDoubleField(this, 12, Margin);		return this;	}	public void setMargin(double margin) {		Margin(margin);	}	/**	 * \u4ea4\u6613\u6240\u4fdd\u8bc1\u91d1	 */	@Field(13) 	private double ExchMargin() {		return this.io.getDoubleField(this, 13);	}	public double getExchMargin() {		return ExchMargin();	}	/**	 * \u4ea4\u6613\u6240\u4fdd\u8bc1\u91d1	 */	@Field(13) 	private CThostFtdcInvestorPositionCombineDetailField ExchMargin(double ExchMargin) {		this.io.setDoubleField(this, 13, ExchMargin);		return this;	}	public void setExchMargin(double exchMargin) {		ExchMargin(exchMargin);	}	/**	 * \u4fdd\u8bc1\u91d1\u7387	 */	@Field(14) 	private double MarginRateByMoney() {		return this.io.getDoubleField(this, 14);	}	public double getMarginRateByMoney() {		return MarginRateByMoney();	}	/**	 * \u4fdd\u8bc1\u91d1\u7387	 */	@Field(14) 	private CThostFtdcInvestorPositionCombineDetailField MarginRateByMoney(double MarginRateByMoney) {		this.io.setDoubleField(this, 14, MarginRateByMoney);		return this;	}	public void setMarginRateByMoney(double marginRateByMoney) {		MarginRateByMoney(marginRateByMoney);	}	/**	 * \u4fdd\u8bc1\u91d1\u7387(\u6309\u624b\u6570)	 */	@Field(15) 	private double MarginRateByVolume() {		return this.io.getDoubleField(this, 15);	}	public double getMarginRateByVolume() {		return MarginRateByVolume();	}	/**	 * \u4fdd\u8bc1\u91d1\u7387(\u6309\u624b\u6570)	 */	@Field(15) 	private CThostFtdcInvestorPositionCombineDetailField MarginRateByVolume(double MarginRateByVolume) {		this.io.setDoubleField(this, 15, MarginRateByVolume);		return this;	}	public void setMarginRateByVolume(double marginRateByVolume) {		MarginRateByVolume(marginRateByVolume);	}	/**	 * \u5355\u817f\u7f16\u53f7	 */	@Field(16) 	private int LegID() {		return this.io.getIntField(this, 16);	}	public int getLegID() {		return LegID();	}	/**	 * \u5355\u817f\u7f16\u53f7	 */	@Field(16) 	private CThostFtdcInvestorPositionCombineDetailField LegID(int LegID) {		this.io.setIntField(this, 16, LegID);		return this;	}	public void setLegID(int legID) {		LegID(legID);	}	/**	 * \u5355\u817f\u4e58\u6570	 */	@Field(17) 	private int LegMultiple() {		return this.io.getIntField(this, 17);	}	public int getLegMultiple() {		return LegMultiple();	}	/**	 * \u5355\u817f\u4e58\u6570	 */	@Field(17) 	private CThostFtdcInvestorPositionCombineDetailField LegMultiple(int LegMultiple) {		this.io.setIntField(this, 17, LegMultiple);		return this;	}	public void setLegMultiple(int legMultiple) {		LegMultiple(legMultiple);	}	/**	 * \u7ec4\u5408\u6301\u4ed3\u5408\u7ea6\u7f16\u7801	 */	@Array({31}) 	@Field(18) 	private Pointer<Byte> CombInstrumentID() {		return this.io.getPointerField(this, 18);	}	@Array({31})	@Field(18)	public void setCombInstrumentID(String combInstrumentID) {		this.io.getPointerField(this, 18).setCString(combInstrumentID);	}	public String getCombInstrumentID() {		return CombInstrumentID().getCString();	}	public CThostFtdcInvestorPositionCombineDetailField(Pointer pointer) {		super(pointer);	}}