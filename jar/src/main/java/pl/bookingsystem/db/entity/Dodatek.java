package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dodatek")

public class Dodatek implements Serializable {

    @Column(name ="id_dodatku" unique = true)
    @Id
    @GeneratedValue
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

