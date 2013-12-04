package pl.bookingsystem.common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.bookingsystem.db.dao.MessageDAO;
import pl.bookingsystem.db.dao.PersonDAO;
import pl.bookingsystem.db.dao.impl.MessageDAOImpl;
import pl.bookingsystem.db.dao.impl.PersonDAOImpl;
import pl.bookingsystem.db.entity.Message;
import pl.bookingsystem.db.entity.Person;

import java.sql.Timestamp;
import java.util.List;

public class Main {

    private SessionFactory sessionFactory = null;

    public Main() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private void run() {

        PersonDAO personManager = new PersonDAOImpl();

        Person wanted = personManager.findByPersonName("Steven", "Seagal");
        System.out.println(wanted);

        System.out.println(personManager.findPersonById((long) 1079));
        Person chuck = new Person("Chuck", "Norris", Timestamp.valueOf("2013-10-10 10:10:10"), "Male");
        personManager.saveNewPerson(chuck);
        personManager.printAllPersonsTo(System.out);
        //personManager.deletePerson(chuck);

        List allPersons = personManager.loadAllPersons();


        for (Object person : allPersons) {
            System.out.println(person);
        }

        MessageDAO messageDao = new MessageDAOImpl();

        System.out.println("Wprowadz 1 wiadomosc: ");
        String message = messageDao.readMessageFrom(System.in);
        messageDao.putMessage(new Message(message));


        messageDao.readMessagesTo(System.out);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
