package pl.bookingsystem.db.entity;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {


    @Column (name = "id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "phone_number")
    private String phone_number;

    @Column (name = "email")
    private String email;

    @OneToOne (mappedBy = "hotel", cascade = CascadeType.ALL)
    private Address address;

    @ManyToMany (fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "client_hotel",
               joinColumns = {@JoinColumn(name = "Hotelid")},
               inverseJoinColumns = {@JoinColumn (name = "Clientid")}
               )
    private Set<Client> client_id = new HashSet<Client>();

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name = "hotel_user",
                joinColumns = {@JoinColumn (name = "Hotelid")},
                inverseJoinColumns = {@JoinColumn (name = "Userid")})
    private Set<User> users = new HashSet<User>();

    @OneToMany  (mappedBy = "rooms")
    private Set<Room> rooms;


    public Hotel(String name, String description, String phone_number, String email) {
        this.name = name;
        this.description = description;
        this.phone_number = phone_number;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone_numnber() {
        return phone_number;
    }

    public void setPhone_numnber(String phone_numnber) {
        this.phone_number = phone_numnber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /*    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/
}
