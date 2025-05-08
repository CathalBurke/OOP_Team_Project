CREATE DATABASE  IF NOT EXISTS `ecommerce_business` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ecommerce_business`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: ecommerce_business
-- ------------------------------------------------------
-- Server version	8.0.42-0ubuntu0.24.04.1

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `Cart_id` int NOT NULL AUTO_INCREMENT,
  `UserID` int DEFAULT NULL,
  `Product_id` int DEFAULT NULL,
  `Product_quantity` int DEFAULT '1',
  PRIMARY KEY (`Cart_id`),
  KEY `UserID` (`UserID`),
  KEY `Product_id` (`Product_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `login` (`UserID`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`Product_id`) REFERENCES `products` (`Product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1,4,11),(2,2,3,1),(3,3,8,3),(4,4,7,5),(5,5,6,15),(6,1,10,1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `Category_id` int NOT NULL,
  `Category_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Clothes'),(2,'Electronics'),(3,'foods');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `UserID` int NOT NULL,
  `First_name` varchar(45) DEFAULT NULL,
  `Last_name` varchar(45) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'John','Alonso','johnalons@gmail.com','johnaso','John123'),(2,'Paco','Perez','pacoperez1@gmail.com','pacope','pacope43'),(3,'Ramon','Gustavo','ramong456@gmail.com','gustavram','gusram122'),(4,'Marta','Prieto','martaprieto1@gmail.com','martap4','marta7568'),(5,'Ernesto','Perez','ernep1@gmail.com','perezerne2','ernesto68');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `Order_details_id` int NOT NULL,
  `Product_id` int DEFAULT NULL,
  `Product_quantity` int DEFAULT '1',
  `Price_per_item` decimal(10,2) DEFAULT NULL,
  `Orders` int DEFAULT NULL,
  PRIMARY KEY (`Order_details_id`),
  KEY `Product_id` (`Product_id`),
  KEY `Orders` (`Orders`),
  CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`Product_id`) REFERENCES `products` (`Product_id`),
  CONSTRAINT `order_details_ibfk_3` FOREIGN KEY (`Orders`) REFERENCES `orders` (`Orders`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (1,4,10,2.50,1),(2,3,1,20.00,2),(3,8,3,4.25,3),(4,7,5,1.00,4),(5,6,15,4.75,5);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `Orders` int NOT NULL,
  `UserID` int DEFAULT NULL,
  `Total_amount` decimal(10,2) DEFAULT NULL,
  `Order_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Orders`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `login` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,10.00,'2024-09-15 09:30:00'),(2,2,1.00,'2024-10-17 07:30:00'),(3,3,3.00,'2024-10-21 10:15:00'),(4,4,5.00,'2024-10-26 08:20:00'),(5,5,15.00,'2024-11-03 15:30:00');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `Product_id` int NOT NULL AUTO_INCREMENT,
  `Product_name` varchar(100) DEFAULT NULL,
  `Product_description` text,
  `Product_price` decimal(8,2) DEFAULT NULL,
  `Product_quantity` int DEFAULT '1',
  `Category_id` int DEFAULT NULL,
  PRIMARY KEY (`Product_id`),
  KEY `Category_id` (`Category_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`Category_id`) REFERENCES `category` (`Category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Black T-shirt','a black t-shirt',10.00,30,1),(2,'Pants','short pants',7.00,30,1),(3,'Shoes','normal shoes',20.00,20,1),(4,'Leds','red leds',2.50,100,2),(6,'Capacitors','0.1uF capacitors',4.75,75,2),(7,'Apples','red apples',1.00,60,3),(8,'Chicken','fried chicken',4.25,15,3),(9,'Bread','sourdough bread',2.25,35,3),(10,'Red pants','Very red pants !',24.00,1,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-08 13:08:18
