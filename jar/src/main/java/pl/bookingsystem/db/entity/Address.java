package pl.bookingsystem.db.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: thx-
 * Date: 12.12.13
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table (name ="address")

public class Address implements Serializable {

    @Column (name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "city")
    private  String city;

    @Column (name = "street")
    private String street;

    @Column (name = "building_no")
    private Long building_no;

    @Column (name = "apartment_no")
    private Long apartment_no;

    @Column (name = "postcode")
    private Long poscode;

    @Column(name = "country")
    private String country;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Client client;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Hotel hotel;

    public Address(String city, String street, Long building_no, Long poscode, String country) {
        this.city = city;
        this.street = street;
        this.building_no = building_no;
        this.poscode = poscode;
        this.country = country;
    }

    public Address(String city, String street, Long building_no, Long poscode, String country, User user) {
        this.city = city;
        this.street = street;
        this.building_no = building_no;
        this.poscode = poscode;
        this.country = country;
        this.user = user;
    }

    public Address(String city, String street, Long building_no, Long poscode, String country, Client client) {
        this.city = city;
        this.street = street;
        this.building_no = building_no;
        this.poscode = poscode;
        this.country = country;
        this.client = client;
    }

    public Address(String city, String street, Long building_no, Long poscode, String country, Hotel hotel) {
        this.city = city;
        this.street = street;
        this.building_no = building_no;
        this.poscode = poscode;
        this.country = country;
        this.hotel = hotel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getBuilding_no() {
        return building_no;
    }

    public void setBuilding_no(Long building_no) {
        this.building_no = building_no;
    }

    public Long getApartment_no() {
        return apartment_no;
    }

    public void setApartment_no(Long apartment_no) {
        this.apartment_no = apartment_no;
    }

    public Long getPoscode() {
        return poscode;
    }

    public void setPoscode(Long poscode) {
        this.poscode = poscode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
