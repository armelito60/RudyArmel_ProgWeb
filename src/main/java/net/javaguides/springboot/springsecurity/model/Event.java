package net.javaguides.springboot.springsecurity.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity

@Table(name = "event")

public class Event {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;
    private String participant;
    private String lieu;

    public Event() {}

    public Event(Date date, String participant, String lieu) {
        this.date = date;
        this.participant = participant;
        this.lieu = lieu;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getParticipant() {
        return participant;
    }

    public String getLieu() {
        return lieu;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
