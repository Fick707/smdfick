package org.hraink.futures.jctp.trader;

import org.bridj.BridJ;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.ann.Virtual;
import org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_TE_RESUME_TYPE;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqAuthenticateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradingAccountPasswordUpdateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserLogoutField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserPasswordUpdateField;
import org.hraink.futures.ctp.thostmduserapi.CThostFtdcMdApi;
import org.hraink.futures.ctp.thosttraderapi.CThostFtdcTraderApi;
import org.hraink.futures.ctp.thosttraderapi.CThostFtdcTraderSpi;
import org.hraink.futures.ctp.util.JCTPLibraryUtil;

/**
 * CThostFtdcTrader封装类
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-26 下午11:44:50
 */

public class JCTPTraderApi {
	static {
		JCTPLibraryUtil.initLibrary();
		BridJ.register(CThostFtdcTraderApi.class);
	}
	
	/** CTP Trader API **/
	CThostFtdcTraderApi traderApi;
	
	public JCTPTraderApi(CThostFtdcTraderApi traderApi) {
		this.traderApi = traderApi;
	}
	
	/**
	 * 创建TraderApi 
	 * 
	 * <pre>
	 * 订阅信息文件存贮在根目录
	 * </pre>
	 * @return 创建出的UserApi
	 */
	public static JCTPTraderApi createFtdcTraderApi() {
		return createFtdcTraderApi("", false);
	}
	
	/**
	 * 创建TraderApi
	 * <pre>
	 * 信息文件目录格式：
	 * 	"c:/ctpdata/"     = "c:/ctpdata/QueryRsp.con"
	 * 	"c:/ctpdata"      = "c:/ctpdataQueryRsp.con"
	 * 	"ctpdata/879243"  = "%PROJECT_HOME%/ctpdata/879243QueryRsp.con"
	 * 	"ctpdata/879243/" = "%PROJECT_HOME%/ctpdata/879243/QueryRsp.con"
	 * </pre>
	 * 
	 * @param pszFlowPath 存贮订阅信息文件的目录
	 * @param bIsUsingUdp 
	 * @return 创建出的UserApi
	 */
	public static JCTPTraderApi createFtdcTraderApi(String pszFlowPath, boolean bIsUsingUdp) {
		Pointer<CThostFtdcTraderApi> traderApiPtr = CThostFtdcTraderApi.CreateFtdcTraderApi(Pointer.pointerToCString(pszFlowPath), false);
		CThostFtdcTraderApi cThostFtdcTraderApi = traderApiPtr.get();
		return new JCTPTraderApi(cThostFtdcTraderApi);
	}
	
	
	/**
	 * 删除接口对象本身
	 * 
	 * <pre>
	 * 不再使用本接口对象时,调用该函数删除接口对象
	 * </pre>
	 */
	public void release() {
		traderApi.Release();
	}
	
	/**
	 * 初始化运行环境
	 * 
	 * <pre>
	 * 只有调用后,接口才开始工作
	 * </pre>
	 */
	public void init() {
		traderApi.Init();
	}
	
	/**
	 * 等待接口线程结束运行
	 * @return 线程退出代码
	 */
	public int join() {
		return traderApi.Join();
	}
	
	/**
	 * 获取当前交易日 
	 * <pre>
	 * 只有登录成功后,才能得到正确的交易日
	 * </pre>
	 * @return 获取到的交易日
	 */
	public String getTradingDay() {
		Pointer<Byte> tradingDay = traderApi.GetTradingDay();
		return tradingDay.getCString();
	}

	/**
	 * 注册前置机网络地址
	 * 
	 * <pre>
	 * 网络地址的格式为：“protocol://ipaddress:port”，如：”tcp://127.0.0.1:17001”
	 * “tcp”代表传输协议，“127.0.0.1”代表服务器地址。”17001”代表服务器端口号
	 * </pre>
	 * 
	 * @param pszFrontAddress 前置机网络地址
	 */
	public void registerFront(String pszFrontAddress) {
		traderApi.RegisterFront(Pointer.pointerToCString(pszFrontAddress));
	}
	
