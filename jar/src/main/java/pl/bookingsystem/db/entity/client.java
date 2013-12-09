package pl.bookingsystem.db.entity;



import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name= "client" )
public class Client implements Serializable
{

    @Transient
    private static Logger logger = Logger.getLogger(Client.class);

    @Column (name = "id_client", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column (name  = "first_name")
    private String first_name;

    @Column (name = "last_name")
    private String last_name;

    @Column (name = "address",nullable = true)
    private String address;

    @Column (name = "PESEL",nullable = true)
    private Integer pesel;

    @Column (name = "NIP",nullable = true)
    private Integer nip;

    @Column (name = "email")
    private String email;
  
    @Column (name = "phone",nullable = true)
    private Integer phone;

    @Column (name = "password")
    private String password;

    public Client(String first_name, String last_name, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getphone() {
        return phone;
    }

    public void setphone(Integer   phone) {
        this.  phone =   phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
