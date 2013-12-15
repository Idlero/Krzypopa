-- phpMyAdmin SQL Dump
-- version 4.0.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 15 Gru 2013, 22:55
-- Wersja serwera: 5.5.8
-- Wersja PHP: 5.3.5

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
-- Struktura tabeli dla tabeli `addition`
--

CREATE TABLE IF NOT EXISTS `addition` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `Roomid` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAddition128534` (`Roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `building_no` int(4) NOT NULL,
  `apartment_no` int(4) DEFAULT NULL,
  `postcode` varchar(8) NOT NULL,
  `country` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Zrzut danych tabeli `address`
--

INSERT INTO `address` (`id`, `city`, `street`, `building_no`, `apartment_no`, `postcode`, `country`) VALUES
(2, 'Krakow', 'Wadowicka', 6, NULL, '12-234', 'Polska'),
(3, 'Wroclaw', 'Wroclawska', 7, 2, '32-234', 'Polska'),
(4, 'Krakow', 'Wadowicka', 6, NULL, '12-234', 'Polska'),
(5, 'Wroclaw', 'Wroclawska', 7, 2, '32-234', 'Polska'),
(6, 'Krakow', 'Wadowicka', 6, NULL, '12-234', 'Polska'),
(7, 'Wroclaw', 'Wroclawska', 7, 2, '32-234', 'Polska');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `pesel` bigint(11) NOT NULL,
  `nip` bigint(10) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address_id` bigint(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `client_hotel`
--

CREATE TABLE IF NOT EXISTS `client_hotel` (
  `Clientid` bigint(10) NOT NULL,
  `Hotelid` bigint(10) NOT NULL,
  PRIMARY KEY (`Clientid`,`Hotelid`),
  KEY `FKClient_Hot294122` (`Hotelid`),
  KEY `FKClient_Hot718968` (`Clientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hotel`
--

CREATE TABLE IF NOT EXISTS `hotel` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `phone_number` varchar(25) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hotel_user`
--

CREATE TABLE IF NOT EXISTS `hotel_user` (
  `Hotelid` bigint(10) NOT NULL,
  `Userid` bigint(10) NOT NULL,
  PRIMARY KEY (`Hotelid`,`Userid`),
  KEY `FKHotel_User858112` (`Userid`),
  KEY `FKHotel_User158707` (`Hotelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `price`
--

CREATE TABLE IF NOT EXISTS `price` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `room_type` varchar(10) DEFAULT NULL,
  `person_type` varchar(10) NOT NULL,
  `value` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `date_from` date NOT NULL,
  `date_to` date NOT NULL,
  `person_count` int(4) NOT NULL,
  `date_edit` date DEFAULT NULL,
  `Clientid` bigint(10) NOT NULL,
  `Statusid` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKReservatio487354` (`Statusid`),
  KEY `FKReservatio2740` (`Clientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `room`
--

CREATE TABLE IF NOT EXISTS `room` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `room_no` int(10) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `bed` varchar(5) DEFAULT NULL,
  `capacity` int(2) DEFAULT NULL,
  `Hotelid` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKRoom661465` (`Hotelid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `room_price`
--

CREATE TABLE IF NOT EXISTS `room_price` (
  `Roomid` bigint(10) NOT NULL,
  `Priceid` bigint(10) NOT NULL,
  PRIMARY KEY (`Roomid`,`Priceid`),
  KEY `FKRoom_Price14296` (`Priceid`),
  KEY `FKRoom_Price109505` (`Roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `room_reservation`
--

CREATE TABLE IF NOT EXISTS `room_reservation` (
  `Roomid` bigint(10) NOT NULL,
  `Reservationid` bigint(10) NOT NULL,
  PRIMARY KEY (`Roomid`,`Reservationid`),
  KEY `FKRoom_Reser269207` (`Reservationid`),
  KEY `FKRoom_Reser623976` (`Roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `status`
--

CREATE TABLE IF NOT EXISTS `status` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `pesel` bigint(11) NOT NULL,
  `nip` bigint(20) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `address_id` bigint(10) NOT NULL,
  `phone_number` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type` enum('ADMIN','OWNER','EMPLOYEE') NOT NULL DEFAULT 'EMPLOYEE',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `pesel`, `nip`, `email`, `address_id`, `phone_number`, `password`, `type`) VALUES
(1, 'Zenon', 'Breszka', 90030801234, NULL, 'z@gmail.pl', 2, '792011166', 'admin', 'ADMIN'),
(2, 'Rysiu', 'Hebel', 80030801234, NULL, 'r@gmail.pl', 3, '888011166', 'user', 'EMPLOYEE');

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `addition`
--
ALTER TABLE `addition`
ADD CONSTRAINT `FKAddition128534` FOREIGN KEY (`Roomid`) REFERENCES `room` (`id`);

--
-- Ograniczenia dla tabeli `client_hotel`
--
ALTER TABLE `client_hotel`
ADD CONSTRAINT `FKClient_Hot294122` FOREIGN KEY (`Hotelid`) REFERENCES `hotel` (`id`),
ADD CONSTRAINT `FKClient_Hot718968` FOREIGN KEY (`Clientid`) REFERENCES `client` (`id`);

--
-- Ograniczenia dla tabeli `hotel_user`
--
ALTER TABLE `hotel_user`
ADD CONSTRAINT `FKHotel_User158707` FOREIGN KEY (`Hotelid`) REFERENCES `hotel` (`id`),
ADD CONSTRAINT `FKHotel_User858112` FOREIGN KEY (`Userid`) REFERENCES `user` (`id`);

--
-- Ograniczenia dla tabeli `reservation`
--
ALTER TABLE `reservation`
ADD CONSTRAINT `FKReservatio2740` FOREIGN KEY (`Clientid`) REFERENCES `client` (`id`),
ADD CONSTRAINT `FKReservatio487354` FOREIGN KEY (`Statusid`) REFERENCES `status` (`id`);

--
-- Ograniczenia dla tabeli `room`
--
ALTER TABLE `room`
ADD CONSTRAINT `FKRoom661465` FOREIGN KEY (`Hotelid`) REFERENCES `hotel` (`id`);

--
-- Ograniczenia dla tabeli `room_price`
--
ALTER TABLE `room_price`
ADD CONSTRAINT `FKRoom_Price109505` FOREIGN KEY (`Roomid`) REFERENCES `room` (`id`),
ADD CONSTRAINT `FKRoom_Price14296` FOREIGN KEY (`Priceid`) REFERENCES `price` (`id`);

--
-- Ograniczenia dla tabeli `room_reservation`
--
ALTER TABLE `room_reservation`
ADD CONSTRAINT `FKRoom_Reser269207` FOREIGN KEY (`Reservationid`) REFERENCES `reservation` (`id`),
ADD CONSTRAINT `FKRoom_Reser623976` FOREIGN KEY (`Roomid`) REFERENCES `room` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
