-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: gastos_grupo2
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gastos` (
  `IdGasto` int NOT NULL AUTO_INCREMENT,
  `FechaGasto` date NOT NULL,
  `IdDocumento` int DEFAULT NULL,
  `NumeroDocumento` varchar(11) NOT NULL,
  `Concepto` int DEFAULT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `FechaModificacion` date DEFAULT NULL,
  `UsuarioCreacion` int DEFAULT NULL,
  `UsuarioModificacion` int DEFAULT NULL,
  `IdProveedor` int NOT NULL,
  `Moneda` int DEFAULT NULL,
  `Importe` decimal(10,2) NOT NULL,
  `IdEliminado` int DEFAULT '0',
  PRIMARY KEY (`IdGasto`),
  KEY `IdProveedor` (`IdProveedor`),
  KEY `Moneda` (`Moneda`),
  KEY `Concepto` (`Concepto`),
  KEY `UsuarioCreacion` (`UsuarioCreacion`),
  KEY `IdDocumento` (`IdDocumento`),
  CONSTRAINT `gastos_ibfk_1` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedores` (`IdProveedor`),
  CONSTRAINT `gastos_ibfk_2` FOREIGN KEY (`Moneda`) REFERENCES `moneda` (`IdMoneda`),
  CONSTRAINT `gastos_ibfk_3` FOREIGN KEY (`Concepto`) REFERENCES `conceptogasto` (`IdConceptoGasto`),
  CONSTRAINT `gastos_ibfk_4` FOREIGN KEY (`UsuarioCreacion`) REFERENCES `usuario` (`IdUsuario`),
  CONSTRAINT `gastos_ibfk_5` FOREIGN KEY (`IdDocumento`) REFERENCES `tipodocumento` (`IdDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
INSERT INTO `gastos` VALUES (1,'2024-09-01',1,'86789564732',NULL,'2024-10-02',NULL,NULL,NULL,3,2,200.00,0),(2,'2024-09-01',1,'86789564732',NULL,'2024-10-02',NULL,NULL,NULL,3,2,200.00,0),(3,'2024-10-02',1,'10987645321',NULL,'2024-10-02',NULL,NULL,NULL,4,2,2000.00,0);
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-04 20:17:27
