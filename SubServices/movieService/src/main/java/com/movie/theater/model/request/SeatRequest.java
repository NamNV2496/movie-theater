package com.movie.theater.model.request;

import lombok.Data;

@Data
public class SeatRequest {
    private int seatId;
    private int cinemaRoomId;
    private String seatColumn;
    private int seatRow;
    private int seatStatus;

    public SeatRequest() {
    }

    public SeatRequest(int seatId, int cinemaRoomId, String seatColumn, int seatRow, int seatStatus) {
        this.seatId = seatId;
        this.cinemaRoomId = cinemaRoomId;
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.seatStatus = seatStatus;
    }
}
