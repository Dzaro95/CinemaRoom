package com.example.CinemaRoom.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seats {
    @Id
    private long id;
    @Column(name = "rows")
    private final int ROWS = 9;
    @Column(name = "columns")
    private final int COLUMNS = 9;

    @OneToMany
    @JoinColumn(name = "seat_id")
    private final List<Seat> SEATS;


    public Seats() {
        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= this.ROWS; row++) {
            for (int column = 1; column <= this.COLUMNS; column++) {
                seatList.add(new Seat(row,row, column, row <= 4 ? 10 : 8));
            }
        }
        this.SEATS = seatList;
    }
    public int numberOfSeats() {
        return ROWS * COLUMNS;
    }


}
