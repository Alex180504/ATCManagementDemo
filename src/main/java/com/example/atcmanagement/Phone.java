package com.example.atcmanagement;

import jakarta.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @Column(name = "phone_id")
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "phone_type")
    private String phoneType;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "subscriber_subscriber_id", referencedColumnName = "subscriber_id"),
            @JoinColumn(name = "subscriber_atc_idatc", referencedColumnName = "atc_idatc")
    })
    private Subscriber subscriber;

    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address adress;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
