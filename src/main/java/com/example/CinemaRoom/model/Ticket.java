package com.example.CinemaRoom.model;

import com.example.CinemaRoom.dto.SeatResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "token")
    String token;
    @Column(name = "seat")
    int seat;

    public Ticket(String token, int seat) {
        this.token = token;
        this.seat = seat;
    }
}
