package com.fick.smd.esper.input;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.fick.smd.common.Constants;

public class InputAdapter {

	private static final EPServiceProvider engine = EPServiceProviderManager.getProvider(Constants.getProperty("ENGINEURI"));

	public static void sendEvent(Object obj) {
		if (obj != null) {
			engine.getEPRuntime().sendEvent(obj);
		}
	}

}
