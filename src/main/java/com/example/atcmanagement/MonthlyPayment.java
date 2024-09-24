package com.example.atcmanagement;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "monthly_payment")
public class MonthlyPayment {
    @Id
    @Column(name = "payment_id")
    private int id;

    @Column(name = "amount")
    private String amount;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "subscriber_subscriber_id", referencedColumnName = "subscriber_id"),
            @JoinColumn(name = "subscriber_atc_idatc", referencedColumnName = "atc_idatc")
    })
    private Subscriber subscriber;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
