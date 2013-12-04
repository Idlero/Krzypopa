package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dodatek")

public class Dodatek implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Dodatek.class);

    @Column(name ="id_dodatku" unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "nazwa")
    private String nazwa;

    @Column (name = "opis")
    private String opis;

    @Column (name = "satatus")
    private int status;

    public Dodatek (){

    }

    public Dodatek(String nazwa, String opis, int status) {

        this.nazwa = nazwa;
        this.opis = opis;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}

