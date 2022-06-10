-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: meandbooks
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `MEM_NO` mediumint NOT NULL AUTO_INCREMENT,
  `MEM_UID` varchar(15) NOT NULL,
  `MEM_PWD` varchar(20) NOT NULL,
  `MEM_NM` varchar(15) NOT NULL,
  `MEM_PHONENO` varchar(11) NOT NULL,
  `MEM_ADDR1` varchar(300) NOT NULL,
  `MEM_ADDR2` varchar(300) NOT NULL,
  `MEM_ADDR3` varchar(300) NOT NULL,
  `MEM_EMAIL` varchar(50) NOT NULL,
  `MEM_MILEAGE` mediumint DEFAULT '0',
  `IS_ADMIN` char(1) DEFAULT '0',
  `ACCESSIBLE` char(1) DEFAULT '1',
  PRIMARY KEY (`MEM_NO`),
  UNIQUE KEY `MEM_UID` (`MEM_UID`),
  UNIQUE KEY `MEM_EMAIL` (`MEM_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'test','123','테스트','01012341234','13536','경기 성남시 분당구 판교역로2번길 1','테스트입니다','caa@c.com',0,'1','1'),(4,'normalmember','1234','보통회원','01012341234','aaa','1234','1234','caaa@c.com',0,'0','1'),(6,'abc','123','테스트','0200000000','1','11','11','caaa@c.comaa',0,'0','0'),(7,'banneduser','123','강퇴테스트','01078961234','ㅁㅁ','ㅁㅁ','ㅁㅁ','sac.com',0,'0','0'),(8,'','','','','','','','',0,'0','0'),(11,'withdrawtest','123','withdrawtest','123456789','13536','경기 성남시 분당구 판교역로 4','aa','withdrawtest@aa.com',0,'0','0');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-10 17:33:51
