package pl.bookingsystem.db.dao;

import pl.bookingsystem.db.entity.Client;

import java.io.PrintStream;
import java.util.List;

public interface ClientDAO extends GenericDAO<Client, Integer> {

    public Client findByClientName(String name, String surname);


}