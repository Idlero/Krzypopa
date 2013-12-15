package pl.bookingsystem.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: thx-
 * Date: 12.12.13
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table ( name= "user")

public class User implements Serializable {

    @Column (name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "first_name")
    private String first_name;

    @Column (name = "last_name")
    private String last_name;

    @Column (name = "pesel")
    private Long pesel;

    @Column (name = "nip")
    private Long nip;

    @Column (name = "email")
    private String email;

    @Column (name = "phone_number")
    private String phone_number;

    @Column (name = "password")
    private String password;

    @Column (name = "type")
    private String type;

    @ManyToMany (mappedBy = "users")
    private Set<Hotel> hotels = new HashSet<Hotel>();

    @OneToOne (mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;


    public User(String first_name, String last_name, Long pesel, Long nip, String email, String phone_number, String password, String type, Set<Hotel> hotels) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.pesel = pesel;
        this.nip = nip;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.type = type;
        this.hotels = hotels;
    }

    public User(String first_name, String last_name, String email, String password, String type, Set<Hotel> hotels) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.type = type;
        this.hotels = hotels;
    }

    public User() {
    }

    public Long getId() {
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

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public Long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }
}
