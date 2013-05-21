package org.hraink.futures.ctp.md;

import org.hraink.futures.jctp.md.JCTPMdApi;
import org.hraink.futures.jctp.md.JCTPMdSpi;
import org.junit.Test;

public class TestMd {
	/** 前置机地址 **/
//	String frontAddr = "tcp://asp-sim2-md1.financial-trading-platform.com:26213";
//	String frontAddr = "tcp://180.169.30.170:41213";
	String frontAddr = "tcp://211.136.142.218:9116";
	/** 行情API **/
	JCTPMdApi mdApi;
	JCTPMdSpi mdSpi;
	
	@Test
	public void spiTest() throws InterruptedException {
		mdApi = JCTPMdApi.createFtdcTraderApi();
		
		mdSpi = new MyMdSpi(mdApi);
		//注册spi
		mdApi.registerSpi(mdSpi);
		//注册前置机地址
		mdApi.registerFront(frontAddr);
		mdApi.Init();
		
		mdApi.Join();
		
//		TimeUnit.SECONDS.sleep(5);
		mdApi.Release();
	}
}
