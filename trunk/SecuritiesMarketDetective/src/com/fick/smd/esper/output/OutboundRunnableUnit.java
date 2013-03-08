package com.fick.smd.esper.output;

import com.espertech.esper.client.EventBean;

public class OutboundRunnableUnit implements Runnable {

	/**
	 * 触发的事件；
	 */
	private EventBean bean;
	private EventProcessorInterface processor;

	public OutboundRunnableUnit(EventBean bean, EventProcessorInterface processor) {
		this.bean = bean;
		this.processor = processor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		processor.processEvent(bean);
	}

}
