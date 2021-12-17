package com.movie.theater.service.mapper;

import com.movie.theater.model.entity.Seat;
import com.movie.theater.model.request.SeatRequest;
import com.movie.theater.model.response.SeatResponse;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {
    public SeatResponse map(Seat seat) {
        SeatResponse seatResponse = new SeatResponse();

        seatResponse.setSeatId(seat.getSeatId());
        seatResponse.setSeatColumn(seat.getSeatColumn());
        seatResponse.setSeatRow(seat.getSeatRow());
        seatResponse.setSeatStatus(seat.getSeatStatus());
        seatResponse.setSeatType(seat.getSeatType());

        return seatResponse;
    }
    public Seat map(SeatRequest seatRequest) {
        Seat seat = new Seat();

        seat.setSeatId(seatRequest.getSeatId());
        seat.setCinemaRoomId(seatRequest.getCinemaRoomId());
        seat.setSeatColumn(seatRequest.getSeatColumn());
        seat.setSeatRow(seatRequest.getSeatRow());
        seat.setSeatStatus(seatRequest.getSeatStatus());
        seat.setSeatType(0);

        return seat;
    }
    public Seat map(SeatResponse seatResponse) {
        Seat seat = new Seat();

        seat.setSeatId(seatResponse.getSeatId());
        seat.setCinemaRoomId(seatResponse.getCinemaRoomId());
        seat.setSeatColumn(seatResponse.getSeatColumn());
        seat.setSeatRow(seatResponse.getSeatRow());
        seat.setSeatStatus(seatResponse.getSeatStatus());
        seat.setSeatType(0);
        return seat;
    }
}
