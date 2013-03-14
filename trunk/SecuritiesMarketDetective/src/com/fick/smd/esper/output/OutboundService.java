package com.fick.smd.esper.output;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;
import com.fick.smd.common.ThreadPoolExecutorCommon;

public class OutboundService {
	private static final Log log = LogFactory.getLog(OutboundService.class);

	private static BlockingQueue<Runnable> outboundQueue;
	private static ThreadPoolExecutor outboundThreadPool;

	static {
		log.debug("initial the outbound service!");
		outboundQueue = ThreadPoolExecutorCommon.makeQueue(Constants.OUTBOUND_QUEUE_CAPACITY);
		outboundThreadPool = ThreadPoolExecutorCommon.getThreadPool("outbound", outboundQueue, Constants.OUTBOUND_THREAD_POOL_CAPACITY);
		log.info("initial the outbound service successfully!");
	}

	public static void submitOut(OutboundRunnableUnit unit) {
		try {
			outboundQueue.put(unit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.warn("submit out interrupted");
		}
	}

}
