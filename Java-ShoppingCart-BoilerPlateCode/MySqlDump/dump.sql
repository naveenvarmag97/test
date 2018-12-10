-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: retail
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ShoppingCartID` int(11) NOT NULL,
  `DeliveryType` varchar(2) DEFAULT NULL,
  `OrderDate` date NOT NULL,
  `TotalPrice` double DEFAULT NULL,
  `Products_Purchased` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ord_ShoppingCartID` (`ShoppingCartID`),
  CONSTRAINT `fk_ord_ShoppingCartID` FOREIGN KEY (`ShoppingCartID`) REFERENCES `shopping_cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,19,NULL,'2018-06-08',83.99,2),(2,20,NULL,'2018-06-11',83.99,2),(3,21,NULL,'2018-06-11',83.99,2),(4,22,NULL,'2018-06-11',83.99,2),(5,23,NULL,'2018-06-11',83.99,2),(6,24,NULL,'2018-06-11',83.99,2),(7,25,NULL,'2018-06-11',83.99,2),(8,26,NULL,'2018-06-12',83.99,2),(9,27,NULL,'2018-06-12',83.99,2),(10,28,NULL,'2018-06-12',83.99,2),(11,29,NULL,'2018-06-12',39.99,1),(12,30,NULL,'2018-06-12',83.99,2),(13,31,NULL,'2018-06-12',49.989999999999995,1),(14,32,NULL,'2018-06-12',49.989999999999995,1),(15,33,NULL,'2018-06-13',49.989999999999995,1),(16,35,NULL,'2018-07-12',84,3),(17,34,NULL,'2018-07-12',84,3),(18,36,NULL,'2018-07-12',84,3),(19,37,NULL,'2018-07-12',150,1),(20,38,NULL,'2018-07-12',150,1),(21,39,NULL,'2018-07-17',49.989999999999995,1),(22,40,NULL,'2018-07-17',49.989999999999995,1),(23,41,NULL,'2018-07-17',49.989999999999995,1),(24,42,NULL,'2018-07-17',39.99,1),(25,43,NULL,'2018-07-17',30,1),(26,44,NULL,'2018-07-17',30,1),(27,45,NULL,'2018-07-17',84.99,3),(28,46,NULL,'2018-07-17',49.989999999999995,1),(29,47,'D','2018-07-17',49.989999999999995,1),(30,48,'D','2018-07-17',49.989999999999995,1),(31,49,'P','2018-07-17',34,1),(32,50,'P','2018-07-18',30,1),(33,51,'S','2018-07-18',143.99,3),(34,52,'P','2018-07-18',50,2),(35,53,'E','2018-07-18',39.99,1),(36,54,'P','2018-07-18',29,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `description` varchar(30) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'a1','Vim','test description',100,30),(2,'a2','Harpic','Toilet clener',60,34),(3,'a3','Comfort','comfort description',20,29),(4,'a4','Odonil','Odonil loasdd asdjkj asfjk ',12,20);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `refernceno` varchar(40) NOT NULL,
  `userid` int(11) NOT NULL,
  `Active` tinyint(1) DEFAULT NULL,
  `Expiry` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_refernceno` (`refernceno`),
  KEY `fk_UserID` (`userid`),
  CONSTRAINT `fk_UserID` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (1,'c4d8dbe8-5110-4121-ab33-f65553a8da8c',1,1,'2018-06-08'),(2,'be4fea4b-5f95-48f4-825a-20a587e8fd3f',1,1,'2018-06-08'),(3,'cdb3cf51-2a2e-45ce-980b-f476938195dc',1,1,'2018-06-08'),(9,'52c170be-a901-4969-834e-62973fdbc87a',1,1,'2018-06-08'),(10,'0c133b01-330b-4fdb-8835-c7fb70adca8e',1,1,'2018-06-08'),(11,'a724cc08-5cc4-423c-a02d-025bfce4b569',1,1,'2018-06-08'),(12,'c2b5f48b-e6cb-4ab6-81ce-59447ca4c395',1,1,'2018-06-08'),(13,'598293ed-4e04-4869-8d1b-e4151fddb9e1',1,1,'2018-06-08'),(19,'32235076-1319-47e8-931f-16b75bc3f74e',1,1,'2018-06-08'),(20,'f43d7876-801d-4654-beef-7101e5374019',1,1,'2018-06-11'),(21,'11d5ca55-a8e7-433d-9e63-5829c5b8352a',1,1,'2018-06-11'),(22,'c9143664-8164-4b08-908f-50618c0b2267',1,1,'2018-06-11'),(23,'ce1a15c1-c126-46ac-9ed0-2a86adb7e617',1,1,'2018-06-11'),(24,'02fd0b14-f5d6-44b1-b1fd-b10349871ccf',1,1,'2018-06-11'),(25,'e034f0b8-dc93-4627-b828-039433acd1e1',1,1,'2018-06-11'),(26,'572baa4c-9cbb-44ac-a405-3c587027e794',1,1,'2018-06-12'),(27,'17e570d9-d92d-4e4c-a4d3-52a7e11092c8',1,1,'2018-06-12'),(28,'5581ba5e-49e9-429f-b026-e50aa73083e6',1,1,'2018-06-12'),(29,'e2fad830-bb8d-408b-a3aa-2e6e1d4149b9',1,1,'2018-06-12'),(30,'73f8480f-f468-433d-84ba-402c5b13b57a',1,1,'2018-06-12'),(31,'972687bf-2051-456d-8163-057d5f35bfc2',1,1,'2018-06-12'),(32,'9d78cba9-d6b7-467b-8747-b98b083af91e',1,1,'2018-06-12'),(33,'e5e2f8e0-59ed-49bd-838c-0018cdfc2aa5',1,1,'2018-06-13'),(34,'655969fc-a90d-43cc-ae98-ff416ddfbd7e',1,1,'2018-07-12'),(35,'b0b85d29-a01b-48d3-ba2a-775e774524d4',1,1,'2018-07-12'),(36,'f9a099c4-b5a5-450d-9439-0104bdc758d8',1,1,'2018-07-12'),(37,'afa78f97-8905-436d-81c8-f79a372e0648',1,1,'2018-07-12'),(38,'49193a66-8ecd-49ec-b143-7bb4a8ab2a7a',1,1,'2018-07-12'),(39,'8c179643-1f13-4d81-8c52-3b839ea772ac',1,1,'2018-07-17'),(40,'a3a73950-63b0-43ff-9729-a64864e3e617',1,1,'2018-07-17'),(41,'0e75d4f3-794d-446e-9b67-c2dfdcae17fd',1,1,'2018-07-17'),(42,'bc38fc64-ff52-4999-9719-9a3dd04de995',1,1,'2018-07-17'),(43,'7371bdf4-8ac8-4fa8-a6d5-b524e33145f2',1,1,'2018-07-17'),(44,'ee3466f2-47a4-4b70-a73a-e146f5d701f8',1,1,'2018-07-17'),(45,'3589e9b4-9735-4425-93b0-df7544c3b480',1,1,'2018-07-17'),(46,'eefab6d5-e84a-41f0-8a07-faaf20844760',1,1,'2018-07-17'),(47,'f49a3e8a-9ed5-4ffc-88e5-741901d7950f',1,1,'2018-07-17'),(48,'92b7451b-9b5e-4724-bb9a-215614e7b8ac',1,1,'2018-07-17'),(49,'d71bc40c-ed81-4196-8523-0ab95b61e254',1,1,'2018-07-17'),(50,'70a60c24-58c6-4ec3-9779-9a1edf1e0b5c',1,1,'2018-07-18'),(51,'471dc78c-15f0-4ec9-9fd7-b2ba97f2673e',1,1,'2018-07-18'),(52,'c6220d25-0792-485a-b846-52445f023041',1,1,'2018-07-18'),(53,'6bbf4653-bb63-4c8b-8b87-b700a116526d',1,1,'2018-07-18'),(54,'8a89391e-0958-4daf-be3b-7cd086a15d68',1,1,'2018-07-18');
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart_details`
--

DROP TABLE IF EXISTS `shopping_cart_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shopping_cart_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ShoppingCartID` int(11) NOT NULL,
  `productid` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ShoppingCartID` (`ShoppingCartID`),
  KEY `fk_InventoryID` (`productid`),
  CONSTRAINT `fk_InventoryID` FOREIGN KEY (`productid`) REFERENCES `products` (`id`),
  CONSTRAINT `fk_ShoppingCartID` FOREIGN KEY (`ShoppingCartID`) REFERENCES `shopping_cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart_details`
