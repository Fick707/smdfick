package com.fick.smd.test.esper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

import com.fick.smd.utils.ByteUtil;
import com.fick.smd.utils.DES;

public class SocketClient {

	private static Socket socket = null;

	public SocketClient() {
		try {
			socket = new Socket("localhost", 4500);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void startEngine() {
		sendCmd("$1000$");
	}

	@Test
	public void startStockWorkThread() {
		sendCmd("$2000$");
	}

	@Test
	public void stopStockWorkThread() {
		sendCmd("$2001$");
	}

	@Test
	public void startStockAnalysisWorkThread() {
		sendCmd("$3000$");
	}

	@Test
	public void stopStockAnalysisWorkThread() {
		sendCmd("$3001$");
	}

	@Test
	public void openWarnSwitch() {
		sendCmd("$4000$");
	}

	@Test
	public void closeWarnSwitch() {
		sendCmd("$4001$");
	}

	@Test
	public void buyByCodeAtCurrPrice(String code) {
		sendCmd("$8001$" + code + "$");
	}

	@Test
	public void sellByCodeAtCurrPrice(String code) {
		sendCmd("$8002$" + code + "$");
	}

	@Test
	public void addStockDefByCodeAtCurrPrice(String code) {
		sendCmd("$8003$" + code + "$");
	}

	@Test
	public void setAmplitudeRate(String rate) {
		sendCmd("$4002$" + rate + "$");
	}

	@Test
	public void compareBuyAndSell(String priceBuy, String priceSell, String dealNum) {
		sendCmd("$1100$" + priceBuy + "#" + priceSell + "#" + dealNum);
	}

	/**
	 * 发出命令并得到返回结果
	 * 返回结果00，01结尾，正常
	 * 返回结果02结尾，停留3秒
	 * 
	 * @param cmd
	 */
	private void sendCmd(String cmd) {
		try {
			OutputStream out = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			byte[] contents = DES.encrypt(cmd.getBytes());
			byte[] lenBytes = ByteUtil.integerToBytes(contents.length);
			out.write(lenBytes);
			out.write(contents);
			out.flush();
			String retV = "";
			while ((retV = br.readLine()) != null) {
				System.out.println(retV);
				if ("00".equals(retV) || "01".equals(retV)) {
					return;
				} else if ("02".equals(retV)) {
					Thread.sleep(3000);
					return;
				} else if ("-1".equals(retV)) {
					System.err.println("command error check cmmand please!");
					return;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("encrypt or decrypt error!");
		}
	}

	public static void main(String[] args) {
		try {
			SocketClient client = new SocketClient();
			if (args.length == 0 || "start".equals(args[0])) {
				client.startEngine();
				Thread.sleep(5000);
				client = new SocketClient();
				client.startStockAnalysisWorkThread();
				Thread.sleep(3000);
				client = new SocketClient();
				client.startStockWorkThread();
			} else if ("closewarn".equals(args[0])) {
				client.closeWarnSwitch();
			} else if ("openwarn".equals(args[0])) {
				client.openWarnSwitch();
			} else if ("buy".equals(args[0])) {
				String code = args[1];
				client.buyByCodeAtCurrPrice(code);
			} else if ("sell".equals(args[0])) {
				String code = args[1];
				client.sellByCodeAtCurrPrice(code);
			} else if ("addstockdef".equals(args[0])) {
				String code = args[1];
				client.addStockDefByCodeAtCurrPrice(code);
			} else if ("setamplituderate".equals(args[0])) {
				String val = args[1];
				client.setAmplitudeRate(val);
			} else if ("compare".equals(args[0])) {
				String priceBuy = args[1];
				String priceSell = args[2];
				String dealNum = args[3];
				client.compareBuyAndSell(priceBuy, priceSell, dealNum);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
