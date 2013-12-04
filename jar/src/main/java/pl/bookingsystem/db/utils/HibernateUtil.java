package pl.bookingsystem.db.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    static {
        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Transaction getTransaction() {
        return transaction;
    }

    public static Session getSession() {
        return session;
    }

    public static void beginTransaction() {
        beginSession();
        transaction = session.beginTransaction();
    }

    public static void beginSession() {
        session = sessionFactory.openSession();
    }

    public static void closeSession() {
        session.close();
    }

    public static void commitTransaction() {
        transaction.commit();
        closeSession();
    }

    public static void rollbackTransaction() {
        transaction.rollback();
        closeSession();
    }
}