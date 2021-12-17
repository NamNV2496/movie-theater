package com.movie.theater.model.response;

import lombok.Data;

@Data
public class SeatResponse {
    private int seatId;
    private int cinemaRoomId;
    private String seatColumn;
    private int seatRow;
    private int seatStatus;
    private int seatType;
}
