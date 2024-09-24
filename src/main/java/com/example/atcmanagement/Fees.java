package com.example.atcmanagement;

import jakarta.persistence.*;


@Entity
@Table(name = "fees")
public class Fees {
    @Id
    @Column(name = "idFees")
    private int id;

    @Column(name = "monthly_fee")
    private String monthlyFee;

    @Column(name = "connection_fee")
    private String connectionFee;

    @Column(name = "penalty_fee")
    private String penaltyFee;

    @Column(name = "intercity_fee")
    private String intercityFee;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(String monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getConnectionFee() {
        return connectionFee;
    }

    public void setConnectionFee(String connectionFee) {
        this.connectionFee = connectionFee;
    }

    public String getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(String penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public String getIntercityFee() {
        return intercityFee;
    }

    public void setIntercityFee(String intercityFee) {
        this.intercityFee = intercityFee;
    }
}
