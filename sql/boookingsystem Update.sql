UPDATE Hotel_User SET 
   
WHERE
  Hotelid = ? AND Userid = ?;
UPDATE User SET
  first_name = ?, 
  last_name = ?, 
  pesel = ?, 
  nip = ?, 
  email = ?, 
  phone_number = ?, 
  password = ?, 
  type = ? 
WHERE
  id = ?;
UPDATE Status SET 
  type = ?, 
  description = ? 
WHERE
  id = ?;
UPDATE Room_Price SET 
   
WHERE
  Roomid = ? AND Priceid = ?;
UPDATE Price SET 
  room_type = ?, 
  person_type = ?, 
  value = ? 
WHERE
  id = ?;
UPDATE Client_Hotel SET 
   
WHERE
  Clientid = ? AND Hotelid = ?;
UPDATE Client SET 
  first_name = ?, 
  last_name = ?, 
  pesel = ?, 
  nip = ?, 
  email = ?, 
  phone_number = ?, 
  password = ? 
WHERE
  id = ?;
UPDATE Room_Reservation SET 
   
WHERE
  Roomid = ? AND Reservationid = ?;
UPDATE Reservation SET 
  name = ?, 
  date_from = ?, 
  date_to = ?, 
  person_count = ?, 
  date_edit = ?, 
  Clientid = ?, 
  Statusid = ? 
WHERE
  id = ?;
UPDATE Addition SET 
  name = ?, 
  description = ?, 
  Roomid = ? 
WHERE
  id = ?;
UPDATE Room SET 
  room_no = ?, 
  name = ?, 
  description = ?, 
  bed = ?, 
  capacity = ?, 
  Hotelid = ? 
WHERE
  id = ?;
UPDATE Address SET 
  city = ?, 
  street = ?, 
  building_no = ?, 
  apartment_no = ?, 
  postcode = ?, 
  country = ? 
WHERE
  id = ?;
UPDATE Hotel SET 
  name = ?, 
  description = ?, 
  phone_number = ?, 
  email = ? 
WHERE
  id = ?;

