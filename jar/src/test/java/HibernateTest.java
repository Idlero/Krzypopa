import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bookingsystem.db.dao.PersonDAO;
import pl.bookingsystem.db.dao.impl.PersonDAOImpl;
import pl.bookingsystem.db.entity.Person;

import java.sql.Timestamp;


public class HibernateTest {

    PersonDAO personManager;
    Person person;

    @Before
    public void init() {
        personManager = new PersonDAOImpl();
    }

    @Test
    public void shouldAddNewPersonToDatabase() {

        //given
        person = new Person("XXXXX", "YYYYY", Timestamp.valueOf("2010-10-10 10:10:10"), "ZZZ");

        //when
        personManager.saveNewPerson(person);

        //then
        Person expected = personManager.findPersonById(person.getId());
        Assert.assertEquals(expected.getId(), person.getId());
        Assert.assertEquals(expected.getBirthdate(), person.getBirthdate());
    }

    @After
    public void deletePerson() {
        personManager.deletePerson(person);
        person = null;
    }

}
