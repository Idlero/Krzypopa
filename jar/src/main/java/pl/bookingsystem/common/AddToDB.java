package pl.bookingsystem.common;

import pl.bookingsystem.db.dao.UserDAO;
import pl.bookingsystem.db.dao.impl.UserDAOImpl;
import pl.bookingsystem.db.entity.Address;
import pl.bookingsystem.db.entity.User;

public class AddToDB {

    public static void addUser(){
        UserDAO userManager = new UserDAOImpl();
        User user = new User("Zenon", "Breszka", 90030801234L, "z@gmail.pl", "792011166", "admin", User.Type.ADMIN, new Address("Krakow", "Wadowicka", 6, "12-234", "Polska"));
        userManager.save(user);
        user = new User("Rysiu", "Hebel", 80030801234L, "r@gmail.pl", "888011166", "user", User.Type.EMPLOYEE, new Address("Wroclaw", "Wroclawska", 7,2, "32-234", "Polska"));
        userManager.save(user);
    }
}
