package com.example.CinemaRoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rows")
    private int rows;
    @Column(name = "columns")
    private int columns;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "row")
    private Seat seats;

}
