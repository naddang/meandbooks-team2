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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `BOOK_NO` varchar(8) NOT NULL,
  `BOOK_NM` varchar(100) NOT NULL,
  `BOOK_DESC` varchar(3000) NOT NULL,
  `BOOK_PRICE` mediumint NOT NULL,
  `BOOK_STOCK` smallint NOT NULL,
  `BOOK_IMG` varchar(1000) DEFAULT NULL,
  `BOOK_PUB` varchar(60) NOT NULL,
  `BOOK_AUTHOR` varchar(60) NOT NULL,
  `BOOK_PUB_DATE` date NOT NULL,
  `BOOK_ISBN` varchar(20) DEFAULT NULL,
  `BOOK_PAGE` smallint DEFAULT NULL,
  PRIMARY KEY (`BOOK_NO`),
  UNIQUE KEY `BOOK_ISBN` (`BOOK_ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('1110001','aa','aa',100,11,'default-img.png','aa','aa','2022-06-07','123',100),('1110002','테스트3','fff',300,12,'default-img.png','한빛비즈','김헌','2022-06-30','123992',100),('1110003','asfsa','safsaf',100,11,'default-img.png','한빛비즈','김헌','2022-06-01','7523',100),('1110004','asfsa','safsaf',100,12,'default-img.png','한빛비즈','김헌','2022-06-01','7524',100),('1110005','asfsa','safsaf',100,11,'LifeBook (1).png','한빛비즈','김헌','2022-06-01','7525',100),('1110006','노이미지','aaa',100,123,'default-img.png','한빛비즈','도미닉 프리스비','2022-06-03','7831',100),('1120001','aa','aaaaa',100,11,'test.png','aa','aa','2022-06-07','123123',100),('123','aaa','aaa',100,3,'default-img.png','aaa','aaa','2022-05-27','aaa',11);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
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
