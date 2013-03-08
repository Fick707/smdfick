/*
-- Query: SELECT * FROM smddb.epldef
LIMIT 0, 1000

-- Date: 2013-03-08 15:26
*/
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (1,'epl基本查询','select code,name,datetime, price_current as price,price_yesterday,price_today,max(price_highest) as price_max,min(price_lowest) as price_min,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)','select code,name,datetime, price_current as price,price_yesterday,price_today,max(price_highest) as price_max,min(price_lowest) as price_min,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)',2,'com.fick.smd.esper.listener.MyTestListener',3,'基本分析','2013-02-26 09:17:57');
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (2,'股票涨跌幅分析','select code,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)','select code,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)',1,'com.fick.smd.esper.listener.StockAnalysisListener',3,'分析','2013-02-28 09:17:57');
