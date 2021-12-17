package com.movie.theater.service;

import com.movie.theater.model.request.SeatRequest;
import com.movie.theater.model.response.SeatResponse;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISeatService {
    void creat(SeatRequest seatRequest);
    SeatResponse read(SeatRequest seatRequest);
    void updateStatus(SeatRequest seatRequest);
    List<String> getAvailableSeat(int cinemaRoomId);
    List<SeatResponse> getAllSeatBooked(SeatRequest SeatRequest);
}
