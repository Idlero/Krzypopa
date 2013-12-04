package pl.bookingsystem.action;

import net.sourceforge.stripes.action.*;
import pl.bookingsystem.db.dao.MessageDAO;
import pl.bookingsystem.db.dao.impl.MessageDAOImpl;
import pl.bookingsystem.db.entity.Message;

import java.util.LinkedList;
import java.util.List;

@UrlBinding("/listMessages.action")
public class ListMessagesActionBean extends MessageDAOImpl implements ActionBean {

    public static List<Message> messages = new LinkedList<Message>();

    private MessageDAO messageDAO = new MessageDAOImpl();
    private ActionBeanContext context;

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    @DefaultHandler
    public Resolution getListMessages() {
        return new ForwardResolution("/jsp/listMessages.jsp");
    }

    @HandlesEvent("addMessage")
    public Resolution addMessage() {
        return new ForwardResolution(AddMessageActionBean.class);
    }

    public List getMessages() {
        return messageDAO.getMessages();
    }

    public void setMessages(List<Message> messages) {
        ListMessagesActionBean.messages = messages;
    }

}