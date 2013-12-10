package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")

public class Employee implements Serializable{


    @Transient
    private static Logger logger = Logger.getLogger(Employee.class);

    @Column (name = "employee", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "first_name")
    private String first_name;

    @Column (name = "last_name")
    private String last_name;

    @Column (name = "id_hotel")
    @Id
    private Long id_hotel;

    @Column (name = "status")
    private Long status;

    public Employee(String first_name, String last_name, Long id_hotel, Long status) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id_hotel = id_hotel;
        this.status = status;
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

    public Long getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Long id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
