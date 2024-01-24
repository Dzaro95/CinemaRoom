package com.example.CinemaRoom.dto;

import java.util.List;

public record SeatsDTO(int rows, int column, List<SeatDTO> seats) {}
