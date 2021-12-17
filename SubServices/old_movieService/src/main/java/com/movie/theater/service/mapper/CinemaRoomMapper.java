package com.movie.theater.service.mapper;

import com.movie.theater.model.entity.CinemaRoom;
import com.movie.theater.model.entity.ScheduleSeat;
import com.movie.theater.model.request.CinemaRoomRequest;
import com.movie.theater.model.response.CinemaRoomResponse;
import org.springframework.stereotype.Component;

@Component
public class CinemaRoomMapper {
    public CinemaRoomResponse map(CinemaRoom cinemaRoom){
        CinemaRoomResponse cinemaRoomResponse = new CinemaRoomResponse();

        cinemaRoomResponse.setCinemaRoomId(cinemaRoom.getCinemaRoomId());
        cinemaRoomResponse.setCinemaRoomName(cinemaRoom.getCinemaRoomName());
        cinemaRoomResponse.setSeatQuantity(cinemaRoom.getSeatQuantity());

        return cinemaRoomResponse;
    }
    public CinemaRoom map(CinemaRoomRequest cinemaRoomRequest) {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setCinemaRoomId(cinemaRoomRequest.getCinemaRoomId());
        cinemaRoom.setCinemaRoomName(cinemaRoomRequest.getCinemaRoomName());
        cinemaRoom.setSeatQuantity(cinemaRoomRequest.getSeatQuantity());
        return cinemaRoom;
    }
}
