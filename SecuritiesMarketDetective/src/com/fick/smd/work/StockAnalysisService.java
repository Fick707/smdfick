package com.fick.smd.work;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;
import com.fick.smd.common.ThreadPoolExecutorCommon;

public class StockAnalysisService {

	private static final Log log = LogFactory.getLog(StockAnalysisService.class);

	private static BlockingQueue<Runnable> analysisQueue;
	private static ThreadPoolExecutor analysisThreadPool;
	static {
		log.debug("initial the analysis service!");
		analysisQueue = ThreadPoolExecutorCommon.makeQueue(Constants.ANALYSIS_QUEUE_CAPACITY);
		analysisThreadPool = ThreadPoolExecutorCommon.getThreadPool("analysis", analysisQueue, Constants.ANALYSIS_THREAD_POOL_CAPACITY);
		log.info("initial the analysis service successfully!");
	}

	public static void submitAnalysis(StockAnalysisRunnableUnit unit) {
		try {
			analysisQueue.put(unit);
			// analysisQueue.add(unit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.warn("submit analysis interrupted");
		}
	}
}