--

LOCK TABLES `shopping_cart_details` WRITE;
/*!40000 ALTER TABLE `shopping_cart_details` DISABLE KEYS */;
INSERT INTO `shopping_cart_details` VALUES (1,9,1,0,1),(2,9,2,0,1),(3,10,1,0,1),(4,10,2,0,1),(5,11,1,0,1),(6,11,2,0,1),(7,12,2,0,1),(8,12,1,0,1),(9,13,1,0,1),(10,13,2,0,1),(21,19,2,0,1),(22,19,1,0,1),(23,20,1,0,1),(24,20,2,0,1),(25,21,2,0,1),(26,21,1,0,1),(27,22,2,0,1),(28,22,1,0,1),(29,23,1,0,1),(30,23,2,0,1),(31,24,2,0,1),(32,24,1,0,1),(33,25,1,0,1),(34,25,2,0,1),(35,26,1,0,1),(36,26,2,0,1),(37,27,1,0,1),(38,27,2,0,1),(39,28,2,0,1),(40,28,1,0,1),(41,29,1,0,1),(42,30,1,0,1),(43,30,2,0,1),(44,31,1,0,1),(45,32,1,0,1),(46,33,1,0,1),(47,35,1,0,1),(48,34,1,0,1),(49,35,2,0,1),(50,35,4,0,1),(51,34,4,0,1),(52,34,2,0,1),(53,36,4,0,1),(54,36,2,0,1),(55,36,1,0,1),(56,37,1,0,5),(57,38,1,0,5),(58,39,1,0,1),(59,40,1,0,1),(60,41,1,0,1),(61,42,1,0,1),(62,43,1,0,1),(63,44,1,0,1),(64,45,1,0,1),(65,45,4,0,1),(66,45,3,0,1),(67,46,1,0,1),(68,47,1,0,1),(69,48,1,0,1),(70,49,2,0,1),(71,50,1,0,1),(72,51,4,0,2),(73,51,2,0,2),(74,51,1,0,1),(75,52,4,0,1),(76,52,1,0,1),(77,53,1,0,1),(78,54,3,0,1);
/*!40000 ALTER TABLE `shopping_cart_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginid` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Usertype` char(1) NOT NULL DEFAULT 'U',
  `Address` varchar(50) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `Zip` int(11) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `Email_Address` varchar(50) DEFAULT NULL,
  `Phone_Number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_loginid` (`loginid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'User1@g.com','password','Jack','1','U','no 1 first street ch 100','ch',10,'tn','user1@s.com',23676723);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-30 12:26:47
