package com.example.CinemaRoom.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
public record Statistics(int income, int available,int purchased) {
    public Statistics(int available) {
        this(0,available,0);
    }
}
/*
public class Statistics {
    private int income;
    private int available;
    private int purchased;

    public Statistics(int available) {
        this.available = available;
        this.income = 0;
        this.purchased = 0;
    }

    public Statistics(int income, int available, int purchased) {
        this.income = income;
        this.available = available;
        this.purchased = purchased;
    }

    public int getIncome() {
        return income;
    }

    public int getAvailable() {
        return available;
    }

    public int getPurchased() {
        return purchased;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    public void setAvailable(int available) {
        this.available = available;
    }
    public void setPurchased(int purchased) {
        this.purchased = purchased;
    }
}

 */

