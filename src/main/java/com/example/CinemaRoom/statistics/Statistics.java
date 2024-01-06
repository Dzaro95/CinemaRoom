package com.example.CinemaRoom.statistics;


public class Statistics {
    private int income;
    private int available;
    private int purchased;

    public Statistics(int available) {
        this.available = available;
        this.income = 0;
        this.purchased = 0;
    }
    public int getIncome() {
        return income;
    }
    public void addSoldTicket(int income) {
        this.income += income;
        this.available -= 1;
        this.purchased += 1;
    }
    public void returnTicket(int income) {
        this.income -= income;
        available += 1;
        this.purchased -= 1;
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

