package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reservation")

public class Reservation implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Reservation.class);

    @Column (name = "id_reservation", unique = true)
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (name = "id_hotel")
    @Id
    private Long id_hotel;

    @Column (name = "id_status")
    @Id
    private Long id_status;
    @Column (name = "id_dates")
    @Id
    private Long id_dates;

  //  @Column (name = "price")
   // private Long price;    id_cena

    public Reservation(Long id_hotel, Long id_status, Long id_dates, Long price) {
        this.id_hotel = id_hotel;
        this.id_status = id_status;
        this.id_dates = id_dates;
      //  this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Long getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(Long id_hotel) {
        this.id_hotel = id_hotel;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public Long getId_dates() {
        return id_dates;
    }

    public void setId_dates(Long id_dates) {
        this.id_dates = id_dates;
    }

//    public Long getPrice() {
//        return price;
//    }
//
//    public void setPrice(Long price) {
//        this.price = price;
//    }
}
