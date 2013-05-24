package org.hraink.futures.ctp.trader;

import static org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_CC_Immediately;
import static org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_D_Buy;
import static org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_FCC_NotForceClose;
import static org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_OPT_LimitPrice;
import static org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_TC_GFD;
import static org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_VC_AV;

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
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInvestorPositionDetailField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQueryMaxOrderVolumeField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRemoveParkedOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRemoveParkedOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqQueryAccountField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqRepealField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqTransferField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqUserLoginField;
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
import org.hraink.futures.jctp.trader.JCTPTraderApi;
import org.hraink.futures.jctp.trader.JCTPTraderSpi;

/**
 * Custom TraderSpi
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-25 下午11:46:13
 */
public class MyTraderSpi implements JCTPTraderSpi {

	JCTPTraderApi traderApi;
	int nRequestID = 0;

	// 中证
	String brokerId = "2011";
	String userId = "020000000711";
	String password = "123321";

	public MyTraderSpi(JCTPTraderApi traderApi) {
		this.traderApi = traderApi;
	}

	@Override
	public void onFrontConnected() {
		System.out.println("前置机连接");
		CThostFtdcReqUserLoginField userLoginField = new CThostFtdcReqUserLoginField();

		userLoginField.setBrokerID(brokerId);
		userLoginField.setUserID(userId);
		userLoginField.setPassword(password);

		traderApi.reqUserLogin(userLoginField, 112);

		CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();

		traderApi.reqOrderInsert(pInputOrder, ++nRequestID);
	}

	@Override
	public void onRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("TradingDay:" + traderApi.getTradingDay());
		System.out.println(pRspInfo.getErrorID());
		System.out.println(pRspUserLogin.getLoginTime());
		System.out.println(pRspUserLogin.getCZCETime());
		System.out.println(pRspUserLogin.getDCETime());
		System.out.println(pRspUserLogin.getFFEXTime());
		System.out.println(pRspUserLogin.getSHFETime());
		System.out.println(pRspUserLogin.getMaxOrderRef());

		// 查询持仓明细
		CThostFtdcQryInvestorPositionDetailField positionField = new CThostFtdcQryInvestorPositionDetailField();
		positionField.setBrokerID(brokerId);
		positionField.setInstrumentID("cu1303");
		positionField.setInvestorID(userId);
		traderApi.reqQryInvestorPositionDetail(positionField, ++nRequestID);

		// 确认结算单
		CThostFtdcSettlementInfoConfirmField confirmField = new CThostFtdcSettlementInfoConfirmField();
		traderApi.reqSettlementInfoConfirm(confirmField, ++nRequestID);

		// 下单操作
		CThostFtdcInputOrderField inputOrderField = new CThostFtdcInputOrderField();
		// 期货公司代码
		inputOrderField.setBrokerID(brokerId);
		// 投资者代码
		inputOrderField.setInvestorID(userId);
		// 合约代码
		inputOrderField.setInstrumentID("ru1306");
		// /报单引用
		inputOrderField.setOrderRef("000000000001");
		// 用户代码
		inputOrderField.setUserID(userId);
		// 报单价格条件
		inputOrderField.setOrderPriceType(THOST_FTDC_OPT_LimitPrice);
		// 买卖方向
		inputOrderField.setDirection(THOST_FTDC_D_Buy);
		// 组合开平标志
		inputOrderField.setCombOffsetFlag("0");
		// 组合投机套保标志
		inputOrderField.setCombHedgeFlag("1");
		// 价格
		inputOrderField.setLimitPrice(24490);
		// 数量
		inputOrderField.setVolumeTotalOriginal(10);
		// 有效期类型
		inputOrderField.setTimeCondition(THOST_FTDC_TC_GFD);
		// GTD日期
		inputOrderField.setGTDDate("");
		// 成交量类型
		inputOrderField.setVolumeCondition(THOST_FTDC_VC_AV);
		// 最小成交量
		inputOrderField.setMinVolume(0);
		// 触发条件
		inputOrderField.setContingentCondition(THOST_FTDC_CC_Immediately);
		// 止损价
		inputOrderField.setStopPrice(0);
		// 强平原因
		inputOrderField.setForceCloseReason(THOST_FTDC_FCC_NotForceClose);
		// 自动挂起标志
		inputOrderField.setIsAutoSuspend(0);

