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
ALTER TABLE Address ADD INDEX FKAddress614460 (id), ADD CONSTRAINT FKAddress614460 FOREIGN KEY (id) REFERENCES `User` (id);
ALTER TABLE Hotel_User ADD INDEX FKHotel_User858112 (Userid), ADD CONSTRAINT FKHotel_User858112 FOREIGN KEY (Userid) REFERENCES `User` (id);
ALTER TABLE Hotel_User ADD INDEX FKHotel_User158707 (Hotelid), ADD CONSTRAINT FKHotel_User158707 FOREIGN KEY (Hotelid) REFERENCES Hotel (id);
ALTER TABLE Reservation ADD INDEX FKReservatio487354 (Statusid), ADD CONSTRAINT FKReservatio487354 FOREIGN KEY (Statusid) REFERENCES Status (id);
ALTER TABLE Room_Price ADD INDEX FKRoom_Price14296 (Priceid), ADD CONSTRAINT FKRoom_Price14296 FOREIGN KEY (Priceid) REFERENCES Price (id);
ALTER TABLE Room_Price ADD INDEX FKRoom_Price109505 (Roomid), ADD CONSTRAINT FKRoom_Price109505 FOREIGN KEY (Roomid) REFERENCES Room (id);
ALTER TABLE Client_Hotel ADD INDEX FKClient_Hot294122 (Hotelid), ADD CONSTRAINT FKClient_Hot294122 FOREIGN KEY (Hotelid) REFERENCES Hotel (id);
ALTER TABLE Client_Hotel ADD INDEX FKClient_Hot718968 (Clientid), ADD CONSTRAINT FKClient_Hot718968 FOREIGN KEY (Clientid) REFERENCES Client (id);
ALTER TABLE Reservation ADD INDEX FKReservatio2740 (Clientid), ADD CONSTRAINT FKReservatio2740 FOREIGN KEY (Clientid) REFERENCES Client (id);
ALTER TABLE Client ADD INDEX FKClient879079 (id), ADD CONSTRAINT FKClient879079 FOREIGN KEY (id) REFERENCES Address (id);
ALTER TABLE Room_Reservation ADD INDEX FKRoom_Reser269207 (Reservationid), ADD CONSTRAINT FKRoom_Reser269207 FOREIGN KEY (Reservationid) REFERENCES Reservation (id);
ALTER TABLE Room_Reservation ADD INDEX FKRoom_Reser623976 (Roomid), ADD CONSTRAINT FKRoom_Reser623976 FOREIGN KEY (Roomid) REFERENCES Room (id);
ALTER TABLE Room ADD INDEX FKRoom661465 (Hotelid), ADD CONSTRAINT FKRoom661465 FOREIGN KEY (Hotelid) REFERENCES Hotel (id);
ALTER TABLE Addition ADD INDEX FKAddition128534 (Roomid), ADD CONSTRAINT FKAddition128534 FOREIGN KEY (Roomid) REFERENCES Room (id);
ALTER TABLE Address ADD INDEX FKAddress883560 (id), ADD CONSTRAINT FKAddress883560 FOREIGN KEY (id) REFERENCES Hotel (id);
