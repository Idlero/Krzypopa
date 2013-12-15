package pl.bookingsystem.db.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")

public class Reservation implements Serializable {


    @Column (name = "id", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "date_from")
    private Date date_from;

    @Column (name = "date_to")
    private Date date_to;

    @Column (name = "person_count")
    private Integer person_count;

    @Column (name = "date_edit")
    private Date date_edit;



    @ManyToOne
    @JoinColumn (name = "Clientid")
    private Client client;

    @ManyToOne
    @JoinColumn (name = "Statusid")
    private Status status;


    @ManyToMany (cascade = {CascadeType.ALL})
    @JoinTable(name = "room_reservation",
                joinColumns={@JoinColumn (name = "Reservationid", nullable = false)},
                inverseJoinColumns = {@JoinColumn (name = "Roomid")})
    private Set<Room> rooms = new HashSet<Room>();


   private Status defaultStatus =new Status("Rezerwacja", "Rezerwacja bez potwierdzenia czy zaplaty");

   public Reservation(String name, Date date_from, Date date_to, Integer person_count, Date date_edit, Client client, Status status) {
        this.name = name;
        this.date_from = date_from;
        this.date_to = date_to;
        this.person_count = person_count;
        this.date_edit = date_edit;
        this.client = client;
        this.status = status;
    }

    public Reservation(String name, Date date_from, Date date_to, Integer person_count, Date date_edit, Client client) {
        this.name = name;
        this.date_from = date_from;
        this.date_to = date_to;
        this.person_count = person_count;
        this.date_edit = date_edit;
        this.client = client;
        this.status = defaultStatus;
    }

    public Reservation() {
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

    public Date getDate_from() {
        return date_from;
    }

    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    public Date getDate_to() {
        return date_to;
    }

    public void setData_to(Date date_to) {
        this.date_to = date_to;
    }

    public Integer getPerson_count() {
        return person_count;
    }

    public void setPerson_count(Integer person_count) {
        this.person_count = person_count;
    }

    public Date getDate_edit() {
        return date_edit;
    }

    public void setDate_edit(Date date_edit) {
        this.date_edit = date_edit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

