-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 18, 2021 at 04:28 PM
-- Server version: 5.7.19
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asiakas`
--

-- --------------------------------------------------------

--
-- Table structure for table `asiakas`
--

DROP TABLE IF EXISTS `asiakas`;
CREATE TABLE IF NOT EXISTS `asiakas` (
  `AVAIN` int(11) NOT NULL AUTO_INCREMENT,
  `NIMI` varchar(50) CHARACTER SET latin1 NOT NULL,
  `OSOITE` varchar(50) CHARACTER SET latin1 NOT NULL,
  `POSTINRO` varchar(5) CHARACTER SET latin1 NOT NULL,
  `POSTITMP` varchar(50) CHARACTER SET latin1 NOT NULL,
  `LUONTIPVM` date NOT NULL,
  `ASTY_AVAIN` int(11) NOT NULL,
  `Tunnus` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  `Salasana` varchar(45) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`AVAIN`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Dumping data for table `asiakas`
--

INSERT INTO `asiakas` (`AVAIN`, `NIMI`, `OSOITE`, `POSTINRO`, `POSTITMP`, `LUONTIPVM`, `ASTY_AVAIN`, `Tunnus`, `Salasana`) VALUES
(1, 'KALLE TAPPINEN', 'OPISTOTIE 2', '70100', 'KUOPIO', '2011-12-01', 1, 'Tunnus', 'Salasana'),
(2, 'VILLE VALLATON', 'MICROKATU 2', '70100', 'KUOPIO', '2011-12-03', 2, 'Tunnus', 'Salasana'),
(3, 'Kalle Östilä', 'Teku', '70100', 'Kuopio', '2018-09-22', 1, 'Tunnus', 'Salasana'),
(4, 'Keke Amstrong', 'Viasat', '00010', 'Tsadi', '2018-09-22', 2, 'xx', 'ss'),
(7, 'Pasi Rautiainen', 'Viaplay', '89100', 'Rovaniemi', '2018-09-22', 1, 'Tunnus', 'Salasana'),
(8, 'mauri', 'Toivalantie 25', '7100', 'Siili', '2018-09-22', 2, 'Tunnus', 'Salasana'),
(11, 'Ã„mmÃ¤lÃ¤ Ã„ijÃ¤', 'Kotipolku 8', '71820', 'JOssain', '2018-09-25', 2, 'Tunnus', 'Salasana'),
(12, 'Ã„mmÃ¤lÃ¤ Ã„ijÃ¤', 'Kotipolku 8', '71820', 'JOssain', '2018-09-25', 2, 'Tunnus', 'Salasana'),
(13, 'Ämmälä', 'Kotipolku 8', '71820', 'JOssain', '2018-09-25', 2, 'Tunnus', 'Salasana');

-- --------------------------------------------------------

--
-- Table structure for table `asiakastyyppi`
--

DROP TABLE IF EXISTS `asiakastyyppi`;
CREATE TABLE IF NOT EXISTS `asiakastyyppi` (
  `AVAIN` int(11) NOT NULL AUTO_INCREMENT,
  `LYHENNE` varchar(10) NOT NULL,
  `SELITE` varchar(50) NOT NULL,
  PRIMARY KEY (`AVAIN`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asiakastyyppi`
--

INSERT INTO `asiakastyyppi` (`AVAIN`, `LYHENNE`, `SELITE`) VALUES
(1, 'YA', 'YRITYSASIAKAS'),
(2, 'KA', 'KULUTTAJA ASIAKAS');

-- --------------------------------------------------------

--
-- Table structure for table `tuote`
--

DROP TABLE IF EXISTS `tuote`;
CREATE TABLE IF NOT EXISTS `tuote` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `nimi` varchar(50) CHARACTER SET latin1 NOT NULL,
  `selite` varchar(50) CHARACTER SET latin1 NOT NULL,
  `tyyppi_id` int(11) DEFAULT NULL,
  `ostopvm` varchar(50) CHARACTER SET latin1 NOT NULL,
  `valmistaja` varchar(50) CHARACTER SET latin1 NOT NULL,
  `hinta` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Dumping data for table `tuote`
--

INSERT INTO `tuote` (`ID`, `nimi`, `selite`, `tyyppi_id`, `ostopvm`, `valmistaja`, `hinta`) VALUES
(14, 'Kala', 'Kala', 1, '26.7.2020', 'Apetit', 5),
(15, 'Lehmä', 'Liha', 2, '26.7.2020', 'HK', 10),
(16, 'Pipo', 'Vaate', 3, '26.7.2020', 'BilleBeino', 20);

-- --------------------------------------------------------

--
-- Table structure for table `tuotetyypit`
--

DROP TABLE IF EXISTS `tuotetyypit`;
CREATE TABLE IF NOT EXISTS `tuotetyypit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NIMI` varchar(50) CHARACTER SET latin1 NOT NULL,
  `KOODI` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

--
-- Dumping data for table `tuotetyypit`
--

INSERT INTO `tuotetyypit` (`ID`, `NIMI`, `KOODI`) VALUES
(14, 'Kala', 1),
(15, 'Liha', 2),
(16, 'Vaate', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
