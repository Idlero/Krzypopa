package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Hotel.class);

    @Column (name = "id_hotelu", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "nazwa")
    private String nazwa;

    @Column (name = "adres")
    private String adres;

    public Hotel() {
    }

    public Hotel(String nazwa, String adres) {
        this.nazwa = nazwa;
        this.adres = adres;
    }

    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
