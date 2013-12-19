package pl.bookingsystem.common;

import pl.bookingsystem.db.dao.HotelDAO;
import pl.bookingsystem.db.dao.RoomDAO;
import pl.bookingsystem.db.dao.UserDAO;
import pl.bookingsystem.db.dao.impl.HotelDAOImpl;
import pl.bookingsystem.db.dao.impl.RoomDAOImpl;
import pl.bookingsystem.db.dao.impl.UserDAOImpl;
import pl.bookingsystem.db.entity.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddToDB {

    public static void addHotel() {
        HotelDAO hotelManager = new HotelDAOImpl();
        Address client_address = new Address("Wrocław", "Swidnicka", 120, 10, "44-450", "Polska");
        Date register_date = new Date();
        Set<Client> clients = new HashSet<Client>();
        clients.add(new Client("Jan", "Nowak", 85010101234L, "jan.nowak@gmail.com", "791234123", "pass", client_address, register_date));

        UserDAO userManager = new UserDAOImpl();
        List list = userManager.selectAll(User.class);
        Set<User> users = new HashSet<User>(list);


        Address hotel_address = new Address("Krakow", "Lubicz", 1, "30-200", "Polska");
        Hotel hotel = new Hotel("Hotel BLABLA", "+48 0123456789", "kontakt@hotelblabla.pl", hotel_address, clients, users);
        hotelManager.save(hotel);

        hotel.addRoom(addRoom(hotel));
        hotelManager.save(hotel);

        System.out.println("Rooms:");
        for (Room room : hotel.getRooms()) {
            System.out.println(room.getName());
        }
    }

    public static Room addRoom(Hotel hotel) {
        RoomDAO roomManager = new RoomDAOImpl();
        Room room = new Room(1, "Pokoj goscinny nr 1", "2x1", 2, hotel);
        roomManager.save(room);
        return room;
    }

    public static void addUser() {
        UserDAO userManager = new UserDAOImpl();
        User user = new User("Zenon", "Breszka", 90030801234L, "z@gmail.pl", "792011166", "admin", User.Type.ADMIN, new Address("Krakow", "Wadowicka", 6, "12-234", "Polska"));
        userManager.save(user);
        user = new User("Rysiu", "Hebel", 80030801234L, "r@gmail.pl", "888011166", "user", User.Type.EMPLOYEE, new Address("Wroclaw", "Wroclawska", 7, 2, "32-234", "Polska"));
        userManager.save(user);
    }

}
