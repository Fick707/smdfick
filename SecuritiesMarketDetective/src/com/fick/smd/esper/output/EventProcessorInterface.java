package com.fick.smd.esper.output;

import com.espertech.esper.client.EventBean;

public interface EventProcessorInterface {
	public void processEvent(EventBean bean);
}
