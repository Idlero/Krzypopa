package pl.bookingsystem.action;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.*;
import pl.bookingsystem.db.dao.ClientDAO;
import pl.bookingsystem.db.dao.impl.ClientDAOImpl;
import pl.bookingsystem.db.entity.Client;

import java.util.List;

@UrlBinding("/add")
public class AddClientActionBean implements ActionBean {

    private static final String SAVE_EVENT = "save";

    private ClientDAO clientDAO = new ClientDAOImpl();

    private static int counter;

    @ValidateNestedProperties({
            @Validate(field = "text", on = SAVE_EVENT, required = true, minlength = 5, maxlength = 255)
    })
    private pl.bookingsystem.db.entity.Client client;

    private ActionBeanContext context;

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    public pl.bookingsystem.db.entity.Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = (Client) client;
    }

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution("/WEB-INF/pages/addClient.jsp");
    }

    @HandlesEvent(SAVE_EVENT)
    public Resolution save() {
        clientDAO.save(client);
        return new ForwardResolution(ListClientsActionBean.class);
    }

    @HandlesEvent("edit")
    public Resolution edit() {
        client = clientDAO.findByClientName(client.getFirst_name(), client.getLast_name());
        return new ForwardResolution("WEB-INF/pages/addClient.jsp");
    }

    @HandlesEvent("delete")
    public Resolution delete() {
        clientDAO.delete(client);
        return new ForwardResolution(ListClientsActionBean.class);
    }

    @ValidationMethod(on = "save")
    public void validateSave(ValidationErrors errors) {
        List<Client> clients = clientDAO.selectAll(Client.class);
        if (client.getId() == 0) {
            for (Client client : clients) {
                if (this.client.getPesel().equals(client.getPesel())) {
                    errors.add("client.info", new LocalizableError("client.err.add"));
                    getContext().setValidationErrors(errors);
                }
            }
        }
    }

}