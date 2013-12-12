DELETE FROM Hotel_User 
  WHERE Hotelid = ? AND Userid = ?;
DELETE FROM 'User'
  WHERE id = ?;
DELETE FROM Status 
  WHERE id = ?;
DELETE FROM Room_Price 
  WHERE Roomid = ? AND Priceid = ?;
DELETE FROM Price 
  WHERE id = ?;
DELETE FROM Client_Hotel 
  WHERE Clientid = ? AND Hotelid = ?;
DELETE FROM Client 
  WHERE id = ?;
DELETE FROM Room_Reservation 
  WHERE Roomid = ? AND Reservationid = ?;
DELETE FROM Reservation 
  WHERE id = ?;
DELETE FROM Addition 
  WHERE id = ?;
DELETE FROM Room 
  WHERE id = ?;
DELETE FROM Address 
  WHERE id = ?;
DELETE FROM Hotel 
  WHERE id = ?;

