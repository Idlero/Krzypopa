package pl.bookingsystem.db.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import pl.bookingsystem.db.dao.MessageDAO;
import pl.bookingsystem.db.entity.Message;
import pl.bookingsystem.db.utils.HibernateUtil;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class MessageDAOImpl extends GenericDAOImpl<Message, Long> implements MessageDAO {

    private static Logger logger = Logger.getLogger(MessageDAOImpl.class);

    public void readMessagesTo(PrintStream printStream) {
        try {
            HibernateUtil.beginTransaction();
            String SQL_QUERY = "from Message as m order by m.text asc";
            Query query = HibernateUtil.getSession().createQuery(SQL_QUERY);

            System.out.println(String.format("Znaleziono: %d", query.list().size()));
            for (Object o : query.list()) {
                Message m = (Message) o;
                printStream.println(String.format("ID: %d \t Text: %s", m.getId(), m.getText()));
            }
//            Iterator<Message> iterator = query.iterate();
//            while (iterator.hasNext()) {
//                Message m = iterator.next();
//                System.out.println(String.format("ID: %d \t Text: %s", m.getId(), m.getText()));
//            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            logger.error(e.getMessage());
        }
    }

    public List<Message> getMessages() {
        List<Message> messages = null;
        try {
            messages = new LinkedList<Message>();
            HibernateUtil.beginTransaction();
            String SQL_QUERY = "from Message as m order by m.text asc";
            Query query = HibernateUtil.getSession().createQuery(SQL_QUERY);

            logger.info(String.format("Znaleziono: %d", query.list().size()));
            for (Object o : query.list()) {
                Message m = (Message) o;
                messages.add(m);
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            logger.error(e.getMessage());
        }
        return messages;
    }

    public void putMessage(Message message) {
        try {
            HibernateUtil.beginTransaction();
            save(message);
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            System.out.println(e.getMessage());
        }
    }

    public String readMessageFrom(InputStream inputStream) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = bufferedReader.readLine().trim();
            bufferedReader.close();
            return line;
        } catch (IOException e) {
            logger.error("READ MESSAGE: " + e.getMessage());
        }

        return null;
    }

    public Message findMessageByID(Long id) {
        Message message = null;
        try {
            HibernateUtil.beginTransaction();
            message = findByID(Message.class, id);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            logger.error("FIND BY ID MESSAGE: " + ex.getMessage());
            HibernateUtil.rollbackTransaction();
        }
        return message;
    }

    public void deleteMessage(Message message) {
        logger.debug("deleteMessage");
        try {
            HibernateUtil.beginTransaction();
            delete(message);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            logger.error("DELETE MESSAGE: " + ex.getMessage());
            HibernateUtil.rollbackTransaction();
        }
    }

}