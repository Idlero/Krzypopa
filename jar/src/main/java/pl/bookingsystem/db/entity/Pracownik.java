package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pracownik")

public class Pracownik implements Serializable{


    @Transient
    private static Logger logger = Logger.getLogger(Pracownik.class);

    @Column (name = "id_pracownika", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "imie")
    private String imie;

    @Column (name = "nazwisko")
    private String nazwisko;

    @Column (name = "id_hotelu")
    @Id
    private Long id_hotelu;

    @Column (name = "status")
    private Integer status;

    public Pracownik(String imie, String nazwisko, Long id_hotelu, Integer status) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id_hotelu = id_hotelu;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Long getId_hotelu() {
        return id_hotelu;
    }

    public void setId_hotelu(Long id_hotelu) {
        this.id_hotelu = id_hotelu;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
