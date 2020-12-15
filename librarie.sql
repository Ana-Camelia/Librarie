-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2020 at 12:33 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarie`
--

-- --------------------------------------------------------

--
-- Table structure for table `achizitie`
--

CREATE TABLE `achizitie` (
  `nrf` int(11) NOT NULL,
  `CUI` int(10) NOT NULL DEFAULT 0,
  `idp` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `ora` time DEFAULT NULL,
  `cantitate` int(11) NOT NULL,
  `cost` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `achizitie`
--

INSERT INTO `achizitie` (`nrf`, `CUI`, `idp`, `data`, `ora`, `cantitate`, `cost`) VALUES
(1307241, 10, 18, '1979-02-23', '09:09:28', 5, 1577.24),
(1134788, 11, 18, '2007-11-11', '09:12:38', 7, 1820.02),
(7340213, 8, 6, '1972-12-10', '13:33:22', 3, 508.32),
(9467404, 7, 3, '2008-08-12', '00:03:06', 7, 1837.87),
(7691499, 4, 1, '2016-06-30', '03:42:37', 3, 1088.36),
(1064473, 13, 2, '1986-02-20', '02:37:34', 6, 1950.49),
(5374355, 3, 7, '1974-02-25', '21:06:59', 5, 1387.48),
(1981203, 11, 12, '1974-10-02', '09:28:35', 4, 1084.88),
(4943059, 11, 9, '1999-07-16', '14:25:34', 5, 365.52),
(8454256, 7, 20, '1995-06-14', '22:17:45', 9, 1729.45),
(4254039, 20, 6, '2013-04-11', '07:35:54', 6, 919.5),
(2998381, 2, 10, '2000-11-22', '03:31:40', 5, 1343.5),
(1623367, 9, 4, '2018-03-31', '12:48:01', 8, 1290.08),
(3194929, 1, 19, '1986-06-23', '16:40:31', 5, 1203.81),
(9660891, 1, 9, '1999-01-07', '10:24:13', 1, 123.8),
(5341209, 4, 8, '2016-12-14', '19:39:55', 6, 844.24),
(3557335, 11, 8, '2000-12-29', '13:50:00', 4, 904.02),
(4035926, 8, 4, '1972-12-01', '17:16:47', 9, 1027.29),
(3272251, 10, 2, '2003-02-10', '12:26:47', 2, 1766.7),
(8266049, 19, 4, '2001-03-24', '15:39:05', 1, 1708.16),
(7921969, 10, 1, '2017-12-10', '23:28:01', 8, 1542.29),
(8604087, 11, 20, '2006-06-17', '15:12:11', 8, 1040.7),
(9935925, 13, 1, '1978-09-04', '00:29:39', 7, 123.37),
(2132385, 8, 19, '1985-10-21', '08:26:52', 3, 534.03),
(2863811, 1, 8, '2002-07-01', '13:22:12', 4, 1559.82),
(4993306, 5, 2, '1996-05-20', '01:11:05', 9, 909.3),
(7309095, 17, 19, '1986-05-04', '18:51:06', 9, 190.38),
(4024117, 6, 6, '2003-02-21', '14:10:40', 8, 1449.47),
(8983101, 3, 6, '1990-02-03', '17:53:49', 7, 841.86),
(2925304, 4, 3, '2013-10-20', '16:32:54', 4, 227.67),
(8131466, 10, 5, '1977-01-24', '07:39:36', 4, 1545.67),
(8948944, 8, 4, '2020-05-26', '10:13:42', 5, 570.1),
(7027150, 20, 6, '1994-07-13', '15:59:01', 3, 1658.15),
(1229801, 8, 9, '2011-06-26', '12:57:56', 9, 448.3),
(8816305, 7, 18, '1995-04-28', '22:32:57', 7, 473.18),
(7645111, 8, 19, '1971-07-08', '08:11:02', 6, 1365.2),
(3478981, 19, 16, '1991-10-05', '13:26:41', 8, 1911.62),
(3012188, 18, 20, '1986-09-20', '20:54:54', 8, 571.08),
(7295219, 3, 3, '1979-04-22', '08:45:24', 5, 305.72),
(3270868, 2, 20, '2005-08-06', '02:05:31', 6, 652.98),
(1021697, 1, 7, '1971-11-22', '20:36:01', 6, 1917.5),
(2351890, 5, 4, '1984-07-23', '09:59:33', 5, 1830.23),
(5120671, 13, 8, '2005-06-14', '16:47:29', 4, 1522.08),
(1620293, 6, 7, '1993-03-10', '06:21:29', 4, 840.35),
(1307241, 10, 18, '1979-02-23', '09:09:28', 5, 1577.24),
(1134788, 11, 18, '2007-11-11', '09:12:38', 7, 1820.02),
(7340213, 8, 6, '1972-12-10', '13:33:22', 3, 508.32),
(9467404, 7, 3, '2008-08-12', '00:03:06', 7, 1837.87),
(7691499, 4, 1, '2016-06-30', '03:42:37', 3, 1088.36),
(1064473, 13, 2, '1986-02-20', '02:37:34', 6, 1950.49),
(5374355, 3, 7, '1974-02-25', '21:06:59', 5, 1387.48),
(1981203, 11, 12, '1974-10-02', '09:28:35', 4, 1084.88),
(4943059, 11, 9, '1999-07-16', '14:25:34', 5, 365.52),
(8454256, 7, 20, '1995-06-14', '22:17:45', 9, 1729.45),
(4254039, 20, 6, '2013-04-11', '07:35:54', 6, 919.5),
(2998381, 2, 10, '2000-11-22', '03:31:40', 5, 1343.5),
(1623367, 9, 4, '2018-03-31', '12:48:01', 8, 1290.08),
(3194929, 1, 19, '1986-06-23', '16:40:31', 5, 1203.81),
(9660891, 1, 9, '1999-01-07', '10:24:13', 1, 123.8),
(5341209, 4, 8, '2016-12-14', '19:39:55', 6, 844.24),
(3557335, 11, 8, '2000-12-29', '13:50:00', 4, 904.02),
(4035926, 8, 4, '1972-12-01', '17:16:47', 9, 1027.29),
(3272251, 10, 2, '2003-02-10', '12:26:47', 2, 1766.7),
(8266049, 19, 4, '2001-03-24', '15:39:05', 1, 1708.16),
(7921969, 10, 1, '2017-12-10', '23:28:01', 8, 1542.29),
(8604087, 11, 20, '2006-06-17', '15:12:11', 8, 1040.7),
(9935925, 13, 1, '1978-09-04', '00:29:39', 7, 123.37),
(2132385, 8, 19, '1985-10-21', '08:26:52', 3, 534.03),
(2863811, 1, 8, '2002-07-01', '13:22:12', 4, 1559.82),
(4993306, 5, 2, '1996-05-20', '01:11:05', 9, 909.3),
(7309095, 17, 19, '1986-05-04', '18:51:06', 9, 190.38),
(4024117, 6, 6, '2003-02-21', '14:10:40', 8, 1449.47),
(8983101, 3, 6, '1990-02-03', '17:53:49', 7, 841.86),
(2925304, 4, 3, '2013-10-20', '16:32:54', 4, 227.67),
(8131466, 10, 5, '1977-01-24', '07:39:36', 4, 1545.67),
(8948944, 8, 4, '2020-05-26', '10:13:42', 5, 570.1),
(7027150, 20, 6, '1994-07-13', '15:59:01', 3, 1658.15),
(1229801, 8, 9, '2011-06-26', '12:57:56', 9, 448.3),
(8816305, 7, 18, '1995-04-28', '22:32:57', 7, 473.18),
(7645111, 8, 19, '1971-07-08', '08:11:02', 6, 1365.2),
(3478981, 19, 16, '1991-10-05', '13:26:41', 8, 1911.62),
(3012188, 18, 20, '1986-09-20', '20:54:54', 8, 571.08),
(7295219, 3, 3, '1979-04-22', '08:45:24', 5, 305.72),
(3270868, 2, 20, '2005-08-06', '02:05:31', 6, 652.98),
(1021697, 1, 7, '1971-11-22', '20:36:01', 6, 1917.5),
(2351890, 5, 4, '1984-07-23', '09:59:33', 5, 1830.23),
(5120671, 13, 8, '2005-06-14', '16:47:29', 4, 1522.08),
(1620293, 6, 7, '1993-03-10', '06:21:29', 4, 840.35),
(555, 1, 1, '2020-07-14', '21:08:42', 0, 0),
(454354, 1, 4, '2020-07-15', '18:10:50', 11, 130),
(747, 17, 6, '2020-10-03', '13:00:25', 15, 6000),
(747, 17, 6, '2020-10-03', '13:00:25', 15, 6000),
(43443, 1, 4, '2020-10-03', '14:29:35', 100, 2500),
(43443, 1, 4, '2020-10-03', '14:29:52', 100, 2500),
(434437, 1, 4, '2020-10-03', '14:32:57', 10, 500),
(434437, 5, 20, '2020-10-03', '14:33:27', 10, 500),
(7678, 24, 1, '0000-00-00', NULL, 0, NULL),
(1000, 24, 1, '2020-06-15', NULL, 0, NULL),
(1111111, 4, 1, '1979-02-23', '10:00:00', 10, 12.34),
(2222222, 7, 2, '2020-05-15', '10:00:00', 3, 100),
(3333333, 11, 1, '2020-03-15', '10:00:00', 5, 250),
(1111112, 4, 1, '1979-02-23', '10:00:00', 10, 12.34),
(2222223, 7, 2, '2020-05-15', '10:00:00', 3, 100),
(3333334, 11, 1, '2020-03-15', '10:00:00', 5, 250),
(1111112, 4, 1, '1979-02-23', '10:35:00', 10, 12.34),
(2222223, 7, 2, '2020-05-15', '10:20:00', 3, 100),
(3333334, 11, 1, '2020-03-15', '13:30:55', 5, 250);

-- --------------------------------------------------------

--
-- Table structure for table `angajat`
--

CREATE TABLE `angajat` (
  `ida` int(11) NOT NULL,
  `nume` varchar(20) DEFAULT '0',
  `prenume` varchar(30) DEFAULT '0',
  `cnp` char(13) DEFAULT NULL,
  `admin` char(2) NOT NULL,
  `Telefon` char(10) DEFAULT NULL,
  `parola` char(20) NOT NULL,
  `activ` char(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `angajat`
--

INSERT INTO `angajat` (`ida`, `nume`, `prenume`, `cnp`, `admin`, `Telefon`, `parola`, `activ`) VALUES
(1, 'BejanAna', 'Ana Camelia', '0357465149628', 'Da', '0751515151', 'bac12', 'Da'),
(2, 'Pouros', 'Stefanie', '6154185899810', 'Nu', NULL, 'lfn25', 'Da'),
(3, 'Macejkovic', 'Adelbert', '5716142479249', 'Nu', NULL, 'dxf34', 'Da'),
(4, 'Ondricka', 'Lexie', '7517439828933', 'Nu', NULL, 'kyt58', 'Da'),
(5, 'Pacocha', 'Esta', '8400331054409', 'Nu', NULL, 'kwl20', 'Da'),
(6, 'Bailey', 'Vada', '0583559520702', 'Nu', NULL, 'krv27', 'Da'),
(8, 'Boyer', 'Hyman', '6665680853231', 'Nu', NULL, 'loa35', 'Da'),
(9, 'Barrows', 'Tatum', '6793786803744', 'Nu', NULL, 'zhx99', 'Nu'),
(10, 'Hansen', 'Maynard', '7905485568322', 'Nu', NULL, 'cxu49', 'Da'),
(11, 'Homenick', 'Shanelle', '7866520347657', 'Nu', NULL, 'asb65', 'Da'),
(12, 'Brekke', 'Lionel', '4697362899645', 'Nu', NULL, 'phw24', 'Da'),
(13, 'Steuber', 'Lura', '6461304324181', 'Da', NULL, 'yah22', 'Nu'),
(14, 'Kling', 'Tate', '1020339844398', 'Nu', NULL, 'rli85', 'Da'),
(15, 'Koelpin', 'Archibald', '8305387511459', 'Nu', NULL, 'gio08', 'Da'),
(16, 'Moore', 'Darron', '7716800414523', 'Nu', NULL, 'gfw97', 'Da'),
(17, 'Feest', 'Roger', '8232312008816', 'Nu', NULL, 'kny24', 'Da'),
(18, 'Nitzsche', 'Candace', '4707460467689', 'Nu', NULL, 'poa48', 'Da'),
(19, 'Nitzsche', 'Isabell', '4749894035368', 'Nu', NULL, 'krx77', 'Da'),
(20, 'Hoppe', 'Osbaldo', '8387326677796', 'Nu', NULL, 'len73', 'Da'),
(21, 'Ana', 'Camelia', '1234567890123', 'Nu', '1234567890', 'aaa11', 'Da'),
(30, 'aaa', 'bbb', '1231231231234', 'Da', '0767277347', 'erge4', 'Nu'),
(31, 'aaa', 'bbb', '1231231231235', 'Nu', '0767277348', '34gr', 'Nu'),
(32, 'aaa', 'bbb', '1231231231236', 'Nu', '0767277349', 'gre44g', 'Da'),
(100, 'Ilie', 'Stefan', '8900998080989', 'Da', '0789898908', 'bloomi', 'Da'),
(232, 'Gica', 'Mitica', '1313131313131', 'Nu', '5655665566', 'gicuta', 'Da'),
(2233, 'Bejan', 'Teodora', '2032179123321', 'Da', '023698989', 'costache', 'Da'),
(4354, 'Georgel', 'Mitel', '3637328327288', 'Da', '1234234434', 'aaabbb', 'Da'),
(13242, 'grg', 'reger', '3423', 'Nu', '3244', '433trg', 'Da'),
(53534, 'ewfeew', 'wfwefwe', '23131123', 'Nu', '233213131', 'eee22', 'Da');

-- --------------------------------------------------------

--
-- Table structure for table `bon_fiscal`
--

CREATE TABLE `bon_fiscal` (
  `idb` int(11) NOT NULL,
  `terminal` char(20) DEFAULT NULL,
  `ida` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `ora` time DEFAULT NULL,
  `nr_de_prod` smallint(6) DEFAULT NULL,
  `pret_total` float DEFAULT NULL,
  `tip_plata` char(10) DEFAULT NULL,
  `numerar` float DEFAULT NULL,
  `rest` float DEFAULT NULL,
  `card` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bon_fiscal`
