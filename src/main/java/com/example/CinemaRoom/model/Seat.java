package com.example.CinemaRoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seat")
public class Seat {

    @Column(name = "row")
    /*
    private long id;
    @Column(name = "row")

     */
    private int row;
    @Column(name = "column")
    private int column;
    @Column(name = "price")
    private int price;

}




