package com.example.CinemaRoom.dto;

import com.example.CinemaRoom.model.Seat;
import java.util.List;

public record SeatsResponse(int rows, int columns, List<Seat> seat) {}

