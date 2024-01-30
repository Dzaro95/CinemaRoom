package com.example.CinemaRoom.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    private int id = 1;
    private int income = 0;
    private int available;
    private int purchased = 0;
}
