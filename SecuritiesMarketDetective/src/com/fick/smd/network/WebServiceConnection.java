package com.fick.smd.network;

import java.net.URL;

import javax.xml.namespace.QName;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.ChinaStockWebService;
import cn.com.webxml.ChinaStockWebServiceSoap;

import com.fick.smd.common.CommonUtils;
import com.fick.smd.hibernate.formbean.esperbean.Stock;

public class WebServiceConnection implements Connection {
	private static final QName SERVICE_NAME = new QName("http://WebXml.com.cn/", "ChinaStockWebService");
	private static final URL wsdlURL = ChinaStockWebService.WSDL_LOCATION;
	private static final ChinaStockWebService ss = new ChinaStockWebService(wsdlURL, SERVICE_NAME);
	private static final ChinaStockWebServiceSoap port = ss.getChinaStockWebServiceSoap();

	@Override
	public void connect() {

	}

	@Override
	public Stock getStock(String code) {
		ArrayOfString retVal = port.getStockInfoByCode(code);
		return CommonUtils.arrayToStock(retVal);
	}

}
