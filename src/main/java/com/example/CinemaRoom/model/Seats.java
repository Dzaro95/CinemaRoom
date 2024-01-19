package com.example.CinemaRoom.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seats {
    @Id
    @Column(name = "rows_seats")
    private final int ROWS = 9;
    @Column(name = "columns_seats")
    private final int COLUMNS = 9;
    @ManyToMany(
            mappedBy = "seats",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<Seat> SEATS = seatList();


    public List<Seat> seatList() {

        List<Seat> seatList = new ArrayList<>();
        for (int row = 1; row <= this.ROWS; row++) {
            for (int column = 1; column <= this.COLUMNS; column++) {
                Seat seat = new Seat();
                seat.setRow(row);
                seat.setColumn(column);
                seat.setPrice(row <= 4 ? 10 : 8);
                seatList.add(seat);
            }
        }
        return seatList;
    }
}