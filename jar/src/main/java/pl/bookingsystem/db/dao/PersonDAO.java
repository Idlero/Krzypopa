package pl.bookingsystem.db.dao;

import pl.bookingsystem.db.entity.Person;

import java.io.PrintStream;
import java.util.List;

public interface PersonDAO extends GenericDAO<Person, Long> {

    public Person findByPersonName(String name, String surname);

    public List loadAllPersons();

    public void saveNewPerson(Person person);

    public Person findPersonById(Long id);

    public void deletePerson(Person person);

    void printAllPersonsTo(PrintStream printStream);
}