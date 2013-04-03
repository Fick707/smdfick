truncate table epldef;
/*
-- Query: SELECT * FROM smddb_test.epldef
LIMIT 0, 1000

-- Date: 2013-04-01 11:11
*/
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (1,'最高点始跌侦测','select c.code as code,c.name as name,c.datetime as datetime, c.price_current as price,c.price_yesterday as price_yesterday,c.price_today as price_today,c.price_highest as price_max,c.price_lowest as price_min from pattern[every a = Stock(code in (?)) -> ( b = Stock(b.code = a.code,b.price_current > a.price_current) and not t = Stock(t.code = a.code,t.price_current <= a.price_current)) -> (c = Stock(c.code = a.code,c.price_current < b.price_current) and not m = Stock(m.code = a.code,m.price_current >= b.price_current))]','select c.code as code,c.name as name,c.datetime as datetime, c.price_current as price,c.price_yesterday as price_yesterday,c.price_today as price_today,c.price_highest as price_max,c.price_lowest as price_min from pattern[every a = Stock(code in (\'item1\',\'item3\')) -> ( b = Stock(b.code = a.code,b.price_current > a.price_current) and not t = Stock(t.code = a.code,t.price_current <= a.price_current)) -> (c = Stock(c.code = a.code,c.price_current < b.price_current) and not m = Stock(m.code = a.code,m.price_current >= b.price_current))]',2,'com.fick.smd.esper.listener.PatternHighestListener',3,'利用pattern侦测波峰','2013-03-15 09:17:57');
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (2,'股票涨跌幅分析','select code,max(price_highest) as price_max,min(price_lowest) as price_min from Stock(code in (?)).win:time(10 hours) group by (code)','select code,max(price_highest) as price_max,min(price_lowest) as price_min from Stock(code in (?)).win:time(10 hours) group by (code)',1,'com.fick.smd.esper.listener.StockAnalysisListener',1,'分析','2013-02-28 09:17:57');
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (3,'epl模式匹配测试','select a,b,c from pattern[every (a = Stock -> b = Stock(b.code = a.code,b.price_current > a.price_current) -> c = Stock(c.code = b.code,c.price_current < b.price_current))]','select a,b from pattern[every a = Stock -> every b = Stock(b.code = a.code)]',1,'com.fick.smd.esper.listener.MyPatternListener',1,NULL,'2013-03-14 13:55:00');
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (4,'最低点始涨侦测','select c.code as code,c.name as name,c.datetime as datetime, c.price_current as price,c.price_yesterday as price_yesterday,c.price_today as price_today,c.price_highest as price_max,c.price_lowest as price_min from pattern[every a = Stock(code in (?)) -> ( b = Stock(b.code = a.code,b.price_current < a.price_current) and not t = Stock(t.code = a.code,t.price_current >= a.price_current)) -> (c = Stock(c.code = a.code,c.price_current > b.price_current) and not m = Stock(m.code = a.code,m.price_current <= b.price_current))]','select c.code as code,c.name as name,c.datetime as datetime, c.price_current as price,c.price_yesterday as price_yesterday,c.price_today as price_today,c.price_highest as price_max,c.price_lowest as price_min from pattern[every a = Stock(code in (\'item1\',\'item3\')) -> ( b = Stock(b.code = a.code,b.price_current < a.price_current) and not t = Stock(t.code = a.code,t.price_current >= a.price_current)) -> (c = Stock(c.code = a.code,c.price_current > b.price_current) and not m = Stock(m.code = a.code,m.price_current <= b.price_current))]',2,'com.fick.smd.esper.listener.PatternLowestListener',3,'利用pattern侦测波谷','2013-03-15 09:17:57');
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (5,'最高点侦测','select b.code as code,b.name as name,b.datetime as datetime, b.price_current as price,b.price_yesterday as price_yesterday,b.price_today as price_today,b.price_highest as price_max,b.price_lowest as price_min from pattern[every a = Stock(code in (?)) -> ( b = Stock(b.code = a.code,b.price_current > a.price_current) and not t = Stock(t.code = a.code,t.price_current <= a.price_current))]','select b.code as code,b.name as name,b.datetime as datetime, b.price_current as price,b.price_yesterday as price_yesterday,b.price_today as price_today,b.price_highest as price_max,b.price_lowest as price_min from pattern[every a = Stock(code in (?)) -> ( b = Stock(b.code = a.code,b.price_current > a.price_current) and not t = Stock(t.code = a.code,t.price_current <= a.price_current))]',2,'com.fick.smd.esper.listener.PatternHighestListener',3,'利用pattern侦测最高点','2013-04-01 11:07:00');
INSERT INTO `epldef` (`id`,`eplname`,`eplrun`,`eplshow`,`type`,`listenerclassname`,`eplst`,`remark`,`updatedt`) VALUES (6,'最低点侦测','select b.code as code,b.name as name,b.datetime as datetime, b.price_current as price,b.price_yesterday as price_yesterday,b.price_today as price_today,b.price_highest as price_max,b.price_lowest as price_min from pattern[every a = Stock(code in (?)) -> ( b = Stock(b.code = a.code,b.price_current < a.price_current) and not t = Stock(t.code = a.code,t.price_current >= a.price_current))]','select b.code as code,b.name as name,b.datetime as datetime, b.price_current as price,b.price_yesterday as price_yesterday,b.price_today as price_today,b.price_highest as price_max,b.price_lowest as price_min from pattern[every a = Stock(code in (?)) -> ( b = Stock(b.code = a.code,b.price_current < a.price_current) and not t = Stock(t.code = a.code,t.price_current >= a.price_current))]',2,'com.fick.smd.esper.listener.PatternLowestListener',3,'利用pattern侦测最低点','2013-04-01 11:07:00');