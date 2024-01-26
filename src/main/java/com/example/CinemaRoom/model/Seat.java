package com.example.CinemaRoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "seats_place")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="seats_id", nullable = false)
    private Seats seats;

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }
}