		traderApi.reqOrderInsert(inputOrderField, ++nRequestID);
	}

	@Override
	public void onRtnOrder(CThostFtdcOrderField pOrder) {
		System.out.println(pOrder.getStatusMsg());
	}

	@Override
	public void onRspOrderInsert(CThostFtdcInputOrderField pInputOrder,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println(pRspInfo.getErrorMsg());
	}

	@Override
	public void onRspOrderAction(
			CThostFtdcInputOrderActionField pInputOrderAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println(pRspInfo.getErrorMsg());
	}

	@Override
	public void onRtnTrade(CThostFtdcTradeField pTrade) {
		System.out.println(pTrade.getInstrumentID());
	}

	@Override
	public void onRspQryInvestorPositionDetail(
			CThostFtdcInvestorPositionDetailField pInvestorPositionDetail,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("持仓明细查询回调");
	}

	@Override
	public void onRspQryInvestorPosition(
			CThostFtdcInvestorPositionField pInvestorPosition,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("持仓查询回调");
	}

	@Override
	public void onRspSettlementInfoConfirm(
			CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("结算单确认回调");
	}

	@Override
	public void onRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		System.out.println("错误回调");
	}

	@Override
	public void onErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder,
			CThostFtdcRspInfoField pRspInfo) {
		System.out.println("报单录入错误回调");
	}

	@Override
	public void onFrontDisconnected(int nReason) {
		// TODO Auto-generated method stub
		System.out.println("前置断开连接回调");
	}

	@Override
	public void onHeartBeatWarning(int nTimeLapse) {
		// TODO Auto-generated method stub
		System.out.println("心跳警告回调");

	}

	@Override
	public void onRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspUserPasswordUpdate(CThostFtdcUserPasswordUpdateField pUserPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspTradingAccountPasswordUpdate(CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspParkedOrderInsert(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQueryMaxOrderVolume(CThostFtdcQueryMaxOrderVolumeField pQueryMaxOrderVolume, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspRemoveParkedOrder(CThostFtdcRemoveParkedOrderField pRemoveParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspRemoveParkedOrderAction(CThostFtdcRemoveParkedOrderActionField pRemoveParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryOrder(CThostFtdcOrderField pOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryTrade(CThostFtdcTradeField pTrade, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryInvestor(CThostFtdcInvestorField pInvestor, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryTradingCode(CThostFtdcTradingCodeField pTradingCode, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField pInstrumentMarginRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryExchange(CThostFtdcExchangeField pExchange, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryTransferBank(CThostFtdcTransferBankField pTransferBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryNotice(CThostFtdcNoticeField pNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQrySettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryInvestorPositionCombineDetail(CThostFtdcInvestorPositionCombineDetailField pInvestorPositionCombineDetail, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryCFMMCTradingAccountKey(CThostFtdcCFMMCTradingAccountKeyField pCFMMCTradingAccountKey, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryEWarrantOffset(CThostFtdcEWarrantOffsetField pEWarrantOffset, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryTransferSerial(CThostFtdcTransferSerialField pTransferSerial, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryAccountregister(CThostFtdcAccountregisterField pAccountregister, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onErrRtnOrderAction(CThostFtdcOrderActionField pOrderAction, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnInstrumentStatus(CThostFtdcInstrumentStatusField pInstrumentStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnTradingNotice(CThostFtdcTradingNoticeInfoField pTradingNoticeInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnErrorConditionalOrder(CThostFtdcErrorConditionalOrderField pErrorConditionalOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryContractBank(CThostFtdcContractBankField pContractBank, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryParkedOrder(CThostFtdcParkedOrderField pParkedOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryParkedOrderAction(CThostFtdcParkedOrderActionField pParkedOrderAction, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryTradingNotice(CThostFtdcTradingNoticeField pTradingNotice, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryBrokerTradingParams(CThostFtdcBrokerTradingParamsField pBrokerTradingParams, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQryBrokerTradingAlgos(CThostFtdcBrokerTradingAlgosField pBrokerTradingAlgos, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnFromBankToFutureByBank(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnFromFutureToBankByBank(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnRepealFromBankToFutureByBank(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnRepealFromFutureToBankByBank(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnFromBankToFutureByFuture(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnFromFutureToBankByFuture(CThostFtdcRspTransferField pRspTransfer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnRepealFromBankToFutureByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnRepealFromFutureToBankByFutureManual(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnQueryBankBalanceByFuture(CThostFtdcNotifyQueryAccountField pNotifyQueryAccount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onErrRtnBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onErrRtnFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onErrRtnRepealBankToFutureByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onErrRtnRepealFutureToBankByFutureManual(CThostFtdcReqRepealField pReqRepeal, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onErrRtnQueryBankBalanceByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnRepealFromBankToFutureByFuture(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnRepealFromFutureToBankByFuture(CThostFtdcRspRepealField pRspRepeal) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspFromBankToFutureByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspFromFutureToBankByFuture(CThostFtdcReqTransferField pReqTransfer, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRspQueryBankAccountMoneyByFuture(CThostFtdcReqQueryAccountField pReqQueryAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnOpenAccountByBank(CThostFtdcOpenAccountField pOpenAccount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnCancelAccountByBank(CThostFtdcCancelAccountField pCancelAccount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRtnChangeAccountByBank(CThostFtdcChangeAccountField pChangeAccount) {
		// TODO Auto-generated method stub

	}
}
