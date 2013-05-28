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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='esper epl定义表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockdealdetail`
--

DROP TABLE IF EXISTS `stockdealdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockdealdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockcode` varchar(45) NOT NULL COMMENT '股票代码',
  `dealtype` int(11) NOT NULL COMMENT '交易类型：\n0：买入\n1：卖出\n2：卖出非今日股票',
  `dealprice` float NOT NULL COMMENT '交易价格',
  `dealNum` int(11) NOT NULL COMMENT '交易数量',
  `dealcost` float NOT NULL COMMENT '共花费',
  `dealdt` datetime NOT NULL COMMENT '交易时间',
  `dealst` int(11) NOT NULL DEFAULT '0' COMMENT '交易状态：\n0.正常；\n1.当天买了未卖',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockdef`
--

DROP TABLE IF EXISTS `stockdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockdef` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockcode` varchar(45) NOT NULL COMMENT '股票代码',
  `stockname` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `stockst` int(11) DEFAULT '1' COMMENT '股票状态：\n1.分析\n3.交易',
  `type` int(11) DEFAULT '1' COMMENT '股票类型\n1.普通A股\n0.指数',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `updatedt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `stockcode_UNIQUE` (`stockcode`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stockstorage`
--

DROP TABLE IF EXISTS `stockstorage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stockstorage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockcode` varchar(45) NOT NULL COMMENT '股票代码',
  `investment` float DEFAULT NULL COMMENT '初始投入资金',
  `balance` float DEFAULT NULL COMMENT '余额',
  `dealnum` int(11) NOT NULL DEFAULT '500' COMMENT '每次交易量',
  `expectearning` float DEFAULT '15',
  `stocknum` int(11) DEFAULT NULL COMMENT '可用股票数量',
  `lockedstocknum` int(11) DEFAULT NULL COMMENT '不可用股票数据',
  `storagestate` int(11) NOT NULL DEFAULT '1' COMMENT '仓库状态\n1.正常交易\n2.关仓停止交易',
  `amplituderate` float DEFAULT NULL,
  `priceavgoffset` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `stockcode_UNIQUE` (`stockcode`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='股票仓库';
/*!40101 SET character_set_client = @saved_cs_client */;

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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-28 11:08:53
