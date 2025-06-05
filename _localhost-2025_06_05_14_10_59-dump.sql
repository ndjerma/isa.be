-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: isa
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Tehnika'),(2,'Racunari');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_categories`
--

DROP TABLE IF EXISTS `product_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_categories_categories_id_fk` (`category_id`),
  KEY `product_categories_products_id_fk` (`product_id`),
  CONSTRAINT `product_categories_categories_id_fk` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `product_categories_products_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_categories`
--

LOCK TABLES `product_categories` WRITE;
/*!40000 ALTER TABLE `product_categories` DISABLE KEYS */;
INSERT INTO `product_categories` VALUES (1,1,1),(2,2,1),(3,1,2),(4,2,3),(5,1,3);
/*!40000 ALTER TABLE `product_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `products_users_id_fk` (`user_id`),
  CONSTRAINT `products_users_id_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Laptop',1),(2,'Telefon',2),(3,'Tablet',1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `password` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Nikola','Djermanovic','nikola.djermanovic.21@singimail.rs','0604103999',''),(2,'Milijana','Mesterovic','milijana.mesterovic.21@singimail.rs','777666555',''),(3,'Nikola','Djermanovic','djermaaa@gmail.com','555555555',''),(4,'Djordje','Djermanovic','djole@gmail.com',NULL,''),(5,'Dusko','Djermanovic','djole@gmail.com','0602169888',''),(6,'Milovan','Djermanovic','djole@gmail.com','0645257352',''),(7,'Danijela','Djermanovic','nene@gmail.com','0648398745',''),(8,'Mihajlo','Djermanovic','miki@gmail.com',NULL,''),(9,'Milovan','Jovic','vanmilo@gmail.com',NULL,''),(10,'Radovan','Jovic','vanrado@gmail.com','0648398745',''),(11,'Pavlo','Pcelica','pajo@gmail.com',NULL,''),(12,'Janko','Jankovic','yan@gmail.com',NULL,''),(13,'Nikola','Djermanovicasdadsdasd','djermalearns@gmail.com','0604103999',''),(14,'Nikola','Djermanovic','djermalearns@gmail.com','0604103999',''),(15,'Slavisa','Mesterovic','slave@email.com','0647376458',''),(16,'Nikola','Djermanovic','djermalearns@gmail.com','34534545345',''),(17,'Mihajlo','Djermanovic','miki@gmail.com','0649895671',''),(18,'Dragan','Zisin','ziske@gmail.com','0648398745',''),(19,'Milivoje','Jovic','milivojemiki@gmail.com','0648398745',''),(20,'Dragan','Zisin','ziske@gmail.com','0648398745',''),(21,'Petar','Petrovic Njegos','gosnje@gmail.com','0648398745',''),(22,'Riven','IzLOLA','venri@gmail.com','0648398745',''),(23,'Darius','IzLOLA','riusda@gmail.com','0648398745',''),(24,'Mladen','Djermanovic','nikola.djermanovic.21@singimail.rs','0604103999',''),(25,'Mladen','Djermanovic','nikola.djermanovic.21@singimail.rs','0604103999',''),(26,'Mladen','Djermanovic','nikola.djermanovic.21@singimail.rs','0604103999',''),(27,'Djurdjica','Mesterovic','milijana.mesterovic.21@singimail.rs','0604103999',''),(28,'Mladen','Djermanovic','nikola.djermanovic.21@singimail.rs','0604103999',''),(29,'Drazen','Djermanovic','nikola.djermanovic.21@singimail.rs','0604103999',''),(30,'Milovan','Djermanovic','nikola.djermanovic.21@singimail.rs','0604103999',''),(31,'Radovan','Djermanovic','radovan.djermanovic.21@singimail.rs','0604103999','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-05 14:10:59
