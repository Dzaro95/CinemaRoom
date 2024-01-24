package com.example.CinemaRoom.model;

import lombok.*;
import javax.persistence.*;
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
    private List<Seat> SEATS;
}
