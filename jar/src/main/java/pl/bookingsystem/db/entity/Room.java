package pl.bookingsystem.db.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")

public class Room implements Serializable {


    @Column (name = "id_room", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column (name = "no_room")
    private Long no_room;

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

    public Room(Long no_room, String name, String bed, Long capacity, Hotel hotel) { //Tworzenie nowego pokoju
        this.no_room = no_room;
        this.name = name;
        this.bed = bed;
        this.capacity = capacity;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public Long getNo_room() {
        return no_room;
    }

    public void setNo_room(Long no_room) {
        this.no_room = no_room;
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

