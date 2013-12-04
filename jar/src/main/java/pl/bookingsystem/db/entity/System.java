package pl.bookingsystem.db.entity;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "system")
public class System implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(System.class);

    @Column (name = "id_systsemu", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "id_rezerwacji")
    @Id
    private Long id_rezerwacji;

    @Column (name = "id_clienta")
    @Id
    private Long id_clienta;

    public System(Long id_clienta, Long id_rezerwacji) {
        this.id_clienta = id_clienta;
        this.id_rezerwacji = id_rezerwacji;
    }

    public Long getId() {
        return id;
    }

    public Long getId_clienta() {
        return id_clienta;
    }

    public void setId_clienta(Long id_clienta) {
        this.id_clienta = id_clienta;
    }

    public Long getId_rezerwacji() {
        return id_rezerwacji;
    }

    public void setId_rezerwacji(Long id_rezerwacji) {
        this.id_rezerwacji = id_rezerwacji;
    }
}
