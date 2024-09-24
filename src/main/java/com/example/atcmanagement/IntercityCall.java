package com.example.atcmanagement;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Date;


@Entity
@Table(name = "intercity_call")
public class IntercityCall {
    @Id
    @Column(name = "idcall")
    private int id;

    @Column(name = "duration")
    private Time duration;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "subscriber_subscriber_id", referencedColumnName = "subscriber_id"),
            @JoinColumn(name = "subscriber_atc_idatc", referencedColumnName = "atc_idatc")
    })
    private Subscriber subscriber;

    @Column(name = "date")
    private Date date;

    @Column(name = "city")
    private String city;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
