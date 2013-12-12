SELECT Hotelid, Userid 
  FROM Hotel_User;
SELECT id, first_name, last_name, pesel, nip, email, phone_number, password, type 
  FROM 'User';
SELECT id, type, description 
  FROM Status;
SELECT Roomid, Priceid 
  FROM Room_Price;
SELECT id, room_type, person_type, value 
  FROM Price;
SELECT Clientid, Hotelid 
  FROM Client_Hotel;
SELECT id, first_name, last_name, pesel, nip, email, phone_number, password 
  FROM Client;
SELECT Roomid, Reservationid 
  FROM Room_Reservation;
SELECT id, name, date_from, date_to, person_count, date_edit, Clientid, Statusid 
  FROM Reservation;
SELECT id, name, description, Roomid 
  FROM Addition;
SELECT id, room_no, name, description, bed, capacity, Hotelid 
  FROM Room;
SELECT id, city, street, building_no, apartment_no, postcode, country 
  FROM Address;
SELECT id, name, description, phone_number, email 
  FROM Hotel;

