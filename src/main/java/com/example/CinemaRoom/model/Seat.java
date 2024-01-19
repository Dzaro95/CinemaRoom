package com.example.CinemaRoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats_place")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "row_seat")
    private int row;
    private int column;
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "rows_seats")
    private Seats seats;

}




