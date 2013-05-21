package org.hraink.futures.jctp.trader;

import org.bridj.Pointer;
import org.bridj.ann.Virtual;
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
import org.hraink.futures.ctp.thosttraderapi.CThostFtdcTraderSpi;

/**
 * TraderSpi适配器类
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-27 上午11:31:12
 */

public class JCTPTraderSpiAdapter extends CThostFtdcTraderSpi{
	
	private JCTPTraderSpi traderSpi;
	
	public JCTPTraderSpiAdapter(JCTPTraderSpi traderSpi) {
		this.traderSpi = traderSpi;
	}
	@Override
	@Virtual(0)
	public void OnFrontConnected() {
		
		traderSpi.onFrontConnected();
	}

	@Override
	@Virtual(1)
	public void OnFrontDisconnected(int nReason) {
		
		traderSpi.onFrontDisconnected(nReason);
	}

	@Override
	@Virtual(2)
	public void OnHeartBeatWarning(int nTimeLapse) {
		
		traderSpi.onHeartBeatWarning(nTimeLapse);
	}

	@Override
	@Virtual(3)
	public void OnRspAuthenticate(
			Pointer<CThostFtdcRspAuthenticateField> pRspAuthenticateField,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspAuthenticate(pRspAuthenticateField.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(4)
	public void OnRspUserLogin(
			Pointer<CThostFtdcRspUserLoginField> pRspUserLogin,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspUserLogin(pRspUserLogin.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(5)
	public void OnRspUserLogout(Pointer<CThostFtdcUserLogoutField> pUserLogout,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspUserLogout(pUserLogout.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(6)
	public void OnRspUserPasswordUpdate(
			Pointer<CThostFtdcUserPasswordUpdateField> pUserPasswordUpdate,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspUserPasswordUpdate(pUserPasswordUpdate.get(), pRspInfo.get(), nRequestID,
				bIsLast);
	}

	@Override
	@Virtual(7)
	public void OnRspTradingAccountPasswordUpdate(
			Pointer<CThostFtdcTradingAccountPasswordUpdateField> pTradingAccountPasswordUpdate,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspTradingAccountPasswordUpdate(pTradingAccountPasswordUpdate.get(),
				pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(8)
	public void OnRspOrderInsert(
			Pointer<CThostFtdcInputOrderField> pInputOrder,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspOrderInsert(pInputOrder.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(9)
	public void OnRspParkedOrderInsert(
			Pointer<CThostFtdcParkedOrderField> pParkedOrder,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspParkedOrderInsert(pParkedOrder.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(10)
	public void OnRspParkedOrderAction(
			Pointer<CThostFtdcParkedOrderActionField> pParkedOrderAction,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspParkedOrderAction(pParkedOrderAction.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(11)
	public void OnRspOrderAction(
			Pointer<CThostFtdcInputOrderActionField> pInputOrderAction,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspOrderAction(pInputOrderAction.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(12)
	public void OnRspQueryMaxOrderVolume(
			Pointer<CThostFtdcQueryMaxOrderVolumeField> pQueryMaxOrderVolume,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQueryMaxOrderVolume(pQueryMaxOrderVolume.get(), pRspInfo.get(), nRequestID,
				bIsLast);
	}

	@Override
	@Virtual(13)
	public void OnRspSettlementInfoConfirm(
			Pointer<CThostFtdcSettlementInfoConfirmField> pSettlementInfoConfirm,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspSettlementInfoConfirm(pSettlementInfoConfirm.get(), pRspInfo.get(), nRequestID,
				bIsLast);
	}

	@Override
	@Virtual(14)
	public void OnRspRemoveParkedOrder(
			Pointer<CThostFtdcRemoveParkedOrderField> pRemoveParkedOrder,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspRemoveParkedOrder(pRemoveParkedOrder.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(15)
	public void OnRspRemoveParkedOrderAction(
			Pointer<CThostFtdcRemoveParkedOrderActionField> pRemoveParkedOrderAction,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspRemoveParkedOrderAction(pRemoveParkedOrderAction.get(), pRspInfo.get(),
				nRequestID, bIsLast);
	}

	@Override
	@Virtual(16)
	public void OnRspQryOrder(Pointer<CThostFtdcOrderField> pOrder,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryOrder(pOrder.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(17)
	public void OnRspQryTrade(Pointer<CThostFtdcTradeField> pTrade,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryTrade(pTrade.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(18)
	public void OnRspQryInvestorPosition(
			Pointer<CThostFtdcInvestorPositionField> pInvestorPosition,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryInvestorPosition(pInvestorPosition.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(19)
	public void OnRspQryTradingAccount(
			Pointer<CThostFtdcTradingAccountField> pTradingAccount,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryTradingAccount(pTradingAccount.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(20)
	public void OnRspQryInvestor(Pointer<CThostFtdcInvestorField> pInvestor,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryInvestor(pInvestor.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(21)
	public void OnRspQryTradingCode(
			Pointer<CThostFtdcTradingCodeField> pTradingCode,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryTradingCode(pTradingCode.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(22)
	public void OnRspQryInstrumentMarginRate(
			Pointer<CThostFtdcInstrumentMarginRateField> pInstrumentMarginRate,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryInstrumentMarginRate(pInstrumentMarginRate.get(), pRspInfo.get(), nRequestID,
				bIsLast);
	}

	@Override
	@Virtual(23)
	public void OnRspQryInstrumentCommissionRate(
			Pointer<CThostFtdcInstrumentCommissionRateField> pInstrumentCommissionRate,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryInstrumentCommissionRate(pInstrumentCommissionRate.get(), pRspInfo.get(),
				nRequestID, bIsLast);
	}

	@Override
	@Virtual(24)
	public void OnRspQryExchange(Pointer<CThostFtdcExchangeField> pExchange,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryExchange(pExchange.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(25)
	public void OnRspQryInstrument(
			Pointer<CThostFtdcInstrumentField> pInstrument,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryInstrument(pInstrument.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(26)
	public void OnRspQryDepthMarketData(
			Pointer<CThostFtdcDepthMarketDataField> pDepthMarketData,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryDepthMarketData(pDepthMarketData.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(27)
	public void OnRspQrySettlementInfo(
			Pointer<CThostFtdcSettlementInfoField> pSettlementInfo,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQrySettlementInfo(pSettlementInfo.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(28)
	public void OnRspQryTransferBank(
			Pointer<CThostFtdcTransferBankField> pTransferBank,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryTransferBank(pTransferBank.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(29)
	public void OnRspQryInvestorPositionDetail(
			Pointer<CThostFtdcInvestorPositionDetailField> pInvestorPositionDetail,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryInvestorPositionDetail(pInvestorPositionDetail.get(), pRspInfo.get(),
				nRequestID, bIsLast);
	}

	@Override
	@Virtual(30)
	public void OnRspQryNotice(Pointer<CThostFtdcNoticeField> pNotice,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryNotice(pNotice.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(31)
	public void OnRspQrySettlementInfoConfirm(
			Pointer<CThostFtdcSettlementInfoConfirmField> pSettlementInfoConfirm,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQrySettlementInfoConfirm(pSettlementInfoConfirm.get(), pRspInfo.get(),
				nRequestID, bIsLast);
	}

	@Override
	@Virtual(32)
	public void OnRspQryInvestorPositionCombineDetail(
			Pointer<CThostFtdcInvestorPositionCombineDetailField> pInvestorPositionCombineDetail,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryInvestorPositionCombineDetail(pInvestorPositionCombineDetail.get(),
				pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(33)
	public void OnRspQryCFMMCTradingAccountKey(
			Pointer<CThostFtdcCFMMCTradingAccountKeyField> pCFMMCTradingAccountKey,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryCFMMCTradingAccountKey(pCFMMCTradingAccountKey.get(), pRspInfo.get(),
				nRequestID, bIsLast);
	}

	@Override
	@Virtual(34)
	public void OnRspQryEWarrantOffset(
			Pointer<CThostFtdcEWarrantOffsetField> pEWarrantOffset,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryEWarrantOffset(pEWarrantOffset.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(35)
	public void OnRspQryTransferSerial(
			Pointer<CThostFtdcTransferSerialField> pTransferSerial,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryTransferSerial(pTransferSerial.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(36)
	public void OnRspQryAccountregister(
			Pointer<CThostFtdcAccountregisterField> pAccountregister,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryAccountregister(pAccountregister.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(37)
	public void OnRspError(Pointer<CThostFtdcRspInfoField> pRspInfo,
			int nRequestID, boolean bIsLast) {
		
		traderSpi.onRspError(pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(38)
	public void OnRtnOrder(Pointer<CThostFtdcOrderField> pOrder) {
		
		traderSpi.onRtnOrder(pOrder.get());
	}

	@Override
	@Virtual(39)
	public void OnRtnTrade(Pointer<CThostFtdcTradeField> pTrade) {
		
		traderSpi.onRtnTrade(pTrade.get());
	}

	@Override
	@Virtual(40)
	public void OnErrRtnOrderInsert(
			Pointer<CThostFtdcInputOrderField> pInputOrder,
			Pointer<CThostFtdcRspInfoField> pRspInfo) {
		
		traderSpi.onErrRtnOrderInsert(pInputOrder.get(), pRspInfo.get());
	}

	@Override
	@Virtual(41)
	public void OnErrRtnOrderAction(
			Pointer<CThostFtdcOrderActionField> pOrderAction,
			Pointer<CThostFtdcRspInfoField> pRspInfo) {
		
		traderSpi.onErrRtnOrderAction(pOrderAction.get(), pRspInfo.get());
	}

	@Override
	@Virtual(42)
	public void OnRtnInstrumentStatus(
			Pointer<CThostFtdcInstrumentStatusField> pInstrumentStatus) {
		
		traderSpi.onRtnInstrumentStatus(pInstrumentStatus.get());
	}

	@Override
	@Virtual(43)
	public void OnRtnTradingNotice(
			Pointer<CThostFtdcTradingNoticeInfoField> pTradingNoticeInfo) {
		
		traderSpi.onRtnTradingNotice(pTradingNoticeInfo.get());
	}

	@Override
	@Virtual(44)
	public void OnRtnErrorConditionalOrder(
			Pointer<CThostFtdcErrorConditionalOrderField> pErrorConditionalOrder) {
		
		traderSpi.onRtnErrorConditionalOrder(pErrorConditionalOrder.get());
	}

	@Override
	@Virtual(45)
	public void OnRspQryContractBank(
			Pointer<CThostFtdcContractBankField> pContractBank,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryContractBank(pContractBank.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(46)
	public void OnRspQryParkedOrder(
			Pointer<CThostFtdcParkedOrderField> pParkedOrder,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryParkedOrder(pParkedOrder.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(47)
	public void OnRspQryParkedOrderAction(
			Pointer<CThostFtdcParkedOrderActionField> pParkedOrderAction,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryParkedOrderAction(pParkedOrderAction.get(), pRspInfo.get(), nRequestID,
				bIsLast);
	}

	@Override
	@Virtual(48)
	public void OnRspQryTradingNotice(
			Pointer<CThostFtdcTradingNoticeField> pTradingNotice,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryTradingNotice(pTradingNotice.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(49)
	public void OnRspQryBrokerTradingParams(
			Pointer<CThostFtdcBrokerTradingParamsField> pBrokerTradingParams,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryBrokerTradingParams(pBrokerTradingParams.get(), pRspInfo.get(), nRequestID,
				bIsLast);
	}

	@Override
	@Virtual(50)
	public void OnRspQryBrokerTradingAlgos(
			Pointer<CThostFtdcBrokerTradingAlgosField> pBrokerTradingAlgos,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQryBrokerTradingAlgos(pBrokerTradingAlgos.get(), pRspInfo.get(), nRequestID,
				bIsLast);
	}

	@Override
	@Virtual(51)
	public void OnRtnFromBankToFutureByBank(
			Pointer<CThostFtdcRspTransferField> pRspTransfer) {
		
		traderSpi.onRtnFromBankToFutureByBank(pRspTransfer.get());
	}

	@Override
	@Virtual(52)
	public void OnRtnFromFutureToBankByBank(
			Pointer<CThostFtdcRspTransferField> pRspTransfer) {
		
		traderSpi.onRtnFromFutureToBankByBank(pRspTransfer.get());
	}

	@Override
	@Virtual(53)
	public void OnRtnRepealFromBankToFutureByBank(
			Pointer<CThostFtdcRspRepealField> pRspRepeal) {
		
		traderSpi.onRtnRepealFromBankToFutureByBank(pRspRepeal.get());
	}

	@Override
	@Virtual(54)
	public void OnRtnRepealFromFutureToBankByBank(
			Pointer<CThostFtdcRspRepealField> pRspRepeal) {
		
		traderSpi.onRtnRepealFromFutureToBankByBank(pRspRepeal.get());
	}

	@Override
	@Virtual(55)
	public void OnRtnFromBankToFutureByFuture(
			Pointer<CThostFtdcRspTransferField> pRspTransfer) {
		
		traderSpi.onRtnFromBankToFutureByFuture(pRspTransfer.get());
	}

	@Override
	@Virtual(56)
	public void OnRtnFromFutureToBankByFuture(
			Pointer<CThostFtdcRspTransferField> pRspTransfer) {
		
		traderSpi.onRtnFromFutureToBankByFuture(pRspTransfer.get());
	}

	@Override
	@Virtual(57)
	public void OnRtnRepealFromBankToFutureByFutureManual(
			Pointer<CThostFtdcRspRepealField> pRspRepeal) {
		
		traderSpi.onRtnRepealFromBankToFutureByFutureManual(pRspRepeal.get());
	}

	@Override
	@Virtual(58)
	public void OnRtnRepealFromFutureToBankByFutureManual(
			Pointer<CThostFtdcRspRepealField> pRspRepeal) {
		
		traderSpi.onRtnRepealFromFutureToBankByFutureManual(pRspRepeal.get());
	}

	@Override
	@Virtual(59)
	public void OnRtnQueryBankBalanceByFuture(
			Pointer<CThostFtdcNotifyQueryAccountField> pNotifyQueryAccount) {
		
		traderSpi.onRtnQueryBankBalanceByFuture(pNotifyQueryAccount.get());
	}

	@Override
	@Virtual(60)
	public void OnErrRtnBankToFutureByFuture(
			Pointer<CThostFtdcReqTransferField> pReqTransfer,
			Pointer<CThostFtdcRspInfoField> pRspInfo) {
		
		traderSpi.onErrRtnBankToFutureByFuture(pReqTransfer.get(), pRspInfo.get());
	}

	@Override
	@Virtual(61)
	public void OnErrRtnFutureToBankByFuture(
			Pointer<CThostFtdcReqTransferField> pReqTransfer,
			Pointer<CThostFtdcRspInfoField> pRspInfo) {
		
		traderSpi.onErrRtnFutureToBankByFuture(pReqTransfer.get(), pRspInfo.get());
	}

	@Override
	@Virtual(62)
	public void OnErrRtnRepealBankToFutureByFutureManual(
			Pointer<CThostFtdcReqRepealField> pReqRepeal,
			Pointer<CThostFtdcRspInfoField> pRspInfo) {
		
		traderSpi.onErrRtnRepealBankToFutureByFutureManual(pReqRepeal.get(), pRspInfo.get());
	}

	@Override
	@Virtual(63)
	public void OnErrRtnRepealFutureToBankByFutureManual(
			Pointer<CThostFtdcReqRepealField> pReqRepeal,
			Pointer<CThostFtdcRspInfoField> pRspInfo) {
		
		traderSpi.onErrRtnRepealFutureToBankByFutureManual(pReqRepeal.get(), pRspInfo.get());
	}

	@Override
	@Virtual(64)
	public void OnErrRtnQueryBankBalanceByFuture(
			Pointer<CThostFtdcReqQueryAccountField> pReqQueryAccount,
			Pointer<CThostFtdcRspInfoField> pRspInfo) {
		
		traderSpi.onErrRtnQueryBankBalanceByFuture(pReqQueryAccount.get(), pRspInfo.get());
	}

	@Override
	@Virtual(65)
	public void OnRtnRepealFromBankToFutureByFuture(
			Pointer<CThostFtdcRspRepealField> pRspRepeal) {
		
		traderSpi.onRtnRepealFromBankToFutureByFuture(pRspRepeal.get());
	}

	@Override
	@Virtual(66)
	public void OnRtnRepealFromFutureToBankByFuture(
			Pointer<CThostFtdcRspRepealField> pRspRepeal) {
		
		traderSpi.onRtnRepealFromFutureToBankByFuture(pRspRepeal.get());
	}

	@Override
	@Virtual(67)
	public void OnRspFromBankToFutureByFuture(
			Pointer<CThostFtdcReqTransferField> pReqTransfer,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspFromBankToFutureByFuture(pReqTransfer.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(68)
	public void OnRspFromFutureToBankByFuture(
			Pointer<CThostFtdcReqTransferField> pReqTransfer,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspFromFutureToBankByFuture(pReqTransfer.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(69)
	public void OnRspQueryBankAccountMoneyByFuture(
			Pointer<CThostFtdcReqQueryAccountField> pReqQueryAccount,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		traderSpi.onRspQueryBankAccountMoneyByFuture(pReqQueryAccount.get(), pRspInfo.get(),
				nRequestID, bIsLast);
	}

	@Override
	@Virtual(70)
	public void OnRtnOpenAccountByBank(
			Pointer<CThostFtdcOpenAccountField> pOpenAccount) {
		
		traderSpi.onRtnOpenAccountByBank(pOpenAccount.get());
	}

	@Override
	@Virtual(71)
	public void OnRtnCancelAccountByBank(
			Pointer<CThostFtdcCancelAccountField> pCancelAccount) {
		
		traderSpi.onRtnCancelAccountByBank(pCancelAccount.get());
	}

	@Override
	@Virtual(72)
	public void OnRtnChangeAccountByBank(
			Pointer<CThostFtdcChangeAccountField> pChangeAccount) {
		
		traderSpi.onRtnChangeAccountByBank(pChangeAccount.get());
	}
	
}

