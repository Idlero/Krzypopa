package pl.bookingsystem.db.entity;



import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name= "client")
public class Client
{

    @Transient
    private static Logger logger = Logger.getLogger(Client.class);

}
