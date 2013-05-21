package org.hraink.futures.ctp.thosttraderapi;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Ptr;
import org.bridj.ann.Virtual;
import org.bridj.cpp.CPPObject;
import org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_TE_RESUME_TYPE;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcParkedOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcParkedOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryAccountregisterField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryBrokerTradingAlgosField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryBrokerTradingParamsField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryCFMMCTradingAccountKeyField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryContractBankField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryDepthMarketDataField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryEWarrantOffsetField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryExchangeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInstrumentCommissionRateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInstrumentField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInstrumentMarginRateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInvestorField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInvestorPositionCombineDetailField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInvestorPositionDetailField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInvestorPositionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryNoticeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryParkedOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryParkedOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQrySettlementInfoConfirmField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQrySettlementInfoField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryTradeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryTradingAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryTradingCodeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryTradingNoticeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryTransferBankField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryTransferSerialField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQueryMaxOrderVolumeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRemoveParkedOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRemoveParkedOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqAuthenticateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqQueryAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqTransferField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcSettlementInfoConfirmField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradingAccountPasswordUpdateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserLogoutField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserPasswordUpdateField;
import org.hraink.futures.ctp.util.JCTPLibraryUtil;

/**
 * CTP交易API
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-25 下午11:27:51
 */
@Library("thosttraderapi") 
public class CThostFtdcTraderApi extends CPPObject {
	public CThostFtdcTraderApi() {
		super();
	}
	
	public native static Pointer<CThostFtdcTraderApi > CreateFtdcTraderApi(Pointer<Byte > pszFlowPath, boolean bIsUsingUdp);
	
