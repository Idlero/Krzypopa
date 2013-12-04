package pl.bookingsystem.action;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.*;
import pl.bookingsystem.db.dao.MessageDAO;
import pl.bookingsystem.db.dao.impl.MessageDAOImpl;

import java.util.List;

@UrlBinding("/addMessage.action")
public class AddMessageActionBean implements ActionBean {

    private static final String SAVE_EVENT = "save";

    private MessageDAO messageDAO = new MessageDAOImpl();

    private static int counter;

    @ValidateNestedProperties({
            @Validate(field = "text", on = SAVE_EVENT, required = true, minlength = 5, maxlength = 255)
    })
    private pl.bookingsystem.db.entity.Message message;

    private ActionBeanContext context;

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    public pl.bookingsystem.db.entity.Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = (pl.bookingsystem.db.entity.Message) message;
    }

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/WEB-INF/jsp/addMessage.jsp");
    }

    @HandlesEvent(SAVE_EVENT)
    public Resolution save() {
        messageDAO.putMessage(message);
        return new ForwardResolution(ListMessagesActionBean.class);
    }

    @HandlesEvent("edit")
    public Resolution edit() {
        message = messageDAO.findMessageByID(message.getId());
        return new ForwardResolution("/jsp/addMessage.jsp");
    }

    @HandlesEvent("delete")
    public Resolution delete() {
        messageDAO.deleteMessage(message);
        return new ForwardResolution(ListMessagesActionBean.class);
    }

    @ValidationMethod(on = "save")
    public void validateSave(ValidationErrors errors) {
        List<pl.bookingsystem.db.entity.Message> messages = messageDAO.getMessages();
        if (message.getId() == 0) {
            for (pl.bookingsystem.db.entity.Message m : messages) {
                if (message.getText().equals(m.getText())) {
                    errors.add("message.text", new LocalizableError("er.message.text"));
                    getContext().setValidationErrors(errors);
                }
            }
        }
    }

}