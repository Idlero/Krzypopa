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

    @Column (name = "id_clienta", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name  = "imie")
    private String name;

    @Column (name = "nazwisko")
    private String nazwisko;

    @Column (name = "adres",nullable = true)
    private String adres;

    @Column (name = "PESEL",nullable = true)
    private Integer pesel;

    @Column (name = "NIP",nullable = true)
    private Integer nip;

    @Column (name = "email")
    private String email;

    @Column (name = "telefon",nullable = true)
    private Integer tel;

    @Column (name = "haslo")
    private String password;

    public Client(String name, String nazwisko, String email, String password) {
        this.name = name;
        this.nazwisko = nazwisko;
        this.email = email;
        this.password = password;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setId(int id) {
        this.id = id;
    }
}
