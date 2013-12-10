package pl.bookingsystem.db.entity;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "system")
public class System implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(System.class);

    @Column (name = "id_system", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "id_reservation")
    @Id
    private Long id_reservation;

    @Column (name = "id_client")
    @Id
    private Long id_client;

    public System(Long id_client, Long id_reservation) {
        this.id_client = id_client;
        this.id_reservation = id_reservation;                           
    }

    public Long getId() {
        return id;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }
}
