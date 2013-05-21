package org.hraink.futures.jctp.trader;

import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcAccountregisterField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcBrokerTradingAlgosField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcBrokerTradingParamsField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcCFMMCTradingAccountKeyField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcCancelAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcChangeAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcContractBankField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcDepthMarketDataField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcEWarrantOffsetField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcErrorConditionalOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcExchangeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInstrumentCommissionRateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInstrumentField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInstrumentMarginRateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInstrumentStatusField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInvestorField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInvestorPositionCombineDetailField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInvestorPositionDetailField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInvestorPositionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcNoticeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcNotifyQueryAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcOpenAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcParkedOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcParkedOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQueryMaxOrderVolumeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRemoveParkedOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRemoveParkedOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqQueryAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqRepealField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqTransferField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspAuthenticateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspInfoField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspRepealField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspTransferField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcSettlementInfoConfirmField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcSettlementInfoField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradingAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradingAccountPasswordUpdateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradingCodeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradingNoticeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradingNoticeInfoField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTransferBankField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTransferSerialField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserLogoutField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserPasswordUpdateField;

/**
 * CThostFtdcTraderSpi封装类
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-27 上午12:05:18
 */

public class JCTPTraderSpi {
	public void onFrontConnected() {
	}
	public void onFrontDisconnected(int nReason) {
	}
	public void onHeartBeatWarning(int nTimeLapse) {
	}
	public void onRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspUserPasswordUpdate(CThostFtdcUserPasswordUpdateField pUserPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspTradingAccountPasswordUpdate(CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspParkedOrderInsert(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspOrderAction(CThostFtdcInputOrderActionField pInputOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQueryMaxOrderVolume(CThostFtdcQueryMaxOrderVolumeField pQueryMaxOrderVolume, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspSettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspRemoveParkedOrder(CThostFtdcRemoveParkedOrderField pRemoveParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspRemoveParkedOrderAction(CThostFtdcRemoveParkedOrderActionField pRemoveParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryOrder(CThostFtdcOrderField pOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryTrade(CThostFtdcTradeField pTrade, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryInvestorPosition(CThostFtdcInvestorPositionField pInvestorPosition, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryInvestor(CThostFtdcInvestorField pInvestor, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryTradingCode(CThostFtdcTradingCodeField pTradingCode, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField pInstrumentMarginRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryExchange(CThostFtdcExchangeField pExchange, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryTransferBank(CThostFtdcTransferBankField pTransferBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryInvestorPositionDetail(CThostFtdcInvestorPositionDetailField pInvestorPositionDetail, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryNotice(CThostFtdcNoticeField pNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQrySettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryInvestorPositionCombineDetail(CThostFtdcInvestorPositionCombineDetailField pInvestorPositionCombineDetail, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryCFMMCTradingAccountKey(CThostFtdcCFMMCTradingAccountKeyField pCFMMCTradingAccountKey, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryEWarrantOffset(CThostFtdcEWarrantOffsetField pEWarrantOffset, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryTransferSerial(CThostFtdcTransferSerialField pTransferSerial, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryAccountregister(CThostFtdcAccountregisterField pAccountregister, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRtnOrder(CThostFtdcOrderField pOrder) {
	}
	public void onRtnTrade(CThostFtdcTradeField pTrade) {
	}
	public void onErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo) {
	}
	public void onErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction, CThostFtdcRspInfoField pRspInfo) {
	}
	public void onRtnInstrumentStatus(CThostFtdcInstrumentStatusField pInstrumentStatus) {
	}
	public void onRtnTradingNotice(CThostFtdcTradingNoticeInfoField pTradingNoticeInfo) {
	}
	public void onRtnErrorConditionalOrder(CThostFtdcErrorConditionalOrderField pErrorConditionalOrder) {
	}
	public void onRspQryContractBank(CThostFtdcContractBankField pContractBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryParkedOrder(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryTradingNotice(CThostFtdcTradingNoticeField pTradingNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryBrokerTradingParams(CThostFtdcBrokerTradingParamsField pBrokerTradingParams, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQryBrokerTradingAlgos(CThostFtdcBrokerTradingAlgosField pBrokerTradingAlgos, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRtnFromBankToFutureByBank(CThostFtdcRspTransferField pRspTransfer) {
	}
	public void onRtnFromFutureToBankByBank(CThostFtdcRspTransferField pRspTransfer) {
	}
	public void onRtnRepealFromBankToFutureByBank(CThostFtdcRspRepealField pRspRepeal) {
	}
	public void onRtnRepealFromFutureToBankByBank(CThostFtdcRspRepealField pRspRepeal) {
	}
	public void onRtnFromBankToFutureByFuture(CThostFtdcRspTransferField pRspTransfer) {
	}
	public void onRtnFromFutureToBankByFuture(CThostFtdcRspTransferField pRspTransfer) {
	}
	public void onRtnRepealFromBankToFutureByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
	}
	public void onRtnRepealFromFutureToBankByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
	}
	public void onRtnQueryBankBalanceByFuture(CThostFtdcNotifyQueryAccountField pNotifyQueryAccount) {
	}
	public void onErrRtnBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
	}
	public void onErrRtnFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
	}
	public void onErrRtnRepealBankToFutureByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {
	}
	public void onErrRtnRepealFutureToBankByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {
	}
	public void onErrRtnQueryBankBalanceByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo) {
	}
	public void onRtnRepealFromBankToFutureByFuture(CThostFtdcRspRepealField pRspRepeal) {
	}
	public void onRtnRepealFromFutureToBankByFuture(CThostFtdcRspRepealField pRspRepeal) {
	}
	public void onRspFromBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspFromFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRspQueryBankAccountMoneyByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}
	public void onRtnOpenAccountByBank(CThostFtdcOpenAccountField pOpenAccount) {
	}
	public void onRtnCancelAccountByBank(CThostFtdcCancelAccountField pCancelAccount) {
	}
	public void onRtnChangeAccountByBank(CThostFtdcChangeAccountField pChangeAccount) {
	}
}
