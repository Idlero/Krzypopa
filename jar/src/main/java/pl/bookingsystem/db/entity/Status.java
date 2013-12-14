package pl.bookingsystem.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status implements Serializable {


    @Column(name = "id", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name ="name")
    private String name;

    @Column (name = "description")
    private String description;

    @OneToMany(mappedBy = "status")
    private Set<Reservation> reservations = new HashSet<Reservation>();

    public Status(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Status(String name, String description, Set<Reservation> reservations) {
        this.name = name;
        this.description = description;
        this.reservations = reservations;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
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

}