	/**
	 * 注册名字服务器网络地址
	 * 
	 * <pre>
	 * 网络地址的格式为：“protocol://ipaddress:port”，如：”tcp://127.0.0.1:12001”
	 * “tcp”代表传输协议，“127.0.0.1”代表服务器地址。”12001”代表服务器端口号
	 * RegisterNameServer优先于RegisterFront
	 * </pre>
	 * 
	 * @param pszNsAddress 名字服务器网络地址
	 */
	public void registerNameServer(String pszNsAddress) {
		traderApi.RegisterNameServer(Pointer.pointerToCString(pszNsAddress));
	}
	
	/**
	 * 注册回调接口
	 * @param pSpi 派生自回调接口类的实例
	 */
	public void registerSpi(JCTPTraderSpi pSpi) {
		CThostFtdcTraderSpi spiAdapter = new JCTPTraderSpiAdapter(pSpi);
		traderApi.RegisterSpi(Pointer.pointerTo(spiAdapter));
	}
	
	/**
	 * 订阅私有流 该方法要在Init方法前调用。若不调用则不会收到私有流的数据。
	 * @param nResumeType 私有流重传方式					</br>
	 * 			THOST_TERT_RESTART:从本交易日开始重传		</br>
	 * 			THOST_TERT_RESUME:从上次收到的续传		</br>
	 * 			THOST_TERT_QUICK:只传送登录后私有流的内容
	 */
	public void subscribePrivateTopic(IntValuedEnum<THOST_TE_RESUME_TYPE> nResumeType) {
		//TODO 考虑自定义枚举类型
		traderApi.SubscribePrivateTopic(nResumeType);
	}
	
	/**
	 * 订阅公共流 该方法要在Init方法前调用。若不调用则不会收到私有流的数据。
	 * @param nResumeType 公共流重传方式					</br>
	 * 			THOST_TERT_RESTART:从本交易日开始重传		</br>
	 * 			THOST_TERT_RESUME:从上次收到的续传		</br>
	 * 			THOST_TERT_QUICK:只传送登录后私有流的内容
	 */
	public void subscribePublicTopic(IntValuedEnum<THOST_TE_RESUME_TYPE> nResumeType) {
		// TODO 考虑自定义枚举类型
		traderApi.SubscribePublicTopic(nResumeType);
	}
	
	/**
	 * 客户端认证请求
	 * @param pReqAuthenticateField 
	 * @param nRequestID
	 * @return 请求发送状态
	 */
	public int reqAuthenticate(CThostFtdcReqAuthenticateField pReqAuthenticateField, int nRequestID) {
		return traderApi.ReqAuthenticate(Pointer.pointerTo(pReqAuthenticateField), nRequestID);
	}
	
	/**
	 * 用户登录请求
	 * @param pReqUserLoginField
	 * @param nRequestID
	 * @return 请求发送状态
	 */
	public int reqUserLogin(CThostFtdcReqUserLoginField pReqUserLoginField, int nRequestID) {
		return traderApi.ReqUserLogin(Pointer.pointerTo(pReqUserLoginField), nRequestID);
	}
	
	/**
	 * 登出请求
	 * @param pUserLogout
	 * @param nRequestID
	 * @return 请求发送状态
	 */
	public int reqUserLogout(CThostFtdcUserLogoutField pUserLogout, int nRequestID) {
		return traderApi.ReqUserLogout(Pointer.pointerTo(pUserLogout), nRequestID);
	}
	
	/**
	 * 用户口令更新请求
	 * @param pUserPasswordUpdate
	 * @param nRequestID
	 * @return 请求发送状态
	 */
	public int reqUserPasswordUpdate(CThostFtdcUserPasswordUpdateField pUserPasswordUpdate, int nRequestID) {
		return traderApi.ReqUserPasswordUpdate(Pointer.pointerTo(pUserPasswordUpdate), nRequestID);
	}
	
	/**
	 * 资金账户口令更新请求
	 * @param pTradingAccountPasswordUpdate
	 * @param nRequestID
	 * @return 请求发送状态
	 */
	public int reqTradingAccountPasswordUpdate(CThostFtdcTradingAccountPasswordUpdateField pTradingAccountPasswordUpdate, int nRequestID) {
		return traderApi.ReqTradingAccountPasswordUpdate(Pointer.pointerTo(pTradingAccountPasswordUpdate), nRequestID);
	}
	
	
}
