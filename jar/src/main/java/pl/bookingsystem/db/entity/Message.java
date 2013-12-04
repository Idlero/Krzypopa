package pl.bookingsystem.db.entity;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Transient
    private static Logger logger = Logger.getLogger(Message.class);

    @Column(name = "MESSAGE_ID", unique = true)
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "MESSAGE_TEXT", unique = true)
    private String text;


    public Message() {
    }

    public Message(String text) {
        this.text = text;
        logger.debug("New Message: " + text);
    }

    public Long getId() {
        logger.debug("Message ID: " + id);
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
