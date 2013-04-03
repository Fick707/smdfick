package com.fick.smd.esper.listener;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.fick.smd.esper.output.EventProcessorInterface;
import com.fick.smd.esper.output.OutputAdapter;

public class StockAnalysisListener implements UpdateListener {
	// private static final Log log = LogFactory.getLog(StockAnalysisListener.class);

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		// TODO Auto-generated method stub
		EventBean bean = newEvents[0];
		OutputAdapter.deal(bean, new EventProcessorInterface() {

			@Override
			public void processEvent(EventBean bean) {
				// TODO Auto-generated method stub
				// 1.更新振幅

			}

		});
	}
}
