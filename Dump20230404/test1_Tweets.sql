-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: test1.caspko9hc50w.us-east-1.rds.amazonaws.com    Database: test1
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
-- SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
-- SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

-- SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `Tweets`
--
USE `test1`;
DROP TABLE IF EXISTS `Tweets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tweets` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `Title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Cotent` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `AuthorId` bigint DEFAULT NULL,
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `Likes` int DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23226 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tweets`
--

LOCK TABLES `Tweets` WRITE;
/*!40000 ALTER TABLE `Tweets` DISABLE KEYS */;
INSERT INTO `Tweets` VALUES (22,'test22','test content22',22,'2022-08-14 00:00:41',0),(23,'test23','test content23',23,'2022-08-14 00:00:41',0),(24,'test24','test content24',24,'2022-08-14 00:00:41',0),(25,'test25','test content25',25,'2022-08-14 00:00:41',13),(26,'test26','test content26',26,'2022-08-14 00:00:41',33),(27,'test27','test content27',27,'2022-08-14 00:00:41',43),(28,'test28','test content28',28,'2022-08-14 00:00:41',142),(29,'test29','test content29',29,'2022-08-14 00:00:41',42),(31,'test31','test content31',31,'2022-08-14 00:00:41',0),(32,'test32','test content32',32,'2022-08-14 00:00:41',0),(33,'test33','test content33',33,'2022-08-14 00:00:41',0),(34,'test34','test content34',34,'2022-08-14 00:00:41',0),(35,'test35','test content35',35,'2022-08-14 00:00:41',0),(36,'test36','test content36',36,'2022-08-14 00:00:41',0),(37,'test37','test content37',37,'2022-08-14 00:00:41',0),(38,'test38','test content38',38,'2022-08-14 00:00:41',0),(39,'test39','test content39',39,'2022-08-14 00:00:41',0),(101,'test101','test content 101',101,'2022-09-08 18:47:29',0),(123,'test40','tc1',39,'2022-10-12 17:36:13',0),(124,'test41','tc1',39,'2022-10-12 17:36:44',0),(125,'test42','tc1',39,'2022-10-12 17:36:55',1),(126,'test43','tc2',39,'2022-10-12 17:37:05',12),(127,'test44','tc2',39,'2022-10-12 17:37:23',3),(128,'test422','tc2',39,'2022-10-12 17:37:35',4),(129,'test422','tc2',39,'2022-10-12 17:37:42',5),(23222,'testTitleupdated','testContent',433,NULL,0),(23223,'testCreateTweet','testCreateTweet',NULL,'2023-04-04 20:29:45',0),(23224,'testusernameweb123','testusernameweb123',298682750288924700,'2023-04-04 21:58:49',0);
/*!40000 ALTER TABLE `Tweets` ENABLE KEYS */;
UNLOCK TABLES;
-- SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-04 22:13:08
