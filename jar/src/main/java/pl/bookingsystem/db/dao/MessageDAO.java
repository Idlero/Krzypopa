package pl.bookingsystem.db.dao;

import pl.bookingsystem.db.entity.Message;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public interface MessageDAO extends GenericDAO<Message, Long> {

    public void readMessagesTo(PrintStream printStream);

    public List<Message> getMessages();

    public void putMessage(Message message);

    public String readMessageFrom(InputStream inputStream);

    public Message findMessageByID(Long id);

    public void deleteMessage(Message message);

}