package com.movie.theater.model.request;

import lombok.Data;

@Data
public class ScheduleSeatRequest {
    private String scheduleSeatId;
    private String movieId;
    private int scheduleId;
    private int seatId;
    private String seatColumn;
    private int seatRow;
}
