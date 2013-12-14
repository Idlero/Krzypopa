package pl.bookingsystem.action;

import net.sourceforge.stripes.action.*;
import pl.bookingsystem.db.dao.ClientDAO;
import pl.bookingsystem.db.dao.impl.ClientDAOImpl;

import java.util.ArrayList;
import java.util.List;

@UrlBinding("/list")
public class ListClientsActionBean extends BaseActionBean {

    public List<Client> clients = new ArrayList<Client>();

    private ClientDAO clientDAO = new ClientDAOImpl();

    @DefaultHandler
    public Resolution getListClients() {
        clients = getClients();
        return new ForwardResolution("WEB-INF/pages/listClients.jsp");
    }

    @HandlesEvent("addClient")
    public Resolution addClient() {
        return new ForwardResolution(AddClientActionBean.class);
    }

    public List getClients() {
        return clientDAO.selectAll(Client.class);
    }

    public void setClients(List<Client> clients) {
        this.clients = clientDAO.selectAll(Client.class);
    }

}