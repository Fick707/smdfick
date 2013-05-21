package org.hraink.futures.jctp.md;

import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.ann.Virtual;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcDepthMarketDataField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspInfoField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcSpecificInstrumentField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserLogoutField;
import org.hraink.futures.ctp.thostmduserapi.CThostFtdcMdSpi;

/**
 * MdSpi适配器类
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-27 上午11:31:12
 */

public final class JCTPMdSpiAdapter extends CThostFtdcMdSpi{
	
	JCTPMdSpi mdSpi;
	
	public JCTPMdSpiAdapter(JCTPMdSpi mdSpi) {
		BridJ.protectFromGC(this);
		this.mdSpi = mdSpi;
	}
	@Override
	@Virtual(0)
	public void OnFrontConnected() {
		mdSpi.onFrontConnected();
	}

	@Override
	@Virtual(1)
	public void OnFrontDisconnected(int nReason) {
		mdSpi.onFrontDisconnected(nReason);
	}

	@Override
	@Virtual(2)
	public void OnHeartBeatWarning(int nTimeLapse) {
		mdSpi.onHeartBeatWarning(nTimeLapse);
	}

	@Override
	@Virtual(3)
	public void OnRspUserLogin(
			Pointer<CThostFtdcRspUserLoginField> pRspUserLogin,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		mdSpi.onRspUserLogin(pRspUserLogin.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(4)
	public void OnRspUserLogout(Pointer<CThostFtdcUserLogoutField> pUserLogout,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		mdSpi.onRspUserLogout(pUserLogout.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(5)
	public void OnRspError(Pointer<CThostFtdcRspInfoField> pRspInfo,
			int nRequestID, boolean bIsLast) {
		mdSpi.onRspError(pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(6)
	public void OnRspSubMarketData(
			Pointer<CThostFtdcSpecificInstrumentField> pSpecificInstrument,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		mdSpi.onRspSubMarketData(pSpecificInstrument.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(7)
	public void OnRspUnSubMarketData(
			Pointer<CThostFtdcSpecificInstrumentField> pSpecificInstrument,
			Pointer<CThostFtdcRspInfoField> pRspInfo, int nRequestID,
			boolean bIsLast) {
		mdSpi.onRspUnSubMarketData(pSpecificInstrument.get(), pRspInfo.get(), nRequestID, bIsLast);
	}

	@Override
	@Virtual(8)
	public void OnRtnDepthMarketData(
			Pointer<CThostFtdcDepthMarketDataField> pDepthMarketData) {
		mdSpi.onRtnDepthMarketData(pDepthMarketData.get());
	}
//	@Override
//	@Virtual(3)
//	protected void OnRspUserLogin(@Ptr long pRspUserLogin,
//			@Ptr long pRspInfo, int nRequestID, boolean bIsLast) {
//	}
//	@Override
//	@Virtual(4)
//	protected void OnRspUserLogout(@Ptr long pUserLogout, @Ptr long pRspInfo,
//			int nRequestID, boolean bIsLast) {
//	}
//	@Override
//	@Virtual(5)
//	protected void OnRspError(@Ptr long pRspInfo, int nRequestID,
//			boolean bIsLast) {
//	}
//	@Override
//	@Virtual(6)
//	protected void OnRspSubMarketData(@Ptr long pSpecificInstrument,
//			@Ptr long pRspInfo, int nRequestID, boolean bIsLast) {
//	}
//	@Override
//	@Virtual(7)
//	protected void OnRspUnSubMarketData(@Ptr long pSpecificInstrument,
//			@Ptr long pRspInfo, int nRequestID, boolean bIsLast) {
//	}
//	@Override
//	@Virtual(8)
//	protected void OnRtnDepthMarketData(@Ptr long pDepthMarketData) {
//	}
}
