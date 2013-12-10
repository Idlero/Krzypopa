-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas wygenerowania: 08 Gru 2013, 22:12
-- Wersja serwera: 5.5.32
-- Wersja PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `bookingsystem`
--
CREATE DATABASE IF NOT EXISTS `bookingsystem` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bookingsystem`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_client`  bigint(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) DEFAULT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `PESEL` bigint(11) DEFAULT NULL,
  `NIP` bigint(10) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_client`),
  UNIQUE KEY `id_client` (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dodatek`
--

CREATE TABLE IF NOT EXISTS `addition` (
  `id_addition`  bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `description` mediumtext,
  `status`  bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id_addition`),
  UNIQUE KEY `id_addition` (`id_addition`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `dodatki`
--

CREATE TABLE IF NOT EXISTS `addition_rooms` (
  `id_ar`  bigint(10) NOT NULL AUTO_INCREMENT,
  `id_room`  bigint(10) NOT NULL,
  `id_addition`  bigint(10) NOT NULL,
  PRIMARY KEY (`id_ar`),
  UNIQUE KEY `id_ar` (`id_ar`),
  KEY `FKAddition_rooms927824` (`id_addition`),
  KEY `FKAddition_rooms401349` (`id_room`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id_hotel`  bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `address` char(255) DEFAULT NULL,
  PRIMARY KEY (`id_hotel`),
  UNIQUE KEY `id_hotel` (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pokoje`
--

CREATE TABLE IF NOT EXISTS `room` (
  `id_room`  bigint(10) NOT NULL AUTO_INCREMENT,
  `no_room`  bigint(10) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `bed` varchar(5) DEFAULT NULL,
  `capacity`  bigint(2) DEFAULT NULL,
  `id_hotel`  bigint(10) NOT NULL,
  PRIMARY KEY (`id_room`),
  UNIQUE KEY `id_room` (`id_room`),
  KEY `FKRoom494590` (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracownik`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `id_employee`  bigint(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) DEFAULT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `id_hotel`  bigint(10) NOT NULL,
  `status` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id_employee`),
  UNIQUE KEY `id_employee` (`id_employee`),
  KEY `FKEmployee238613` (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rezerwacja`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation`  bigint(10) NOT NULL AUTO_INCREMENT,
  `id_hotel`  bigint(10) NOT NULL,
  `id_status`  bigint(10) NOT NULL,
  `id_dates`  bigint(10) NOT NULL,
  `price` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  UNIQUE KEY `id_reservation` (`id_reservation`),
  KEY `FKReservation475315` (`id_hotel`),
  KEY `FKReservation64150` (`id_status`),
  KEY `FKReservation304589` (`id_dates`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `status`
--

CREATE TABLE IF NOT EXISTS `status` (
  `id_status`  bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `description` mediumtext,
  `color` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id_status`),
  UNIQUE KEY `id_status` (`id_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `system`
--

CREATE TABLE IF NOT EXISTS `system` (
  `id_sysytem`  bigint(10) NOT NULL,
  `id_reservation`  bigint(10) NOT NULL,
  `id_client`  bigint(10) NOT NULL,
  UNIQUE KEY `id_sysytem` (`id_sysytem`),
  KEY `FKSystem453224` (`id_client`),
  KEY `FKSystem691637` (`id_reservation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `termin`
--

CREATE TABLE IF NOT EXISTS `dates` (
  `id_dates`  bigint(10) NOT NULL AUTO_INCREMENT,
  `data_start` date DEFAULT NULL,
  `data_end` date DEFAULT NULL,
  PRIMARY KEY (`id_dates`),
  UNIQUE KEY `id_dates` (`id_dates`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Ograniczenia dla zrzutów tabel
--


--
-- Ograniczenia dla tabeli `pokoje`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FKRooms494590` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`);

--
-- Ograniczenia dla tabeli `pracownik`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKEmployee238613` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`);

--
-- Ograniczenia dla tabeli `rezerwacja`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKReservation304589` FOREIGN KEY (`id_dates`) REFERENCES `dates` (`id_dates`),
  ADD CONSTRAINT `FKReservation475315` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`),
  ADD CONSTRAINT `FKReservation64150` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`);

--
-- Ograniczenia dla tabeli `system`
--
ALTER TABLE `system`
  ADD CONSTRAINT `FKSystem453224` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FKSystem691637` FOREIGN KEY (`id_reservation`) REFERENCES `reservation` (`id_reservation`);
 

--
-- Ograniczenia dla tabeli `dodatki`
--

 
ALTER TABLE `addition_rooms`
  ADD CONSTRAINT `FKAddition_rooms927824` FOREIGN KEY (`id_addition`) REFERENCES `addition` (`id_addition`),
  ADD CONSTRAINT `FKAddition_rooms401349` FOREIGN KEY (`id_room`) REFERENCES `room` (`id_room`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
