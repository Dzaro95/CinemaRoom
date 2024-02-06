package com.example.CinemaRoom.dto;

import java.util.List;

public record SeatsResponse(int rows, int column, List<SeatResponse> seats) {}
