package com.example.CinemaRoom.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seats {

    @Id
    @Column(name = "seats_id")
    int id = 1;
    @Column(name = "rows_seats")
    private final int ROWS = 9;
    @Column(name = "columns_seats")
    private final int COLUMNS = 9;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seats", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> SEATS;
}
