package com.movie.theater.model.request;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CinemaRoomRequest {
    private int cinemaRoomId;
    private String cinemaRoomName;
    private int seatQuantity;
}
