package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "room")

public class Room implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Room.class);

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

    @Column (name = "id_hotel")
    @Id
    private Long id_hotel;

 //   @ManyToOne(targetEntity = Addition.class, cascade)
    private List<Addition> additions;

    public Room() {
    }

    public Room(Long no_room, String name, String bed, Long capacity, Long id_hotel) {
        this.no_room = no_room;
        this.name = name;
        this.bed = bed;
        this.capacity = capacity;
        this.id_hotel = id_hotel;

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

    public Long getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Long id_hotel) {
        this.id_hotel = id_hotel;
    }


}
