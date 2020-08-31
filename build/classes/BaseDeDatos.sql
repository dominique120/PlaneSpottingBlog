-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: aplicacionesempresarialesua3
-- ------------------------------------------------------
-- Server version	5.7.29-log

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
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog` (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(40) NOT NULL,
  `img` varchar(999) NOT NULL,
  `by` varchar(40) NOT NULL,
  `summary` varchar(5000) NOT NULL,
  `avion` varchar(16) NOT NULL,
  `date` varchar(10) NOT NULL,
  `tags` varchar(60) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'Thunderbirds en FLL','https://i.ytimg.com/vi/LkCocHrfPbc/maxresdefault.jpg','Por Dominique Verellen','Los famosos Thunderbirds de la USAF visito las playas de Ft. Lauderdale para impresionarnos con sus acrobacias aéreas! En este blog me gustaría conversar con ustedes sobre las mejores practicas para tomar fotos a aviones pequeños y rápidos y como debemos adaptarnos a eso.','f-16','2020-04-05','jets, thunderbirds, fll, florida, playa','Ft. Lauderdale, USA'),(2,'Visite Bielorrusia Otra Vez!','https://www.farehawker.com/img/image/Airline-flight/belavia-flight-image.jpg','Por Dominique Verellen','En este blog quiero contarles sobre mi viaje a Bielorrusia y compartirles mis fotos de los aviones que vi en el museo de la aviación que esta junto al Aeropuerto Internacional de Minsk. Pude ver aviones de la época Soviética que casi ni existen en esta parte del mundo.','737','2020-02-27','bielorrusia, union sovietica, 737,  ilushin','Minsk, Bielorrusia'),(3,'Helicópteros','https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/LAPD_Bell_206_Jetranger.jpg/1200px-LAPD_Bell_206_Jetranger.jpg','Por Dominique Verellen','A muchos de nosotros también nos interesan los helicópteros y no los descontamos del to. Aquí les muestro algunas fotos de helicópteros que he tomado recientemente y les cuento un poco sobre posibles lugares de donde los pueden encontrar.','heli','2019-12-12','helicoptero, policia, los angeles, playa','Los Angeles, USA'),(4,'Aviones Rusos','https://upload.wikimedia.org/wikipedia/commons/f/f1/Aeroflot_Il-96-300_RA-96008_SVO_2011-3-10.png','Por Dominique Verellen','Algo que casi nunca se ve aquí en esta parte del mundo son aviones Rusos o Soviéticos. En este blog quiero contarles sobre aviones de Rusia. También mostrarles fotos de mi primer viaje a Bielorrusia en el que pude ver estos aviones en persona.','il96','2019-09-08','il96, minsk, union sovietica, viejo, clasico','Minsk, Bielorrusia'),(5,'Spotting en Miami!','https://cdn.jetphotos.com/full/6/99891_1579390733.jpg','Por Dominique Verellen','Hola lectores! Hoy les traigo una fantástica colección de fotos de aviones en el Aeropuerto Internacional de Miami. Esta colección viene de uno de nuestros colaboradores basado ahi en Miami. Tuvo la oportunidad de ver el nuevo livery de LATAM en su A350 y se ve fenomenal.','a350','2019-06-17','miami, nuevo, airbus, a350, latam, moderno','Miami, USA'),(6,'Avion Presidencial','https://i.pinimg.com/originals/e2/24/2d/e2242d5a7f279abc13a07fb49c593f84.jpg','Por Dominique Verellen','Alguna vez han visto el famoso VC-25A del presidente de Estados Unidos? Pues resulta que el presidente Peruano tiene su propio mini Air Force One. El 737-500 Operado por la FAP fue comprado ya hace muchos años pero sigue volando a nuestro presidente a cualquier parte del mundo.','737','2019-05-15','presidentes, vip, 737, clasico, peruano','Lima, Peru'),(7,'Equipo Fotografico','https://image.jimcdn.com/app/cms/image/transf/dimension=412x1024:format=jpg/path/s47258f95518952d1/image/ia125503241654380/version/1483801701/image.jpg','Por Dominique Verellen','En este blog quiero hablar un poco sobre los diferentes lentes que usamos y tambien las camaras. Por lo general usamos equipos profesionales pero tambien hicimos una demostracion que se puede hacer incluso desde un celular.','heli','2019-02-17','camaras, lentes, canon, nikon, iphone, fotos','Buenos Aires, Argentina'),(8,'Spotting en una Isla Privada','https://i1.wp.com/thepointsguy.com/wp-content/uploads/2019/07/IMG_4412.jpg','Por Dominique Verellen','Imaginate tener una isla privada... Imaginate poder tirarte en la arena y ver aviones todo el dia... Pues eso es lo que puedes hacer en la isla privada del Marriot en el caribe. Tuvimos la oportunidad de ir y aqui te contamos sobre la experencia!','a320','2019-01-02','playa, mar, arenaa, privado, marriot, hotel','Caribe, Oceano Atlantico'),(9,'Spotters Day en  Zaventem!','https://www.aviation24.be/wp-content/uploads/2018/07/2017-07-24-BRU-Spotters-DAY-2018-44.jpg','Por Dominique Verellen','Hace unas semanas atendimos el spotters day en el aereopuerto de Bruselas, un evento organizado por el mismo aereopuerto en el que uno puede entrar como parte de un grupo guiado el cual puede toar fotos de los aviones de cerca. Fue una experiencia increíble!','777','2018-08-22','emirates, 777, zaventem, brusselas, belgica','Brusselas, Belgica');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `user` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`user`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin@mail.com','123456');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-20 19:08:09
