package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dodatki")

public class Dodatki implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Dodatki.class);

    @Column (name = "id_dodatkow", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "id_pokoj")
    @Id
    private Long id_pokoj;

    @Column (name = "id_dodatku")
    @Id
    private Long id_dodatku;

    public Dodatki(Long id_pokoj, Long id_dodatku) {
        this.id_pokoj = id_pokoj;
        this.id_dodatku = id_dodatku;
    }

    public Long getId() {
        return id;
    }

    public Long getId_pokoj() {
        return id_pokoj;
    }

    public void setId_pokoj(Long id_pokoj) {
        this.id_pokoj = id_pokoj;
    }

    public Long getId_dodatku() {
        return id_dodatku;
    }

    public void setId_dodatku(Long id_dodatku) {
        this.id_dodatku = id_dodatku;
    }
}
