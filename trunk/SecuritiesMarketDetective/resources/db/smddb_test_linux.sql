USE `smddb_test`;

/*!50003 CREATE*/ /*!50017 DEFINER=`fick707`@`localhost`*/ /*!50003 trigger epldef_updatedt before insert on smddb.epldef 
  for each row 
    if new.updatedt is null then 
      set new.updatedt = now(); 
    end if */;;
DELIMITER ;

/*!50003 CREATE*/ /*!50017 DEFINER=`fick707`@`localhost`*/ /*!50003 trigger syschangelog_updatedt before insert on smddb.syschangelog 
  for each row 
    if new.updatedt is null then 
      set new.updatedt = now(); 
    end if */;;
DELIMITER ;

/*!50003 CREATE*/ /*!50017 DEFINER=`fick707`@`localhost`*/ /*!50003 trigger stockprops_updatedt before insert on smddb.stockprops 
  for each row 
    if new.updatedate is null then 
      set new.updatedate = now(); 
    end if */;;
DELIMITER ;

/*!50003 CREATE*/ /*!50017 DEFINER=`fick707`@`localhost`*/ /*!50003 trigger stockdef_updatedt before insert on smddb.stockdef 
  for each row 
    if new.updatedt is null then 
      set new.updatedt = now(); 
    end if */;;
DELIMITER ;
-- Dump completed on 2013-03-10 18:33:55
