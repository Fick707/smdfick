package com.fick.smd.springquartz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.Constants;
import com.fick.smd.common.StockCommon;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockProps;
import com.fick.smd.hibernate.formbean.esperbean.StockProps;

public class StorePropsTask {
	private static final Log log = LogFactory.getLog(StorePropsTask.class);

	private DaoMethodTemplate dmt = new DaoMethodTemplate();
	private DaoImplStockProps rateDao = new DaoImplStockProps();

	public void process() {
		log.info("begin to store props of stocks for analysising!");
		Map<String, Map<String, Float>> propsMap = StockCommon.getStockProps();
		List<StockProps> rates = new ArrayList<StockProps>();
		StockProps rate;
		for (String key : propsMap.keySet()) {
			Map<String, Float> props = propsMap.get(key);
			rate = new StockProps();
			rate.setStockcode(key);
			if (props.get(Constants.MAX_RATE) != null) {
				rate.setMaxrate(props.get(Constants.MAX_RATE));
			}
			if (props.get(Constants.PRICE_MAX) != null) {
				rate.setPricehighest(props.get(Constants.PRICE_MAX));
			}
			if (props.get(Constants.PRICE_MIN) != null) {
				rate.setPricelowest(props.get(Constants.PRICE_MIN));
			}
			if (props.get(Constants.PRICE_TODAY) != null) {
				rate.setPricetoday(props.get(Constants.PRICE_TODAY));
			}
			if (props.get(Constants.PRICE_TODAY_END) != null) {
				rate.setPricetodayend(props.get(Constants.PRICE_TODAY_END));
			}
			if (props.get(Constants.PRICE_YESTERDAY) != null) {
				rate.setPriceyestoday(props.get(Constants.PRICE_YESTERDAY));
			}
			rates.add(rate);
		}
		rateDao.setProps(rates);
		dmt.process(rateDao, 2);
		log.info("end to store props of stocks for analysising!");
		log.info("system will shutdown 60 seconds later!");
		try {
			Thread.sleep(60000);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
