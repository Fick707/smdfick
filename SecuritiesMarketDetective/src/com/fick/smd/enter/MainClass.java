package com.fick.smd.enter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainClass {
	private static final Log log = LogFactory.getLog(MainClass.class);

	public static void main(String[] args) {
		log.info("waiting for cmds");
		try {
			ServerSocket engineSocketServer = new ServerSocket(4512);
			while (true) {
				Socket socket = engineSocketServer.accept();
				new Processor(socket).process();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("IOException lead to system exit!");
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
