package pl.bookingsystem.db.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Column(name = "id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private Timestamp birthdate;

    @Column(name = "sex")
    private String sex;


    public Person() {
    }

    public Person(String surname, String name, Timestamp birthdate, String sex) {
        this.surname = surname;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
    }


    @Override
    public String toString() {
        return this.id + ") " + this.name + " " + this.surname + ", " + this.birthdate + ", " + this.sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
