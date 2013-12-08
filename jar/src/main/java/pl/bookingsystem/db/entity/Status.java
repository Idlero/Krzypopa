package pl.bookingsystem.db.entity;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Status.class);

    @Column(name = "id_statusu", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name ="nazwa")
    private String nazwa;

    @Column (name = "opis")
    private String opis;

    @Column (name = "kolor", unique = true)
    private Integer kolor;

    public Status(String nazwa, String opis, Integer kolor) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.kolor = kolor;
    }

    public Status() {
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getKolor() {
        return kolor;
    }

    public void setKolor(Integer kolor) {
        this.kolor = kolor;
    }
}
