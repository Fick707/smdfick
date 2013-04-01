package com.fick.smd.enter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;
import com.fick.smd.common.StockCommon;
import com.fick.smd.common.StockDefCommon;
import com.fick.smd.common.StockStorageCommon;
import com.fick.smd.esper.EsperEngine;
import com.fick.smd.utils.ByteUtil;
import com.fick.smd.utils.DES;
import com.fick.smd.work.ThreadSwitch;

public class Processor {
	private static final Log log = LogFactory.getLog(Processor.class);
	private Socket socket;

	public Processor(Socket socket) {
		this.socket = socket;
	}

	public void process() {
		InputStream is = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			is = socket.getInputStream();
			out = socket.getOutputStream();
			// br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			byte[] lenb = new byte[4];
			is.read(lenb);
			int len = ByteUtil.bytesToInt(lenb);
			byte[] contents = new byte[len];
			is.read(contents);
			String cmd = new String(DES.decrypt(contents));
			log.info("received cmd:" + cmd);
			if (cmd.length() <= 5) {
				return;
			}
			String command = cmd.substring(1, 5);
			if (Constants.getProperty("COMMAND_START_ENGINE").equals(command)) {
				EsperEngine engine = new EsperEngine();
				engine.startEngine();
				bw.write("start engine successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
			} else if (Constants.getProperty("COMMAND_START_STOCK_WORK_THREAD").equals(command)) {
				ThreadSwitch.switchStockWorkThread(true);
				StockDefCommon.startStockWorkThread();
				bw.write("start stock work thread(s) successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
			} else if (Constants.getProperty("COMMAND_STOP_STOCK_WORK_THREAD").equals(command)) {
				ThreadSwitch.switchStockWorkThread(false);
				bw.write("stop stock work thread successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("close the StockWorkThread!");
			} else if (Constants.getProperty("COMMAND_START_STOCK_ANALYSIS_WORK_THREAD").equals(command)) {
				ThreadSwitch.switchStockAnalysisWorkThread(true);
				StockDefCommon.startStockAnalysisWorkThread();
				bw.write("start stock analysis work thread(s) successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
			} else if (Constants.getProperty("COMMAND_STOP_STOCK_ANALYSIS_WORK_THREAD").equals(command)) {
				ThreadSwitch.switchStockAnalysisWorkThread(false);
				bw.write("stop stock analysis work thread successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("close the StockAnalysisWorkThread!");
			} else if (Constants.getProperty("COMMAND_IS_WARN").equals(command)) {
				StockCommon.setIsWarn(true);
				bw.write("open the warn switch successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("open the warn switch!");
			} else if (Constants.getProperty("COMMAND_NO_WARN").equals(command)) {
				StockCommon.setIsWarn(false);
				bw.write("close the warn switch successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("close the warn switch!");
			} else if (Constants.getProperty("COMMAND_BUY_BY_CODE_AT_CURR_PRICE").equals(command)) {
				String code = cmd.substring(6, cmd.lastIndexOf("$"));
				StockStorageCommon.buyAtByCodeViaCommand(code);
				bw.write("buy by code via command successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("buy by code via command successfully!");
			} else if (Constants.getProperty("COMMAND_SELL_BY_CODE_AT_CURR_PRICE").equals(command)) {
				String code = cmd.substring(6, cmd.lastIndexOf("$"));
				StockStorageCommon.sellAtByCodeViaCommon(code);
				bw.write("sell by code via command successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("sell by code via command successfully!");
			} else if (Constants.getProperty("COMMAND_ADD_STOCK_DEF_BY_CODE").equals(command)) {
				String code = cmd.substring(6, cmd.lastIndexOf("$"));
				StockDefCommon.addStockDefByCode(code);
				bw.write("add stock def by code via command successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("add stock def by code via command successfully!");
			} else if (Constants.getProperty("COMMAND_SET_AMPLITUDE_RATE").equals(command)) {
				String value = cmd.substring(6, cmd.lastIndexOf("$"));
				Constants.setProperty("AMPLITUDE_RATE", value);
				bw.write("set amplitude rate via command successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("set amplitude rate via command successfully!");
			} else if (Constants.getProperty("COMMAND_COMPARE_BUY_SELL").equals(command)) {
				String value = cmd.substring(6, cmd.lastIndexOf("$"));
				String[] vals = value.split("#");
				float sellP = Float.parseFloat(vals[0]);
				float buyP = Float.parseFloat(vals[1]);
				int dealNum = Integer.parseInt(vals[2]);
				float money = StockStorageCommon.compareBuyAndSell(buyP, sellP, dealNum);
				bw.write("get result successfully!from socket server!\n");
				bw.write("earning money:" + money + "\n");
				bw.write("02\n");
				bw.flush();
				log.info("set amplitude rate via command successfully!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("wrong cmd socket!");
			dealErrorCommand(socket);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("error command!");
			dealErrorCommand(socket);
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (br != null) {
					br.close();
				}
				if (out != null) {
					out.close();
				}
				if (is != null) {
					is.close();
				}
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void dealErrorCommand(Socket socket) {
		try {
			OutputStream out = socket.getOutputStream();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			bw.write("command error!\n");
			bw.write("-1\n");
			bw.flush();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
