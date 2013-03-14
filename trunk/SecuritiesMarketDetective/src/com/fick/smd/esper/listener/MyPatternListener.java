package com.fick.smd.esper.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.fick.smd.esper.output.EventProcessorInterface;
import com.fick.smd.esper.output.OutputAdapter;
import com.fick.smd.hibernate.formbean.stockbean.Stock;

public class MyPatternListener implements UpdateListener {
	private static final Log log = LogFactory.getLog(MyPatternListener.class);
	private boolean isFirst = true;

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		// TODO Auto-generated method stub
		// log.info("侦测到数据！");
		EventBean bean = newEvents[0];
		OutputAdapter.deal(bean, new EventProcessorInterface() {

			@Override
			public void processEvent(EventBean bean) {
				// TODO Auto-generated method stub
				// 1.更新振幅
				Stock stock = (Stock) bean.get("b");
				Stock stockA = (Stock) bean.get("a");
				Stock stockC = (Stock) bean.get("c");
				System.err.println("--------------------------");
				System.err.println(stockA.getName());
				System.err.println(stock.getName());
				System.err.println(stockC.getName());
				System.err.println(stockA.getPrice_current());
				System.err.println(stock.getPrice_current());
				System.err.println(stockC.getPrice_current());
			}
		});
	}
}
