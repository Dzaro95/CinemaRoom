package com.example.CinemaRoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "seats")
public class Seats {

    @Column(name = "rows")
    private int rows;
    @Column(name = "columns")
    private int columns;

    private Seat seats;

}
