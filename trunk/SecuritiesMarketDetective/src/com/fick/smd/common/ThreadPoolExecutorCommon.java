package com.fick.smd.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ThreadPoolExecutorCommon {

	private static final Log log = LogFactory.getLog(ThreadPoolExecutorCommon.class);

	public static BlockingQueue<Runnable> makeQueue(Integer capacity) {
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

	public static ThreadPoolExecutor getThreadPool(String name, BlockingQueue<Runnable> queue, int numThreads)
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
