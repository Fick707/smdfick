package com.fick.smd.enter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;
import com.fick.smd.common.StockCommon;
import com.fick.smd.esper.EsperEngine;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockDef;
import com.fick.smd.work.StockAnalysisWorkThread;
import com.fick.smd.work.StockWorkThread;
import com.fick.smd.work.ThreadSwitch;

public class Processor {
	private static final Log log = LogFactory.getLog(Processor.class);
	private Socket socket;

	private DaoMethodTemplate dmt = new DaoMethodTemplate();
	private DaoImplStockDef stockDefDao = new DaoImplStockDef();

	public Processor(Socket socket) {
		this.socket = socket;
	}

	public void process() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			String cmd = br.readLine();
			log.info("received cmd:" + cmd);
			if (Constants.getProperty("START_ENGINE").equals(cmd.substring(1, 5))) {
				EsperEngine engine = new EsperEngine();
				engine.startEngine();
				bw.write("start engine successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
			} else if (Constants.getProperty("START_STOCK_WORK_THREAD").equals(cmd.subSequence(1, 5))) {
				ThreadSwitch.switchStockWorkThread(true);
				List<String> codes = (List<String>) dmt.process(stockDefDao, 3);
				for (String code : codes) {
					StockWorkThread stockWorkThread = new StockWorkThread(code);
					stockWorkThread.start();
				}
				bw.write("start stock work thread(s) successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
			} else if (Constants.getProperty("STOP_STOCK_WORK_THREAD").equals(cmd.subSequence(1, 5))) {
				ThreadSwitch.switchStockWorkThread(false);
				bw.write("stop stock work thread successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("close the StockWorkThread!");
			} else if (Constants.getProperty("START_STOCK_ANALYSIS_WORK_THREAD").equals(cmd.subSequence(1, 5))) {
				ThreadSwitch.switchStockAnalysisWorkThread(true);
				List<String> codes = (List<String>) dmt.process(stockDefDao, 4);
				for (String code : codes) {
					StockAnalysisWorkThread stockAnalysisWorkThread = new StockAnalysisWorkThread(code);
					stockAnalysisWorkThread.start();
				}
				bw.write("start stock analysis work thread(s) successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
			} else if (Constants.getProperty("STOP_STOCK_ANALYSIS_WORK_THREAD").equals(cmd.subSequence(1, 5))) {
				ThreadSwitch.switchStockAnalysisWorkThread(false);
				bw.write("stop stock analysis work thread successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("close the StockAnalysisWorkThread!");
			} else if (Constants.getProperty("IS_WARN").equals(cmd.subSequence(1, 5))) {
				StockCommon.setIsWarn(true);
				bw.write("open the warn switch successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("open the warn switch!");
			} else if (Constants.getProperty("NO_WARN").equals(cmd.subSequence(1, 5))) {
				StockCommon.setIsWarn(false);
				bw.write("close the warn switch successfully!from socket server!\n");
				bw.write("00\n");
				bw.flush();
				log.info("close the warn switch!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("wrong cmd socket!");
			e.printStackTrace();
		}
	}
}
