package com.example.CinemaRoom.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Statistics {

    private int income = 0;
    private int available;
    private int purchased = 0;
}
