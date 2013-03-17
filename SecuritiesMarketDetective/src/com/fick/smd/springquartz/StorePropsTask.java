package com.fick.smd.springquartz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fick.smd.common.ServiceCommon;
import com.fick.smd.common.StockCommon;
import com.fick.smd.common.StockPropType;
import com.fick.smd.hibernate.DaoMethodTemplate;
import com.fick.smd.hibernate.dao.DaoImplStockProps;
import com.fick.smd.hibernate.formbean.stockbean.StockProps;

public class StorePropsTask {
	private static final Log log = LogFactory.getLog(StorePropsTask.class);

	private DaoMethodTemplate dmt = new DaoMethodTemplate();
	private DaoImplStockProps rateDao = new DaoImplStockProps();

	public void process() {
		log.info("begin to close stock storages!");
		ServiceCommon.getStockStorageService().closeStorages();
		log.info("end to close stock storages!");
		log.info("begin to store props of stocks for analysising!");
		Map<String, Map<StockPropType, Float>> propsMap = StockCommon.getStockProps();
		List<StockProps> rates = new ArrayList<StockProps>();
		StockProps rate;
		for (String key : propsMap.keySet()) {
			Map<StockPropType, Float> props = propsMap.get(key);
			rate = new StockProps();
			rate.setStockcode(key);
			if (props.get(StockPropType.PRICE_MAX) != null && props.get(StockPropType.PRICE_MIN) != null && props.get(StockPropType.PRICE_YESTERDAY) != null) {
				rate.setPricehighest(props.get(StockPropType.PRICE_MAX));
				rate.setPricelowest(props.get(StockPropType.PRICE_MIN));
				rate.setPriceyestoday(props.get(StockPropType.PRICE_YESTERDAY));
				rate.setMaxrate(StockCommon.getMaxRate(rate.getPricehighest(), rate.getPricelowest(), rate.getPriceyestoday()));
			}
			if (props.get(StockPropType.PRICE_TODAY) != null) {
				rate.setPricetoday(props.get(StockPropType.PRICE_TODAY));
			}
			if (props.get(StockPropType.PRICE_TODAY_END) != null) {
				rate.setPricetodayend(props.get(StockPropType.PRICE_TODAY_END));
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
