package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "room")

public class Rooms implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Rooms.class);

    @Column (name = "id_room", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    @Column (name = "no_room")
    private Integer no_room;

    @Column (name = "name", unique = true)
    private String name;

    @Column (name = "bed")
    private String bed;

    @Column (name = "capacity")
    private Integer capacity;

    @Column (name = "id_hotel")
    @Id
    private Long id_hotel;

    public Rooms() {
    }

    public Rooms(Integer no_room, String name, String bed, Integer capacity, Long id_hotel) {
        this.no_room = no_room;
        this.name = name;
        this.bed = bed;
        this.capacity = capacity;
        this.id_hotel = id_hotel;

    }

    public Long getId() {
        return id;
    }

    public Integer getNo_room() {
        return no_room;
    }

    public void setNo_room(Integer no_room) {
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Long getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Long id_hotel) {
        this.id_hotel = id_hotel;
    }


}
