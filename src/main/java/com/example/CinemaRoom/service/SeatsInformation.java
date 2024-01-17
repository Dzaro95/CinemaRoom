package com.example.CinemaRoom.service;


import com.example.CinemaRoom.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class SeatsInformation {
    @Id
    private long id;
    @Column(name = "rows")
    private final int ROWS = 9;
    @Column(name = "columns")
    private final int COLUMNS = 9;

    @OneToMany
    @JoinTable(name = "seat")
    private final List<Seat> SEATS;


    public SeatsInformation() {
        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= this.ROWS; row++) {
            for (int column = 1; column <= this.COLUMNS; column++) {
                seatList.add(new Seat(row, column, row <= 4 ? 10 : 8));
            }
        }
        this.SEATS = seatList;
    }
    /*
    public int priceResponse(int row) {

        return row <= 4 ? 10 : 8;
    }
*/
    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public List<Seat> getSEATS() {
        return SEATS;
    }



    public int numberOfSeats() {
        return ROWS * COLUMNS;
    }


}
