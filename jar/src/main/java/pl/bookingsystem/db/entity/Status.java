package pl.bookingsystem.db.entity;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "status")
public class Status implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Status.class);

    @Column(name = "id_status", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name ="name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "color", unique = true)
    private String color;

    public Status(String name, String description, String color) {
        this.name = name;
        this.description = description;
        this.color = color;    
    }

    public Status() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
