package com.fick.smd.esper.listener;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.fick.smd.common.StockCommon;
import com.fick.smd.common.StockStorageCommon;
import com.fick.smd.esper.output.EventProcessorInterface;
import com.fick.smd.esper.output.OutputAdapter;
import com.fick.smd.hibernate.formbean.stockbean.StockStorage;

public class PatternHighestListener implements UpdateListener {
	private static final Log log = LogFactory.getLog(PatternHighestListener.class);

	@Override
	public void update(EventBean[] newEvents, EventBean[] oldEvents) {
		// TODO Auto-generated method stub
		// log.info("侦测到数据！");
		EventBean bean = newEvents[0];
		OutputAdapter.deal(bean, new EventProcessorInterface() {

			@Override
			public void processEvent(EventBean bean) {
				// TODO Auto-generated method stub
				String code = (String) bean.get("code");
				String name = (String) bean.get("name");
				float price = (Float) bean.get("price");
				log.info(code + ":" + name + " 当前价格:" + price);
				// 在这里得到平均振幅及今天的平均值，根据平均值判断是否可卖
				StockStorage stockStorage = StockCommon.isSellOk(code, price);
				if (stockStorage != null) {
					StockStorageCommon.sellAt(price, stockStorage);
					if (StockCommon.getIsWarn()) {
						JOptionPane.showMessageDialog(null, code + ":" + name + "波峰出现，卖出了 !价格:" + price, "卖出提示", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
}
