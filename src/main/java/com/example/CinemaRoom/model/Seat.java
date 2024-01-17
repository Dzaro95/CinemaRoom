package com.example.CinemaRoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "seat")
public class Seat {
    @Column(name = "rowSeat")
    private int row;
    @Column(name = "columnSeat")
    private int column;
    @Column(name = "priceSeat")
    private int price;

}




