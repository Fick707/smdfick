package com.fick.smd.esper.listener;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.fick.smd.common.Constants;
import com.fick.smd.common.StockCommon;
import com.fick.smd.esper.output.EventProcessorInterface;
import com.fick.smd.esper.output.OutputAdapter;

public class MyTestListener implements UpdateListener {
	private static final Log log = LogFactory.getLog(MyTestListener.class);
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
				StockCommon.upStockProps(bean);
				if (isFirst) {
					float t = (Float) bean.get(Constants.PRICE_TODAY);
					float y = (Float) bean.get(Constants.PRICE_YESTERDAY);
					log.info("price_today:" + t);
					log.info("price_yesterday:" + y);
					log.info((t - y) > 0 ? "高开" : (t - y) == 0 ? "平开" : "低开");
					isFirst = false;
				}
				String code = (String) bean.get("code");
				String name = (String) bean.get("name");
				float price = (Float) bean.get("price");
				log.info(code + ":" + name + " 当前价格:" + price);
				if (StockCommon.getIsWarn()) {
					float price_low = (Float) bean.get("price_min");
					float price_high = (Float) bean.get("price_max");
					if (price >= (price_high - 0.03)) {
						JOptionPane.showMessageDialog(null, code + ":" + name + "基本处于最高点，可以卖出了 !price:" + price, "卖出提示", JOptionPane.WARNING_MESSAGE);
					}
					if (price <= (price_low + 0.03)) {
						JOptionPane.showMessageDialog(null, code + ":" + name + "基本处于最低点，可以买入了 !price:" + price, "买入提示", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
}
