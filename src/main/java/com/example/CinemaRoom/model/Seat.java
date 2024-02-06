package com.example.CinemaRoom.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "row_seat")
    private int row;

    @Column(name = "column_seat")
    private int column;

    @Column(name = "price_seat")
    private int price;
}
