package com.fick.smd.test.esper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

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

	private void sendCmd(String cmd) {
		try {
			OutputStream out = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			out.write((cmd + "\n").getBytes());
			out.flush();
			String retV = "";
			while ((retV = br.readLine()) != null) {
				System.out.println(retV);
				if ("00".equals(retV) || "01".equals(retV)) {
					return;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