	@Virtual(0) 
	native public void Release();
	@Virtual(1) 
	native public void Init();
	@Virtual(2) 
	native public int Join();
	@Virtual(3) 
	public Pointer<Byte > GetTradingDay() {
		return Pointer.pointerToAddress(GetTradingDay$2(), Byte.class);
	}
	@Ptr 
	@Name("GetTradingDay") 
	@Virtual(3) 
	protected native long GetTradingDay$2();
	@Virtual(4) 
	public void RegisterFront(Pointer<Byte > pszFrontAddress) {
		RegisterFront(Pointer.getPeer(pszFrontAddress));
	}
	@Virtual(4) 
	protected native void RegisterFront(@Ptr long pszFrontAddress);
	@Virtual(5) 
	public void RegisterNameServer(Pointer<Byte > pszNsAddress) {
		RegisterNameServer(Pointer.getPeer(pszNsAddress));
	}
	@Virtual(5) 
	protected native void RegisterNameServer(@Ptr long pszNsAddress);
	@Virtual(6) 
	public void RegisterSpi(Pointer<CThostFtdcTraderSpi > pSpi) {
		RegisterSpi(Pointer.getPeer(pSpi));
	}
	@Virtual(6) 
	protected native void RegisterSpi(@Ptr long pSpi);
	@Virtual(7) 
	public void SubscribePrivateTopic(IntValuedEnum<THOST_TE_RESUME_TYPE > nResumeType) {
		SubscribePrivateTopic((int)nResumeType.value());
	}
	@Virtual(7) 
	protected native void SubscribePrivateTopic(int nResumeType);
	@Virtual(8) 
	public void SubscribePublicTopic(IntValuedEnum<THOST_TE_RESUME_TYPE > nResumeType) {
		SubscribePublicTopic((int)nResumeType.value());
	}
	@Virtual(8) 
	protected native void SubscribePublicTopic(int nResumeType);
	@Virtual(9) 
	public int ReqAuthenticate(Pointer<CThostFtdcReqAuthenticateField > pReqAuthenticateField, int nRequestID) {
		return ReqAuthenticate(Pointer.getPeer(pReqAuthenticateField), nRequestID);
	}
	@Virtual(9) 
	protected native int ReqAuthenticate(@Ptr long pReqAuthenticateField, int nRequestID);
	@Virtual(10) 
	public int ReqUserLogin(Pointer<CThostFtdcReqUserLoginField > pReqUserLoginField, int nRequestID) {
		return ReqUserLogin(Pointer.getPeer(pReqUserLoginField), nRequestID);
	}
	@Virtual(10) 
	protected native int ReqUserLogin(@Ptr long pReqUserLoginField, int nRequestID);
	@Virtual(11) 
	public int ReqUserLogout(Pointer<CThostFtdcUserLogoutField > pUserLogout, int nRequestID) {
		return ReqUserLogout(Pointer.getPeer(pUserLogout), nRequestID);
	}
	@Virtual(11) 
	protected native int ReqUserLogout(@Ptr long pUserLogout, int nRequestID);
	@Virtual(12) 
	public int ReqUserPasswordUpdate(Pointer<CThostFtdcUserPasswordUpdateField > pUserPasswordUpdate, int nRequestID) {
		return ReqUserPasswordUpdate(Pointer.getPeer(pUserPasswordUpdate), nRequestID);
	}
	@Virtual(12) 
	protected native int ReqUserPasswordUpdate(@Ptr long pUserPasswordUpdate, int nRequestID);
	@Virtual(13) 
	public int ReqTradingAccountPasswordUpdate(Pointer<CThostFtdcTradingAccountPasswordUpdateField > pTradingAccountPasswordUpdate, int nRequestID) {
		return ReqTradingAccountPasswordUpdate(Pointer.getPeer(pTradingAccountPasswordUpdate), nRequestID);
	}
	@Virtual(13) 
	protected native int ReqTradingAccountPasswordUpdate(@Ptr long pTradingAccountPasswordUpdate, int nRequestID);
	@Virtual(14) 
	public int ReqOrderInsert(Pointer<CThostFtdcInputOrderField > pInputOrder, int nRequestID) {
		return ReqOrderInsert(Pointer.getPeer(pInputOrder), nRequestID);
	}
	@Virtual(14) 
	protected native int ReqOrderInsert(@Ptr long pInputOrder, int nRequestID);
	@Virtual(15) 
	public int ReqParkedOrderInsert(Pointer<CThostFtdcParkedOrderField > pParkedOrder, int nRequestID) {
		return ReqParkedOrderInsert(Pointer.getPeer(pParkedOrder), nRequestID);
	}
	@Virtual(15) 
	protected native int ReqParkedOrderInsert(@Ptr long pParkedOrder, int nRequestID);
	@Virtual(16) 
	public int ReqParkedOrderAction(Pointer<CThostFtdcParkedOrderActionField > pParkedOrderAction, int nRequestID) {
		return ReqParkedOrderAction(Pointer.getPeer(pParkedOrderAction), nRequestID);
	}
	@Virtual(16) 
	protected native int ReqParkedOrderAction(@Ptr long pParkedOrderAction, int nRequestID);
	@Virtual(17) 
	public int ReqOrderAction(Pointer<CThostFtdcInputOrderActionField > pInputOrderAction, int nRequestID) {
		return ReqOrderAction(Pointer.getPeer(pInputOrderAction), nRequestID);
	}
	@Virtual(17) 
	protected native int ReqOrderAction(@Ptr long pInputOrderAction, int nRequestID);
	@Virtual(18) 
	public int ReqQueryMaxOrderVolume(Pointer<CThostFtdcQueryMaxOrderVolumeField > pQueryMaxOrderVolume, int nRequestID) {
		return ReqQueryMaxOrderVolume(Pointer.getPeer(pQueryMaxOrderVolume), nRequestID);
	}
	@Virtual(18) 
	protected native int ReqQueryMaxOrderVolume(@Ptr long pQueryMaxOrderVolume, int nRequestID);
	@Virtual(19) 
	public int ReqSettlementInfoConfirm(Pointer<CThostFtdcSettlementInfoConfirmField > pSettlementInfoConfirm, int nRequestID) {
		return ReqSettlementInfoConfirm(Pointer.getPeer(pSettlementInfoConfirm), nRequestID);
	}
	@Virtual(19) 
	protected native int ReqSettlementInfoConfirm(@Ptr long pSettlementInfoConfirm, int nRequestID);
	@Virtual(20) 
	public int ReqRemoveParkedOrder(Pointer<CThostFtdcRemoveParkedOrderField > pRemoveParkedOrder, int nRequestID) {
		return ReqRemoveParkedOrder(Pointer.getPeer(pRemoveParkedOrder), nRequestID);
	}
	@Virtual(20) 
	protected native int ReqRemoveParkedOrder(@Ptr long pRemoveParkedOrder, int nRequestID);
	@Virtual(21) 
	public int ReqRemoveParkedOrderAction(Pointer<CThostFtdcRemoveParkedOrderActionField > pRemoveParkedOrderAction, int nRequestID) {
		return ReqRemoveParkedOrderAction(Pointer.getPeer(pRemoveParkedOrderAction), nRequestID);
	}
	@Virtual(21) 
	protected native int ReqRemoveParkedOrderAction(@Ptr long pRemoveParkedOrderAction, int nRequestID);
	@Virtual(22) 
	public int ReqQryOrder(Pointer<CThostFtdcQryOrderField > pQryOrder, int nRequestID) {
		return ReqQryOrder(Pointer.getPeer(pQryOrder), nRequestID);
	}
	@Virtual(22) 
	protected native int ReqQryOrder(@Ptr long pQryOrder, int nRequestID);
	@Virtual(23) 
	public int ReqQryTrade(Pointer<CThostFtdcQryTradeField > pQryTrade, int nRequestID) {
		return ReqQryTrade(Pointer.getPeer(pQryTrade), nRequestID);
	}
	@Virtual(23) 
	protected native int ReqQryTrade(@Ptr long pQryTrade, int nRequestID);
	@Virtual(24) 
	public int ReqQryInvestorPosition(Pointer<CThostFtdcQryInvestorPositionField > pQryInvestorPosition, int nRequestID) {
		return ReqQryInvestorPosition(Pointer.getPeer(pQryInvestorPosition), nRequestID);
	}
	@Virtual(24) 
	protected native int ReqQryInvestorPosition(@Ptr long pQryInvestorPosition, int nRequestID);
	@Virtual(25) 
	public int ReqQryTradingAccount(Pointer<CThostFtdcQryTradingAccountField > pQryTradingAccount, int nRequestID) {
		return ReqQryTradingAccount(Pointer.getPeer(pQryTradingAccount), nRequestID);
	}
	@Virtual(25) 
	protected native int ReqQryTradingAccount(@Ptr long pQryTradingAccount, int nRequestID);
	@Virtual(26) 
	public int ReqQryInvestor(Pointer<CThostFtdcQryInvestorField > pQryInvestor, int nRequestID) {
		return ReqQryInvestor(Pointer.getPeer(pQryInvestor), nRequestID);
	}
	@Virtual(26) 
	protected native int ReqQryInvestor(@Ptr long pQryInvestor, int nRequestID);
	@Virtual(27) 
	public int ReqQryTradingCode(Pointer<CThostFtdcQryTradingCodeField > pQryTradingCode, int nRequestID) {
		return ReqQryTradingCode(Pointer.getPeer(pQryTradingCode), nRequestID);
	}
	@Virtual(27) 
	protected native int ReqQryTradingCode(@Ptr long pQryTradingCode, int nRequestID);
	@Virtual(28) 
	public int ReqQryInstrumentMarginRate(Pointer<CThostFtdcQryInstrumentMarginRateField > pQryInstrumentMarginRate, int nRequestID) {
		return ReqQryInstrumentMarginRate(Pointer.getPeer(pQryInstrumentMarginRate), nRequestID);
	}
	@Virtual(28) 
	protected native int ReqQryInstrumentMarginRate(@Ptr long pQryInstrumentMarginRate, int nRequestID);
	@Virtual(29) 
	public int ReqQryInstrumentCommissionRate(Pointer<CThostFtdcQryInstrumentCommissionRateField > pQryInstrumentCommissionRate, int nRequestID) {
		return ReqQryInstrumentCommissionRate(Pointer.getPeer(pQryInstrumentCommissionRate), nRequestID);
	}
	@Virtual(29) 
	protected native int ReqQryInstrumentCommissionRate(@Ptr long pQryInstrumentCommissionRate, int nRequestID);
	@Virtual(30) 
	public int ReqQryExchange(Pointer<CThostFtdcQryExchangeField > pQryExchange, int nRequestID) {
		return ReqQryExchange(Pointer.getPeer(pQryExchange), nRequestID);
	}
	@Virtual(30) 
	protected native int ReqQryExchange(@Ptr long pQryExchange, int nRequestID);
	@Virtual(31) 
	public int ReqQryInstrument(Pointer<CThostFtdcQryInstrumentField > pQryInstrument, int nRequestID) {
		return ReqQryInstrument(Pointer.getPeer(pQryInstrument), nRequestID);
	}
	@Virtual(31) 
	protected native int ReqQryInstrument(@Ptr long pQryInstrument, int nRequestID);
	@Virtual(32) 
	public int ReqQryDepthMarketData(Pointer<CThostFtdcQryDepthMarketDataField > pQryDepthMarketData, int nRequestID) {
		return ReqQryDepthMarketData(Pointer.getPeer(pQryDepthMarketData), nRequestID);
	}
	@Virtual(32) 
	protected native int ReqQryDepthMarketData(@Ptr long pQryDepthMarketData, int nRequestID);
	@Virtual(33) 
	public int ReqQrySettlementInfo(Pointer<CThostFtdcQrySettlementInfoField > pQrySettlementInfo, int nRequestID) {
		return ReqQrySettlementInfo(Pointer.getPeer(pQrySettlementInfo), nRequestID);
	}
	@Virtual(33) 
	protected native int ReqQrySettlementInfo(@Ptr long pQrySettlementInfo, int nRequestID);
	@Virtual(34) 
	public int ReqQryTransferBank(Pointer<CThostFtdcQryTransferBankField > pQryTransferBank, int nRequestID) {
		return ReqQryTransferBank(Pointer.getPeer(pQryTransferBank), nRequestID);
	}
	@Virtual(34) 
	protected native int ReqQryTransferBank(@Ptr long pQryTransferBank, int nRequestID);
	@Virtual(35) 
	public int ReqQryInvestorPositionDetail(Pointer<CThostFtdcQryInvestorPositionDetailField > pQryInvestorPositionDetail, int nRequestID) {
		return ReqQryInvestorPositionDetail(Pointer.getPeer(pQryInvestorPositionDetail), nRequestID);
	}
	@Virtual(35) 
	protected native int ReqQryInvestorPositionDetail(@Ptr long pQryInvestorPositionDetail, int nRequestID);
	@Virtual(36) 
	public int ReqQryNotice(Pointer<CThostFtdcQryNoticeField > pQryNotice, int nRequestID) {
		return ReqQryNotice(Pointer.getPeer(pQryNotice), nRequestID);
	}
	@Virtual(36) 
	protected native int ReqQryNotice(@Ptr long pQryNotice, int nRequestID);
	@Virtual(37) 
	public int ReqQrySettlementInfoConfirm(Pointer<CThostFtdcQrySettlementInfoConfirmField > pQrySettlementInfoConfirm, int nRequestID) {
		return ReqQrySettlementInfoConfirm(Pointer.getPeer(pQrySettlementInfoConfirm), nRequestID);
	}
	@Virtual(37) 
	protected native int ReqQrySettlementInfoConfirm(@Ptr long pQrySettlementInfoConfirm, int nRequestID);
	@Virtual(38) 
	public int ReqQryInvestorPositionCombineDetail(Pointer<CThostFtdcQryInvestorPositionCombineDetailField > pQryInvestorPositionCombineDetail, int nRequestID) {
		return ReqQryInvestorPositionCombineDetail(Pointer.getPeer(pQryInvestorPositionCombineDetail), nRequestID);
	}
	@Virtual(38) 
	protected native int ReqQryInvestorPositionCombineDetail(@Ptr long pQryInvestorPositionCombineDetail, int nRequestID);
	@Virtual(39) 
	public int ReqQryCFMMCTradingAccountKey(Pointer<CThostFtdcQryCFMMCTradingAccountKeyField > pQryCFMMCTradingAccountKey, int nRequestID) {
		return ReqQryCFMMCTradingAccountKey(Pointer.getPeer(pQryCFMMCTradingAccountKey), nRequestID);
	}
	@Virtual(39) 
	protected native int ReqQryCFMMCTradingAccountKey(@Ptr long pQryCFMMCTradingAccountKey, int nRequestID);
	@Virtual(40) 
	public int ReqQryEWarrantOffset(Pointer<CThostFtdcQryEWarrantOffsetField > pQryEWarrantOffset, int nRequestID) {
		return ReqQryEWarrantOffset(Pointer.getPeer(pQryEWarrantOffset), nRequestID);
	}
	@Virtual(40) 
	protected native int ReqQryEWarrantOffset(@Ptr long pQryEWarrantOffset, int nRequestID);
	@Virtual(41) 
	public int ReqQryTransferSerial(Pointer<CThostFtdcQryTransferSerialField > pQryTransferSerial, int nRequestID) {
		return ReqQryTransferSerial(Pointer.getPeer(pQryTransferSerial), nRequestID);
	}
	@Virtual(41) 
	protected native int ReqQryTransferSerial(@Ptr long pQryTransferSerial, int nRequestID);
	@Virtual(42) 
	public int ReqQryAccountregister(Pointer<CThostFtdcQryAccountregisterField > pQryAccountregister, int nRequestID) {
		return ReqQryAccountregister(Pointer.getPeer(pQryAccountregister), nRequestID);
	}
	@Virtual(42) 
	protected native int ReqQryAccountregister(@Ptr long pQryAccountregister, int nRequestID);
	@Virtual(43) 
	public int ReqQryContractBank(Pointer<CThostFtdcQryContractBankField > pQryContractBank, int nRequestID) {
		return ReqQryContractBank(Pointer.getPeer(pQryContractBank), nRequestID);
	}
	@Virtual(43) 
	protected native int ReqQryContractBank(@Ptr long pQryContractBank, int nRequestID);
	@Virtual(44) 
	public int ReqQryParkedOrder(Pointer<CThostFtdcQryParkedOrderField > pQryParkedOrder, int nRequestID) {
		return ReqQryParkedOrder(Pointer.getPeer(pQryParkedOrder), nRequestID);
	}
	@Virtual(44) 
	protected native int ReqQryParkedOrder(@Ptr long pQryParkedOrder, int nRequestID);
	@Virtual(45) 
	public int ReqQryParkedOrderAction(Pointer<CThostFtdcQryParkedOrderActionField > pQryParkedOrderAction, int nRequestID) {
		return ReqQryParkedOrderAction(Pointer.getPeer(pQryParkedOrderAction), nRequestID);
	}
	@Virtual(45) 
	protected native int ReqQryParkedOrderAction(@Ptr long pQryParkedOrderAction, int nRequestID);
	@Virtual(46) 
	public int ReqQryTradingNotice(Pointer<CThostFtdcQryTradingNoticeField > pQryTradingNotice, int nRequestID) {
		return ReqQryTradingNotice(Pointer.getPeer(pQryTradingNotice), nRequestID);
	}
	@Virtual(46) 
	protected native int ReqQryTradingNotice(@Ptr long pQryTradingNotice, int nRequestID);
	@Virtual(47) 
	public int ReqQryBrokerTradingParams(Pointer<CThostFtdcQryBrokerTradingParamsField > pQryBrokerTradingParams, int nRequestID) {
		return ReqQryBrokerTradingParams(Pointer.getPeer(pQryBrokerTradingParams), nRequestID);
	}
	@Virtual(47) 
	protected native int ReqQryBrokerTradingParams(@Ptr long pQryBrokerTradingParams, int nRequestID);
	@Virtual(48) 
	public int ReqQryBrokerTradingAlgos(Pointer<CThostFtdcQryBrokerTradingAlgosField > pQryBrokerTradingAlgos, int nRequestID) {
		return ReqQryBrokerTradingAlgos(Pointer.getPeer(pQryBrokerTradingAlgos), nRequestID);
	}
	@Virtual(48) 
	protected native int ReqQryBrokerTradingAlgos(@Ptr long pQryBrokerTradingAlgos, int nRequestID);
	@Virtual(49) 
	public int ReqFromBankToFutureByFuture(Pointer<CThostFtdcReqTransferField > pReqTransfer, int nRequestID) {
		return ReqFromBankToFutureByFuture(Pointer.getPeer(pReqTransfer), nRequestID);
	}
	@Virtual(49) 
	protected native int ReqFromBankToFutureByFuture(@Ptr long pReqTransfer, int nRequestID);
	@Virtual(50) 
	public int ReqFromFutureToBankByFuture(Pointer<CThostFtdcReqTransferField > pReqTransfer, int nRequestID) {
		return ReqFromFutureToBankByFuture(Pointer.getPeer(pReqTransfer), nRequestID);
	}
	@Virtual(50) 
	protected native int ReqFromFutureToBankByFuture(@Ptr long pReqTransfer, int nRequestID);
	@Virtual(51) 
	public int ReqQueryBankAccountMoneyByFuture(Pointer<CThostFtdcReqQueryAccountField > pReqQueryAccount, int nRequestID) {
		return ReqQueryBankAccountMoneyByFuture(Pointer.getPeer(pReqQueryAccount), nRequestID);
	}
	@Virtual(51) 
	protected native int ReqQueryBankAccountMoneyByFuture(@Ptr long pReqQueryAccount, int nRequestID);
	public CThostFtdcTraderApi(Pointer pointer) {
		super(pointer);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("************* CThostFtdcTraderApi 被回收啦 *************");
		super.finalize();
	}
}
