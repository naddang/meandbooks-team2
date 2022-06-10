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
-- Table structure for table `qna_q`
--

DROP TABLE IF EXISTS `qna_q`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qna_q` (
  `Q_NO` mediumint NOT NULL AUTO_INCREMENT,
  `MEM_NO` mediumint NOT NULL,
  `Q_TITLE` varchar(100) NOT NULL,
  `Q_CONTENT` varchar(3000) NOT NULL,
  `Q_DATE` datetime NOT NULL,
  `Q_PWD` varchar(20) NOT NULL,
  `Q_CATE` char(1) NOT NULL,
  `ACCESS_LEVEL` char(1) NOT NULL,
  PRIMARY KEY (`Q_NO`),
  KEY `FK_MEMBER_TO_QNA_Q_1` (`MEM_NO`),
  CONSTRAINT `FK_MEMBER_TO_QNA_Q_1` FOREIGN KEY (`MEM_NO`) REFERENCES `member` (`MEM_NO`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qna_q`
--

LOCK TABLES `qna_q` WRITE;
/*!40000 ALTER TABLE `qna_q` DISABLE KEYS */;
INSERT INTO `qna_q` VALUES (1,1,'aa','aaaaa','2022-06-09 14:15:50','0','1','1'),(2,4,'ff','ff','2022-06-07 16:32:37','0','1','1');
/*!40000 ALTER TABLE `qna_q` ENABLE KEYS */;
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
