package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokoje")

public class Pokoje implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Pokoje.class);

    @Column (name = "id_pokoj", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column (name = "nr_pokoju")
    private Integer nr_pokouj;

    @Column (name = "nazwa", unique = true)
    private String nazwa;

    @Column (name = "lozko")
    private String lozko;

    @Column (name = "pojemnosc")
    private Integer pojemnosc;

    @Column (name = "id_hotelu")
    @Id
    private Long id_hotelu;

    public Pokoje() {
    }

    public Pokoje(Integer nr_pokouj, String nazwa, String lozko, Integer pojemnosc, Long id_hotelu) {
        this.nr_pokouj = nr_pokouj;
        this.nazwa = nazwa;
        this.lozko = lozko;
        this.pojemnosc = pojemnosc;
        this.id_hotelu = id_hotelu;

    }

    public Long getId() {
        return id;
    }

    public Integer getNr_pokouj() {
        return nr_pokouj;
    }

    public void setNr_pokouj(Integer nr_pokouj) {
        this.nr_pokouj = nr_pokouj;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLozko() {
        return lozko;
    }

    public void setLozko(String lozko) {
        this.lozko = lozko;
    }

    public Integer getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(Integer pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public Long getId_hotelu() {
        return id_hotelu;
    }

    public void setId_hotelu(Long id_hotelu) {
        this.id_hotelu = id_hotelu;
    }


}
