package com.movie.theater.model.response;

import lombok.Data;

@Data
public class ScheduleSeatResponse {
    private String scheduleSeatId;
    private String movieId;
    private int scheduleId;
    private int seatId;
    private String seatColumn;
    private int seatRow;
    private int seatStatus;
    private int seatType;
}
