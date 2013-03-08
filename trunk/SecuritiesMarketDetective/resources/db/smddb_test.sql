CREATE DATABASE  IF NOT EXISTS `smddb_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `smddb_test`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: smddb_test
-- ------------------------------------------------------
-- Server version	5.6.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `epldef`
--

DROP TABLE IF EXISTS `epldef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `epldef` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `eplname` varchar(45) DEFAULT NULL COMMENT 'epl名称',
  `eplrun` varchar(1000) DEFAULT NULL COMMENT 'epl运行表达式',
  `eplshow` varchar(1000) DEFAULT NULL COMMENT 'epl显示的表达式',
  `type` int(11) DEFAULT '1' COMMENT '类型：\n1.分析\n2.关注',
  `listenerclassname` varchar(500) DEFAULT 'com.fick.smd.esper.listener.MyTestListener',
  `eplst` int(11) DEFAULT NULL COMMENT 'epl状态\n1.\n2.\n3.运行',
  `remark` varchar(500) DEFAULT NULL COMMENT 'epl描述',
  `updatedt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'epl更新日期时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='esper epl定义表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `epldef`
--

LOCK TABLES `epldef` WRITE;
/*!40000 ALTER TABLE `epldef` DISABLE KEYS */;
INSERT INTO `epldef` VALUES (1,'epl基本查询','select code,name,datetime, price_current as price,price_yesterday,price_today,max(price_highest) as price_max,min(price_lowest) as price_min,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)','select code,name,datetime, price_current as price,price_yesterday,price_today,max(price_highest) as price_max,min(price_lowest) as price_min,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)',2,'com.fick.smd.esper.listener.MyTestListener',3,'基本分析','2013-02-26 09:17:57'),(2,'股票涨跌幅分析','select code,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)','select code,max(change_rate) as rate_max, min(change_rate) as rate_min from Stock(code in (?)).win:time(10 hours) group by (code)',1,'com.fick.smd.esper.listener.StockAnalysisListener',3,'分析','2013-02-28 09:17:57');
/*!40000 ALTER TABLE `epldef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockdef`
--

DROP TABLE IF EXISTS `stockdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockdef` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockcode` varchar(45) DEFAULT NULL COMMENT '股票代码',
  `stockname` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `stockst` int(11) DEFAULT '1' COMMENT '股票状态：\n1.分析\n3.交易',
  `type` int(11) DEFAULT '1' COMMENT '股票类型\n1.普通A股\n0.指数',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `updatedt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockdef`
--

LOCK TABLES `stockdef` WRITE;
/*!40000 ALTER TABLE `stockdef` DISABLE KEYS */;
INSERT INTO `stockdef` VALUES (1,'sh600446','金证股份',1,1,NULL,'2013-02-25 13:59:38'),(3,'sz000002','万  科Ａ',1,1,NULL,'2013-02-26 09:23:11'),(8,'sh000001','上证指数',1,0,NULL,'2013-02-28 09:00:49'),(9,'sh601901','方正证券',1,1,NULL,'2013-02-28 09:00:49'),(10,'sh600000','浦发银行',3,1,NULL,'2013-02-28 09:00:49'),(11,'sh601166','兴业银行',1,1,NULL,'2013-02-28 09:00:50'),(12,'sh600036','招商银行',1,1,NULL,'2013-03-05 12:25:06');
/*!40000 ALTER TABLE `stockdef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockprops`
--

DROP TABLE IF EXISTS `stockprops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockprops` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockcode` varchar(45) NOT NULL COMMENT '股票代码',
  `maxrate` float NOT NULL COMMENT '涨跌幅度',
  `pricehighest` float DEFAULT NULL,
  `pricelowest` float DEFAULT NULL,
  `priceyestoday` float DEFAULT NULL,
  `pricetoday` float DEFAULT NULL,
  `pricetodayend` float DEFAULT NULL,
  `updatedate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockprops`
--

LOCK TABLES `stockprops` WRITE;
/*!40000 ALTER TABLE `stockprops` DISABLE KEYS */;
/*!40000 ALTER TABLE `stockprops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syschangelog`
--

DROP TABLE IF EXISTS `syschangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syschangelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(20) DEFAULT NULL COMMENT '版本信息',
  `author` varchar(45) DEFAULT 'Fick Song' COMMENT '作者',
  `operator` varchar(45) DEFAULT 'Fick Song' COMMENT '操作者',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `updatedt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '日志更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='系统更新日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syschangelog`
--

LOCK TABLES `syschangelog` WRITE;
/*!40000 ALTER TABLE `syschangelog` DISABLE KEYS */;
INSERT INTO `syschangelog` VALUES (1,'1.0','Fick Song','Fick Song','系统初始更新，系统创建，数据库搭建，架构搭建','2013-02-20 12:39:43'),(6,'1.0.1','Fick Song','宋飞','测试用','2013-02-22 09:51:53');
/*!40000 ALTER TABLE `syschangelog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-05 16:53:05
