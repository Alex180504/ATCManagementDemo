package com.example.atcmanagement;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "debt")
public class Debt {
    @Id
    @Column(name = "debt_id")
    private int id;

    @Column(name = "notification_date")
    private Date notificationDate;

    @Column(name = "debt_amount")
    private String debtAmount;

    @Column(name = "intercity_debt_amount")
    private String intercityDebtAmount;

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

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(String debtAmount) {
        this.debtAmount = debtAmount;
    }

    public String getIntercityDebtAmount() {
        return intercityDebtAmount;
    }

    public void setIntercityDebtAmount(String intercityDebtAmount) {
        this.intercityDebtAmount = intercityDebtAmount;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
