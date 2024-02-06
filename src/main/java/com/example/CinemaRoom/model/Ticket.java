package com.example.CinemaRoom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "token")
    String token;

    @OneToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;
}
