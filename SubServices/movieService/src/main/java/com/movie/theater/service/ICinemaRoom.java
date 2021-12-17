package com.movie.theater.service;

import com.movie.theater.model.request.CinemaRoomRequest;
import com.movie.theater.model.response.CinemaRoomResponse;

import java.util.List;

public interface ICinemaRoom {
    void create(CinemaRoomRequest cinemaRoomRequest);
    List<CinemaRoomResponse> getAllCinemaRoom();
    CinemaRoomResponse getCinemaRoomInfo(int cinemaRoomId);
}
