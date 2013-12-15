CREATE TABLE Hotel_User (
  Hotelid bigint(10) NOT NULL, 
  Userid  bigint(10) NOT NULL, 
  PRIMARY KEY (Hotelid, 
  Userid)) ENGINE = InnoDB;
CREATE TABLE User (
  id           bigint(10) NOT NULL AUTO_INCREMENT, 
  first_name   varchar(255) NOT NULL, 
  last_name    varchar(255) NOT NULL, 
  pesel        bigint(11) NOT NULL, 
  nip          bigint(10) NOT NULL, 
  email        varchar(255) NOT NULL, 
  phone_number varchar(25) NOT NULL, 
  password     varchar(255) NOT NULL, 
  type         enum('ADMIN', 'OWNER', 'EMPLOYEE') default NULL, 
  PRIMARY KEY (id)) ENGINE = InnoDB;
CREATE TABLE Status (
  id          bigint(10) NOT NULL AUTO_INCREMENT, 
  type        varchar(255) NOT NULL, 
  description varchar(255), 
  PRIMARY KEY (id)) ENGINE = InnoDB;
CREATE TABLE Room_Price (
  Roomid  bigint(10) NOT NULL, 
  Priceid bigint(10) NOT NULL, 
  PRIMARY KEY (Roomid, 
  Priceid)) ENGINE = InnoDB;
CREATE TABLE Price (
  id          bigint(10) NOT NULL AUTO_INCREMENT, 
  room_type   varchar(10), 
  person_type varchar(10) NOT NULL, 
  value       int(6) NOT NULL, 
  PRIMARY KEY (id)) ENGINE = InnoDB;
CREATE TABLE Client_Hotel (
  Clientid bigint(10) NOT NULL, 
  Hotelid  bigint(10) NOT NULL, 
  PRIMARY KEY (Clientid, 
  Hotelid)) ENGINE = InnoDB;
CREATE TABLE Client (
  id           bigint(10) NOT NULL, 
  first_name   varchar(255) NOT NULL, 
  last_name    varchar(255) NOT NULL, 
  pesel        bigint(11) NOT NULL, 
  nip          bigint(10), 
  email        varchar(255) NOT NULL, 
  phone_number varchar(25) NOT NULL, 
  password     varchar(255) NOT NULL, 
  PRIMARY KEY (id)) ENGINE = InnoDB;
CREATE TABLE Room_Reservation (
  Roomid        bigint(10) NOT NULL, 
  Reservationid bigint(10) NOT NULL, 
  PRIMARY KEY (Roomid, 
  Reservationid)) ENGINE = InnoDB;
CREATE TABLE Reservation (
  id           bigint(10) NOT NULL AUTO_INCREMENT, 
  name         varchar(255), 
  date_from    date NOT NULL, 
  date_to      date NOT NULL, 
  person_count int(4) NOT NULL, 
  date_edit    date, 
  Clientid     bigint(10) NOT NULL, 
  Statusid     bigint(10) NOT NULL, 
  PRIMARY KEY (id)) ENGINE = InnoDB;
CREATE TABLE Addition (
  id          bigint(10) NOT NULL AUTO_INCREMENT, 
  name        varchar(255) NOT NULL, 
  description varchar(255), 
  Roomid      bigint(10) NOT NULL, 
  PRIMARY KEY (id)) ENGINE = InnoDB;
CREATE TABLE Room (
  id          bigint(10) NOT NULL AUTO_INCREMENT, 
  room_no     int(10) NOT NULL, 
  name        varchar(255), 
  description varchar(255), 
  bed         varchar(5), 
  capacity    int(2), 
  Hotelid     bigint(10) NOT NULL, 
  PRIMARY KEY (id)) ENGINE = InnoDB;
CREATE TABLE Address (
  id           bigint(10) NOT NULL, 
  city         varchar(255) NOT NULL, 
  street       varchar(255) NOT NULL, 
  building_no  int(4) NOT NULL, 
  apartment_no int(4), 
  postcode     varchar(8) NOT NULL, 
  country      varchar(50) NOT NULL, 
  PRIMARY KEY (id), 
  INDEX (id)) ENGINE = InnoDB;
CREATE TABLE Hotel (
  id           bigint(10) NOT NULL AUTO_INCREMENT, 
  name         varchar(255) NOT NULL, 
  description  varchar(255), 
  phone_number varchar(25), 
  email        varchar(255), 
  PRIMARY KEY (id), 
  INDEX (id)) ENGINE = InnoDB;