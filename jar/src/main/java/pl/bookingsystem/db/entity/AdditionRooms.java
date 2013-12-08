package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addition_rooms")

public class AdditionRooms implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(AdditionRooms.class);

    @Column (name = "id_ar", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (name = "id_room")
    @Id
    private Long id_room;

    @Column (name = "id_addition")
    @Id
    private Long id_addition;

    public AdditionRooms(Long id_room, Long id_addition) {
        this.id_room = id_room;
        this.id_addition = id_addition;
    }

    public Long getId() {
        return id;
    }

    public Long getId_room() {
        return id_room;
    }

    public void setId_room(Long id_room) {
        this.id_room = id_room;
    }

    public Long getId_addition() {
        return id_addition;
    }

    public void setId_addition(Long id_addition) {
        this.id_addition = id_addition;
    }
}
