package com.fick.smd.esper.output;

import com.espertech.esper.client.EventBean;

public class OutputAdapter {

	public synchronized static void deal(EventBean bean, EventProcessorInterface processor) {
		OutboundService.submitOut(new OutboundRunnableUnit(bean, processor));
	}

}
