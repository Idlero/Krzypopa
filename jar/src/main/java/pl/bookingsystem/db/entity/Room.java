package pl.bookingsystem.db.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")

public class Room implements Serializable {


    @Column (name = "id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column (name = "room_no")
    private Long room_no;

    @Column (name = "name", unique = true)
    private String name;

    @Column (name = "bed")
    private String bed;

    @Column (name = "capacity")
    private Long capacity;

    @ManyToOne
    @JoinColumn (name = "Hotelid")
    private Hotel hotel;

    @OneToMany(mappedBy = "room")
    private Set<Addition> additions;

    @ManyToMany (mappedBy = "rooms")
    private Set<Reservation> reservations = new HashSet<Reservation>();

    public Room(Long room_no, String name, String bed, Long capacity, Hotel hotel) { //Tworzenie nowego pokoju
        this.room_no = room_no;
        this.name = name;
        this.bed = bed;
        this.capacity = capacity;
        this.hotel = hotel;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public Long getRoom_no() {
        return room_no;
    }

    public void setRoom_no(Long room_no) {
        this.room_no = room_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Addition> getAdditions() {
        return additions;
    }

    public void setAdditions(Set<Addition> additions) {
        this.additions = additions;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations.add(reservations);
    }
    public void setAdditions(Addition additions) {
        this.additions.add(additions);
    }

}

