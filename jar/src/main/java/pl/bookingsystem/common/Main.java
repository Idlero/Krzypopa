package pl.bookingsystem.common;

import pl.bookingsystem.db.dao.ClientDAO;
import pl.bookingsystem.db.dao.impl.ClientDAOImpl;
import pl.bookingsystem.db.entity.Client;

import java.util.List;


public class Main {

	public static void main(String[] args) {
        ClientDAO dao = new ClientDAOImpl();
		
		// Read
		System.out.println("******* READ *******");
		List clients = dao.selectAll(Client.class);
		System.out.println("Total Clients: " + clients.size());
		
		
		// Write
		System.out.println("******* WRITE *******");
        Client client = new Client("Chuck", "Norris", "chuckzajebisty@gmail.com", "chucknorris");
        Client someone = new Client("Zenek","Breszka", "ul.Podmiejska", (long) (int) 910728012, (long) (int) 1231231231,"zenk@breszka.com",(long) (int) 500600500, "Acocieto1");
        dao.save(someone);
        //Integer  clientID = (int) (long) client.getId();
        client = dao.save(client);
		client = dao.selectByID(Client.class, client.getId());
		System.out.printf("%d %s %s \n", client.getId(), client.getFirst_name(), client.getLast_name());

		
		// Update
		System.out.println("******* UPDATE *******");
		Client client2 = dao.selectByID(Client.class, (long) 1); // read client with id 1
		System.out.println("Name Before Update:" + client2.getFirst_name());
		client2.setFirst_name("James");
		dao.merge(client2);	// save the updated client details
		
		client2 = dao.selectByID(Client.class, (long) 1); // read again client with id 1
		System.out.println("Name Aftere Update:" + client2.getFirst_name());
		
		
		// Delete
		System.out.println("******* DELETE *******");
        Client client3 = dao.selectByID(Client.class, client.getId());
        System.out.println("Object:" + client3);
		dao.delete(client);
		client3 = dao.selectByID(Client.class,  client.getId());
		System.out.println("Object:" + client3);
	}
}
