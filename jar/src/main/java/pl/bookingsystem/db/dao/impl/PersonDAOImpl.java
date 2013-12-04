package pl.bookingsystem.db.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import pl.bookingsystem.db.dao.PersonDAO;
import pl.bookingsystem.db.entity.Person;
import pl.bookingsystem.db.utils.HibernateUtil;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends GenericDAOImpl<Person, Long> implements PersonDAO {

    private static Logger logger = Logger.getLogger(PersonDAOImpl.class);

    public Person findByPersonName(String name, String surname) {
        logger.debug("findByPersonName");
        Person person = null;
        try {
            HibernateUtil.beginTransaction();
            person = findByName(name, surname);
            HibernateUtil.commitTransaction();
        } catch (NonUniqueResultException ex) {
            logger.error("FIND PERSON: " + ex.getMessage());
            System.out.println("Query returned more than one results.");
        } catch (HibernateException ex) {
            logger.error("FIND PERSON: " + ex.getMessage());
        }
        return person;
    }

    public Person findByName(String name, String surname) {
        logger.debug("findByName");
        Person person = null;
        String sql = "SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname";
        Query query = HibernateUtil.getSession().createQuery(sql).setParameter("name", name).setParameter("surname", surname);
        person = findOne(query);
        return person;
    }

    public List loadAllPersons() {
        logger.debug("loadAllPersons");
        List allPersons = new ArrayList<Person>();
        try {
            HibernateUtil.beginTransaction();
            allPersons = findAll(Person.class);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            logger.error("ALL PERSON: " + ex.getMessage());
        }
        return allPersons;
    }


    public void saveNewPerson(Person person) {
        logger.debug("saveNewPerson");
        try {
            HibernateUtil.beginTransaction();
            save(person);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            logger.error("SAVE PERSON: " + ex.getMessage());
            HibernateUtil.rollbackTransaction();
        }
    }

    public Person findPersonById(Long id) {
        logger.debug("findPersonById");
        Person person = null;
        try {
            HibernateUtil.beginTransaction();
            person = (Person) HibernateUtil.getSession().get(Person.class, id);
            //person = findByID(Person.class, id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            HibernateUtil.rollbackTransaction();
            logger.error("FIND PERSON by ID: " + ex.getMessage());
        }
        return person;
    }

    public void deletePerson(Person person) {
        logger.debug("deletePerson");
        try {
            HibernateUtil.beginTransaction();
            delete(person);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            logger.error("DELETE PERSON: " + ex.getMessage());
            HibernateUtil.rollbackTransaction();
        }
    }

    @Override
    public void printAllPersonsTo(PrintStream printStream) {
        logger.debug("printAllPersonsTo");
        List allPersons = loadAllPersons();

        for (Object person : allPersons) {
            printStream.println(person);
        }
    }
}