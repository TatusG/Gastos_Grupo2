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
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `IdProveedor` int NOT NULL AUTO_INCREMENT,
  `RUC` varchar(11) NOT NULL,
  `RazonSocial` varchar(100) DEFAULT NULL,
  `Direccion` varchar(255) DEFAULT NULL,
  `IdDepartamento` int DEFAULT NULL,
  `IdProvincia` int DEFAULT NULL,
  `IdDistrito` int DEFAULT NULL,
  `Telefono` varchar(8) DEFAULT NULL,
  `Celular` varchar(9) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `IdEstado` int DEFAULT NULL,
  `FechaCreacion` date DEFAULT NULL,
  `FechaModificacion` date DEFAULT NULL,
  `UsuarioCreacion` int NOT NULL,
  `UsuarioModificacion` int DEFAULT NULL,
  `IdEliminado` int DEFAULT '0',
  PRIMARY KEY (`IdProveedor`),
  UNIQUE KEY `RUC` (`RUC`),
  UNIQUE KEY `RazonSocial` (`RazonSocial`),
  KEY `IdDepartamento` (`IdDepartamento`),
  KEY `IdProvincia` (`IdProvincia`),
  KEY `IdDistrito` (`IdDistrito`),
  KEY `UsuarioCreacion` (`UsuarioCreacion`),
  KEY `IdEstado` (`IdEstado`),
  CONSTRAINT `proveedores_ibfk_1` FOREIGN KEY (`IdDepartamento`) REFERENCES `departamentos` (`IdDepartamento`),
  CONSTRAINT `proveedores_ibfk_2` FOREIGN KEY (`IdProvincia`) REFERENCES `provincias` (`IdProvincia`),
  CONSTRAINT `proveedores_ibfk_3` FOREIGN KEY (`IdDistrito`) REFERENCES `distritos` (`IdDistrito`),
  CONSTRAINT `proveedores_ibfk_4` FOREIGN KEY (`UsuarioCreacion`) REFERENCES `usuario` (`IdUsuario`),
  CONSTRAINT `proveedores_ibfk_5` FOREIGN KEY (`IdEstado`) REFERENCES `estado` (`IdEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (3,'10293738388','Compupalace','Av. La Marina 475',15,1501,150136,'-5674531','975479864','compupalace@gmail.com',1,'2024-09-22',NULL,1,NULL,1),(4,'10987645321','Pantallas Led','Av. Los Cipreces 234',15,1501,150105,'2786543','967543821','led@gmail.com',1,'2024-09-23',NULL,1,NULL,0),(5,'10983546237','Campos Rosa','Cal. Las Margaritas 3678',7,701,70105,'2897654','978564321','rosa@gmail.com',1,'2024-09-23',NULL,1,NULL,1),(6,'10987634521','Servicios Generales','Av. Los Pinos 456',5,504,50404,'23674598','956498732','servicio@serviciosgenerales.com.pe',1,'2024-09-29','2024-09-29',1,1,0),(7,'19765843621','Construcciones Lopez','Cl. Parque Industrial 345',7,701,70104,'2987645','974653827','lopez@gmail.com',1,'2024-09-29',NULL,1,NULL,0),(8,'10297645273','International Prisma','Av. Peru 347',6,603,60303,'4018764','956386545','facturacion@prisma.com.pe',1,'2024-09-29',NULL,1,NULL,0),(9,'10985634527','Corporacion Talma','Av. Javier Prado 89',15,1501,150131,'4876532','967453721','talma@gmail.com',1,'2024-10-01',NULL,1,NULL,0),(10,'17659482381','Canon S.A.C','Av. Ejercito 786',15,1504,150404,'4876532','967453218','canon@gmail.com',1,'2024-10-01','2024-10-02',1,2,0),(11,'12345678921','Servicios','safadg',7,701,70102,'96745292','97564212','hhj|',1,'2024-10-02',NULL,2,NULL,0);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
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
