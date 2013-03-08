package com.fick.smd.esper.output;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;

public class OutboundService {
	private static final Log log = LogFactory.getLog(OutboundService.class);

	private static BlockingQueue<Runnable> outboundQueue;
	private static ThreadPoolExecutor outboundThreadPool;

	static {
		log.debug("initial the outbound service!");
		outboundQueue = makeQueue(Constants.OUTBOUND_QUEUE_CAPACITY);
		outboundThreadPool = getThreadPool("outbound", outboundQueue, Constants.OUTBOUND_THREAD_POOL_CAPACITY);
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

	private static BlockingQueue<Runnable> makeQueue(Integer capacity) {
		if ((capacity == null) ||
				(capacity <= 0) ||
				(capacity == Integer.MAX_VALUE))
		{
			return new LinkedBlockingQueue<Runnable>();
		}
		else
		{
			return new ArrayBlockingQueue<Runnable>(capacity);
		}
	}

	private static ThreadPoolExecutor getThreadPool(String name, BlockingQueue<Runnable> queue, int numThreads)
	{
		if (log.isInfoEnabled())
		{
			log.info("Starting pool " + name + " with " + numThreads + " threads");
		}

		String threadGroupName = "com.fick.smd-" + name;
		ThreadGroup threadGroup = new ThreadGroup(threadGroupName);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(numThreads, numThreads, 1, TimeUnit.SECONDS, queue, new ThreadPoolExecutor.DiscardOldestPolicy());
		pool.prestartAllCoreThreads();

		return pool;
	}

}