--

INSERT INTO `bon_fiscal` (`idb`, `terminal`, `ida`, `data`, `ora`, `nr_de_prod`, `pret_total`, `tip_plata`, `numerar`, `rest`, `card`) VALUES
(464, 'term124', 100, '2020-11-26', '03:05:00', 5, 2499.9, 'card', 0, 0, 'REVOLUT'),
(465, 'term125', 100, '2020-11-27', '04:05:00', 5, 2499.9, 'card', 0, 0, 'BT'),
(35154, 'term123', 100, '2020-11-25', '02:05:00', 5, 2499.9, 'numerar', 2500, 0.1, 'none'),
(1123352, '11', 5, '1973-11-26', '12:55:41', 1, NULL, 'numerar', NULL, NULL, NULL),
(1297116, '13', 2, '2002-01-11', '14:48:35', 9, NULL, 'numerar', NULL, NULL, NULL),
(1386364, '12', 16, '2013-10-04', '13:52:22', 6, NULL, 'card', NULL, NULL, NULL),
(1640922, '13', 17, '1980-11-11', '14:24:31', 9, NULL, 'numerar', NULL, NULL, NULL),
(1842546, '17', 2, '2013-11-26', '22:59:44', 5, NULL, 'numerar', NULL, NULL, NULL),
(1893317, '10', 17, '2015-04-03', '02:15:26', 5, NULL, 'card', NULL, NULL, NULL),
(1986967, '16', 2, '1970-10-11', '06:50:43', 5, NULL, 'card', NULL, NULL, NULL),
(2014726, '20', 10, '1999-11-07', '02:02:16', 8, NULL, 'numerar', NULL, NULL, NULL),
(2039755, '16', 20, '1972-05-03', '17:26:09', 5, NULL, 'card', NULL, NULL, NULL),
(2540656, '20', 3, '2006-02-08', '23:26:02', 4, NULL, 'card', NULL, NULL, NULL),
(2622144, '15', 4, '2010-08-01', '12:39:14', 8, NULL, 'card', NULL, NULL, NULL),
(2673095, '13', 18, '2019-01-23', '20:21:29', 4, NULL, 'numerar', NULL, NULL, NULL),
(2694476, '20', 2, '1999-07-12', '15:59:09', 2, NULL, 'numerar', NULL, NULL, NULL),
(2807031, '16', 20, '1999-04-26', '02:19:46', 7, NULL, 'numerar', NULL, NULL, NULL),
(2836446, '19', 1, '1987-09-12', '11:13:16', 4, NULL, 'card', NULL, NULL, NULL),
(3088110, '19', 9, '2017-12-16', '02:52:21', 8, NULL, 'card', NULL, NULL, NULL),
(3168147, '12', 2, '2016-03-14', '03:01:02', 5, NULL, 'numerar', NULL, NULL, NULL),
(3177866, '14', 13, '1982-09-03', '22:16:04', 0, NULL, 'numerar', NULL, NULL, NULL),
(3351838, '13', 15, '2011-10-28', '10:03:03', 2, NULL, 'numerar', NULL, NULL, NULL),
(3370638, '20', 6, '2015-03-25', '16:56:56', 5, NULL, 'numerar', NULL, NULL, NULL),
(3499177, '11', 20, '2010-02-02', '05:09:02', 5, NULL, 'card', NULL, NULL, NULL),
(3540827, '11', 11, '1971-07-21', '10:09:26', 8, NULL, 'card', NULL, NULL, NULL),
(3542886, '11', 19, '2000-12-17', '13:25:11', 8, NULL, 'card', NULL, NULL, NULL),
(3588964, '11', 11, '2011-05-28', '16:47:06', 1, NULL, 'card', NULL, NULL, NULL),
(3694182, '12', 9, '2001-12-22', '14:52:31', 5, NULL, 'card', NULL, NULL, NULL),
(3698457, '15', 14, '2019-11-05', '18:43:56', 0, NULL, 'numerar', NULL, NULL, NULL),
(3814014, '13', 15, '1992-05-06', '13:42:30', 4, NULL, 'card', NULL, NULL, NULL),
(3854419, '15', 1, '1985-09-19', '03:02:46', 1, NULL, 'card', NULL, NULL, NULL),
(3926319, '12', 15, '1976-08-08', '12:08:19', 4, NULL, 'numerar', NULL, NULL, NULL),
(4187434, '17', 20, '1971-12-17', '04:20:52', 3, NULL, 'numerar', NULL, NULL, NULL),
(4203381, '11', 2, '2013-06-29', '03:43:57', 3, NULL, 'numerar', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `distribuitor`
--

CREATE TABLE `distribuitor` (
  `CUI` int(10) NOT NULL,
  `Nume` varchar(50) NOT NULL DEFAULT '0',
  `Adresa` varchar(50) DEFAULT NULL,
  `Telefon` char(10) DEFAULT '0',
  `Col_activa` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `distribuitor`
--

INSERT INTO `distribuitor` (`CUI`, `Nume`, `Adresa`, `Telefon`, `Col_activa`) VALUES
(1, 'BiC', '38901 Treutel Brooks Apt. 618\nSouth Earnestine, OR', '0563907097', 'Da'),
(2, 'Blue Office', '6819 Grayson Isle\nNorth Jovanshire, NH 14538-2131', '(963)633-5', 'Da'),
(3, 'AIHAO', '824 Oberbrunner Road\nReichelberg, SC 02188-1849', '614.762.53', 'Da'),
(4, 'Herlitz', '178 Madie Center\nRahulchester, WA 37444-6607', '1-670-535-', 'Da'),
(5, 'NOKI', '9408 Hagenes Fort Gorczanyport, NH 05677', '1-344-716-', 'Nu'),
(6, 'Asia Pulp & Paper', '56893 Simonis Squares\nQuitzonfurt, MS 58662', '312-479-82', 'Da'),
(7, 'PRODCOM', '3000 Wolf Ports South Myah, PA 17845-4064', '(895)491-6', 'Da'),
(8, 'JinXin', '601 Buck Corner Suite 927\nPort Lilliehaven, OK 891', '916.142.57', 'Da'),
(9, 'Paladin', '49868 Hermann Rest Apt. 592\nBeckerville, CO 58732-', '677.313.21', 'Da'),
(10, 'Litera', '10984 Lind Parks\nWest Macy, ME 56990-2840', '(262)694-6', 'Nu'),
(11, 'Art', '483 Branson Islands Apt. 916\nNew Eryn, AL 23808', '599.769.00', 'Da'),
(12, 'Koh-I-Noor', '44583 Hermann Ford\nLuramouth, OH 25628-8001', '1-180-315-', 'Da'),
(13, 'Uzina de cartegregrg', '16511 Gusikowski Mountain New Maybellemouth, ME 63', '0590289310', 'Nu'),
(16, 'eMAG', '2286 Lennie Forks\nWest Paulaside, NJ 78860', '1-054-107-', 'Da'),
(17, 'HUMANITAS', '902 Reba Well Suite 676\nHollyton, IN 28285', '809.283.77', 'Nu'),
(18, 'Paralela 45', 'hdhtfh', '0636462557', 'Da'),
(19, 'Booklet', '401 Ilene Shoals Apt. 562\nKelsiehaven, WA 51099-79', '(020)483-4', 'Da'),
(20, 'Pigna România Impex SRL', '0931 Little Mills Suite 086\nEast Brian, AR 45090-5', '+05(2)7384', 'Da'),
(21, 'aaa', 'rge', '8278267468', 'Da'),
(22, 'bbb', 'gere', '8278267468', 'Nu'),
(23, 'ccc', 'rgege', '8278267468', 'Da'),
(24, 'aaa', 'rge', '8278267468', 'Da'),
(25, 'bbb', 'gere', '8278267468', 'Nu'),
(26, 'ccc', 'rgege', '8278267468', 'Da');

-- --------------------------------------------------------

--
-- Table structure for table `tip_produs`
--

CREATE TABLE `tip_produs` (
  `idp` int(11) NOT NULL,
  `denumire` varchar(50) DEFAULT '0',
  `categorie` varchar(50) DEFAULT '0',
  `subcategorie` varchar(50) DEFAULT '0',
  `in_stoc` int(11) DEFAULT NULL,
  `pret_init` float DEFAULT NULL,
  `um` varchar(10) DEFAULT NULL,
  `reducere` tinyint(4) DEFAULT NULL,
  `tva` tinyint(4) DEFAULT NULL,
  `taxa_eco` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tip_produs`
--

INSERT INTO `tip_produs` (`idp`, `denumire`, `categorie`, `subcategorie`, `in_stoc`, `pret_init`, `um`, `reducere`, `tva`, `taxa_eco`) VALUES
(1, '\"Ucenicul Vrăjitorului”, de Tahir Shah', 'Carte', 'Fantasy', 165, 420.996, 'bucata', 23, 15, 1),
(2, '”Crimă și pedeapsă”, de Dostoievski', 'Carte', 'Crimă', 76, 208.542, 'bucata', 11, 12, 2),
(3, '”Maestrul și Margareta”, de Bulgakov', 'Carte', 'Fantasy', 53, 42.787, 'bucata', 7, 10, 5),
(4, '”Istoria românilor”, de wfehwhhje', 'Carte', 'Istorie', 137, 317.155, 'bucata', 10, 17, 4),
(5, '”Atlas geografic al României”, de wefew', 'Carte', 'Geografie', 19, 419.038, 'bucata', 18, 11, 4),
(6, 'Creioane Koh-I-Noor negre 4G', 'Rechizite', 'creioane', 98, 165.162, 'pachet 10', 13, 13, 2),
(7, 'aaaaaaa', '0', '0', 64, 475.686, 'pachet 12', 21, 10, 5),
(8, 'bbbbbbbbbbbbb', '0', '0', 71, 170.398, 'metru', 5, 16, 3),
(9, 'ccccccccccccc', '0', '0', 100, 30.2, 'metru', 9, 15, 1),
(10, 'ddddddddddddd', '0', '0', 89, 387.517, NULL, 14, 14, 3),
(11, 'eeeeeeeeeeeeeeeeeee', '0', '0', 57, 310.797, NULL, 11, 13, 4),
(12, 'ffffffffff', '0', '0', 11, 221.237, NULL, 27, 12, 5),
(13, 'gggggggggggg', '0', '0', 90, 102.558, NULL, 30, 18, 4),
(14, 'hhhhhhhhhhhhh', '0', '0', 12, 402.506, NULL, 9, 13, 0),
(15, 'iiiiiiiiiiiiiiii', '0', '0', 25, 265.997, NULL, 16, 15, 5),
(16, 'jjjjjjjjjjjjjjjjjj', '0', '0', 30, 61.25, NULL, 16, 17, 4),
(17, 'kkkkkkkkkkkkk', '0', '0', 82, 371.057, NULL, 13, 16, 3),
(18, 'lllllllllllllllll', '0', '0', 73, 304.361, NULL, 19, 10, 1),
(19, 'mmmmmmmmmmmm', '0', '0', 6, 313.261, NULL, 5, 13, 4),
(20, 'nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn', '0', '0', 95, 54.037, NULL, 14, 12, 4),
(1212, 'nume1', 'Carte', 'Aventura', 10, 10.1, 'bucata', 5, 19, 5),
(1313, 'nume2', 'Filme', 'Actiune', 20, 20, 'bucata', 7, 19, 5),
(32432, 'hartie quiling', 'Papetărie', 'deco', 100, 12, 'set 100', 0, 19, 0),
(67567, 'KungFu Panda', 'Filme', 'Actiune', 10, 15, 'bucata', 0, 25, 0),
(89787, 'hartie quiling', 'Papetărie', 'deco', 100, 12, 'set 100', 0, 19, 0);

-- --------------------------------------------------------

--
-- Table structure for table `vandut`
--

CREATE TABLE `vandut` (
  `idp` int(11) NOT NULL,
  `idb` int(11) NOT NULL,
  `cantitate` smallint(6) NOT NULL DEFAULT 0,
  `pret_final` float NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vandut`
--

INSERT INTO `vandut` (`idp`, `idb`, `cantitate`, `pret_final`) VALUES
(20, 2039755, 70, 56.0484),
(7, 3177866, 41, 418.371),
(6, 3854419, 15, 164.371),
(9, 1893317, 68, 335.159),
(20, 3370638, 47, 56.0484),
(5, 1640922, 83, 385.408),
(2, 2836446, 37, 209.875),
(4, 1986967, 92, 337.964),
(15, 2014726, 48, 261.953),
(15, 3351838, 9, 261.953),
(19, 2807031, 38, 340.286),
(8, 3177866, 17, 190.779),
(16, 2673095, 58, 64.1965),
(9, 3370638, 62, 335.159),
(16, 2694476, 14, 64.1965),
(1, 1893317, 57, 373.792),
(19, 2807031, 17, 340.286),
(9, 4187434, 77, 335.159),
(2, 3540827, 1, 209.875),
(2, 1842546, 43, 209.875),
(4, 2014726, 0, 337.964),
(11, 2807031, 90, 316.569),
(5, 2014726, 71, 385.408),
(1, 1386364, 21, 373.792),
(15, 2694476, 95, 261.953),
(14, 3088110, 79, 413.897),
(17, 1386364, 60, 377.471),
(4, 3177866, 57, 337.964),
(14, 3351838, 79, 413.897),
(7, 3351838, 59, 418.371),
(1, 3588964, 78, 373.792),
(11, 1386364, 96, 316.569),
(9, 3177866, 87, 335.159),
(6, 3177866, 74, 164.371),
(17, 3540827, 66, 377.471),
(9, 2622144, 84, 335.159),
(4, 3499177, 68, 337.964),
(13, 1893317, 65, 88.7129),
(16, 2622144, 82, 64.1965),
(13, 2807031, 55, 88.7129),
(19, 2694476, 91, 340.286),
(12, 1297116, 61, 185.883),
(20, 1386364, 26, 56.0484),
(4, 3499177, 26, 337.964),
(15, 2807031, 23, 261.953),
(5, 3694182, 77, 385.408);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `achizitie`
--
ALTER TABLE `achizitie`
  ADD KEY `FK_achizitie_distribuitor` (`CUI`),
  ADD KEY `FK_achizitie_tip_produs` (`idp`);

--
-- Indexes for table `angajat`
--
ALTER TABLE `angajat`
  ADD PRIMARY KEY (`ida`);

--
-- Indexes for table `bon_fiscal`
--
ALTER TABLE `bon_fiscal`
  ADD PRIMARY KEY (`idb`),
  ADD KEY `FK_bon_fiscal_angajat` (`ida`);

--
-- Indexes for table `distribuitor`
--
ALTER TABLE `distribuitor`
  ADD PRIMARY KEY (`CUI`);

--
-- Indexes for table `tip_produs`
--
ALTER TABLE `tip_produs`
  ADD PRIMARY KEY (`idp`);

--
-- Indexes for table `vandut`
--
ALTER TABLE `vandut`
  ADD KEY `FK_vandut_tip_produs` (`idp`),
  ADD KEY `FK_vandut_bon_fiscal` (`idb`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `angajat`
--
ALTER TABLE `angajat`
  MODIFY `ida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53535;

--
-- AUTO_INCREMENT for table `tip_produs`
--
ALTER TABLE `tip_produs`
  MODIFY `idp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89788;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `achizitie`
--
ALTER TABLE `achizitie`
  ADD CONSTRAINT `FK_achizitie_distribuitor` FOREIGN KEY (`CUI`) REFERENCES `distribuitor` (`CUI`),
  ADD CONSTRAINT `FK_achizitie_tip_produs` FOREIGN KEY (`idp`) REFERENCES `tip_produs` (`idp`);

--
-- Constraints for table `bon_fiscal`
--
ALTER TABLE `bon_fiscal`
  ADD CONSTRAINT `FK_bon_fiscal_angajat` FOREIGN KEY (`ida`) REFERENCES `angajat` (`ida`);

--
-- Constraints for table `vandut`
--
ALTER TABLE `vandut`
  ADD CONSTRAINT `FK_vandut_bon_fiscal` FOREIGN KEY (`idb`) REFERENCES `bon_fiscal` (`idb`),
  ADD CONSTRAINT `FK_vandut_tip_produs` FOREIGN KEY (`idp`) REFERENCES `tip_produs` (`idp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
