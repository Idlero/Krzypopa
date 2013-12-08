package pl.bookingsystem.db.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.Session;
import pl.bookingsystem.db.dao.ClientDAO;
import pl.bookingsystem.db.entity.Client;
import pl.bookingsystem.db.utils.HibernateUtil;

public class ClientDAOImpl extends GenericDAOImpl<Client, Integer> implements ClientDAO {

    private static Logger logger = Logger.getLogger(ClientDAOImpl.class);

    public Client findByClientName(String name, String surname) {
        Client client = null;
        try {
            String sql = "SELECT p FROM Client p WHERE p.name = :name AND p.nazwisko = :nazwisko";
            Session session = HibernateUtil.getSessionFactory().openSession();

            Query query = session.createQuery(sql);
            query.setParameter("name", name).setParameter("nazwisko", surname);

            client = selectOne(query);

        } catch (NonUniqueResultException ex) {
            logger.error("FIND Client: " + ex.getMessage());
            System.out.println("Query returned more than one results.");
        } catch (HibernateException ex) {
            logger.error("FIND Client: " + ex.getMessage());
        }
        return client;
    }

}