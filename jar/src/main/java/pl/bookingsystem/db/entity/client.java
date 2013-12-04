package pl.bookingsystem.db.entity;



import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name= "client" )
public class Client implements Serializable
{

    @Transient
    private static Logger logger = Logger.getLogger(Client.class);

    @Column (name = "id_clients", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name  = "imie")
    private String imie;

    @Column (name = "nazwisko")
    private String nazwisko;

    @Column (name = "adres")
    private String adres;

    @Column (name = "PESEL")
    private Integer pesel;

    @Column (name = "NIP")
    private Integer nip;

    @Column (name = "email")
    private String emaail;

    @Column (name = "telefon")
    private Integer tel;

    @Column (name = "haslo")
    private String password;

    public Client(String imie, String nazwisko, String emaail, String password) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.emaail = emaail;
        this.password = password;
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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public Integer getNip() {
        return nip;
    }

    public void setNip(Integer nip) {
        this.nip = nip;
    }

    public String getEmaail() {
        return emaail;
    }

    public void setEmaail(String emaail) {
        this.emaail = emaail;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
