package project.springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity

@Table(name = "event")

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String participant;
    private String lieu;
    private String creator;

    public Event() {}

    public Event(String date, String participant, String lieu, String creator) {
        this.date = date;
        this.participant = participant;
        this.lieu = lieu;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getParticipant() {
        return participant;
    }

    public String getLieu() {
        return lieu;
    }

    public String getCreator() { return creator; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) { this.date = date; }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setCreator(String creator) { this.creator = creator; }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", participant='" + participant + '\'' +
                ", lieu='" + lieu + '\'' +
                ", createur='" + creator + '\'' +
                '}';
    }
}
