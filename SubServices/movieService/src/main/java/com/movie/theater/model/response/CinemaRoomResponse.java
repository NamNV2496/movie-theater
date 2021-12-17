package com.movie.theater.model.response;

import lombok.Data;

@Data
public class CinemaRoomResponse {
    private int cinemaRoomId;
    private String cinemaRoomName;
    private int seatQuantity;
}
