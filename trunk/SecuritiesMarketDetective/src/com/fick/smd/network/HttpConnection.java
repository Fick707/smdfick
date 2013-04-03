package com.fick.smd.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.CommonUtils;
import com.fick.smd.hibernate.formbean.stockbean.Stock;

public class HttpConnection implements Connection {
	private static final Log log = LogFactory.getLog(HttpConnection.class);

	private static final String httpUrl = "http://hq.sinajs.cn/";

	private String code;

	private URL url;
	private HttpURLConnection connection;

	private int connectionErrorNum = 0;

	public HttpConnection(String code) {
		this.code = code;
		try {
			url = new URL(httpUrl + "list=" + this.code);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public synchronized Stock getStock(String code) {
		try {
			connectionErrorNum = 0;
			connection = (HttpURLConnection) url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
			String curr_line = "";
			while ((curr_line = br.readLine()) != null) {
				curr_line = curr_line.substring(curr_line.indexOf("\"") + 1, curr_line.lastIndexOf("\""));
				curr_line = code + "," + curr_line;
				break;
			}
			return curr_line != null ? CommonUtils.stringsToStock(curr_line.split(",")) : null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			connectionErrorNum++;
			if (connectionErrorNum <= 5) {
				log.warn("network connection error,check the network please!");
			}
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
				connection = null;
			}
		}
	}

	@Override
	public void connect() {

	}

	public static void main(String[] args) {
		HttpConnection co = new HttpConnection("sh600000");
		long b = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			// co.getStock(code);
		}
		long e = System.currentTimeMillis();
		System.out.println(e - b);
	}

}
