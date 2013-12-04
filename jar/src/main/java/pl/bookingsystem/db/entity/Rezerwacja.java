package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rezerwacja")

public class Rezerwacja implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Rezerwacja.class);

    @Column (name = "id_rezerwacji", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "id_hotelu")
    @Id
    private Long id_hotelu;

    @Column (name = "id_status");
    @Id
    private Long id_status;

    @Column (name = "id_terminu");
    @Id
    private Long id_terminu;

    @Column (name = "cena")
    private Integer cena;

    public Rezerwacja(Long id_hotelu, Long id_status, Long id_terminu, Integer cena) {
        this.id_hotelu = id_hotelu;
        this.id_status = id_status;
        this.id_terminu = id_terminu;
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public Long getId_hotelu() {
        return id_hotelu;
    }

    public void setId_hotelu(Long id_hotelu) {
        this.id_hotelu = id_hotelu;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public Long getId_terminu() {
        return id_terminu;
    }

    public void setId_terminu(Long id_terminu) {
        this.id_terminu = id_terminu;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }
}
