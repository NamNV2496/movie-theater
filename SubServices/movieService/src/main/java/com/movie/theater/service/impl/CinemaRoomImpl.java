package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.common.ErrorCode;
import com.movie.theater.model.entity.CinemaRoom;
import com.movie.theater.model.entity.ScheduleSeat;
import com.movie.theater.model.request.CinemaRoomRequest;
import com.movie.theater.model.response.CinemaRoomResponse;
import com.movie.theater.repository.ICinemaRoomRepository;
import com.movie.theater.service.ICinemaRoom;
import com.movie.theater.service.mapper.CinemaRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CinemaRoomImpl implements ICinemaRoom {
    @Autowired
    private ICinemaRoomRepository iCinemaRoomRepository;
    @Autowired
    private CinemaRoomMapper mapper;

    @Override
    public void create(CinemaRoomRequest cinemaRoomRequest) {
        if (iCinemaRoomRepository.findById(cinemaRoomRequest.getCinemaRoomId()).isPresent()) {
            throw new AppException(ErrorCode.CINEMA_ROOM_ALREADY_EXISTS);
        } else {
            CinemaRoom cinemaRoom = mapper.map(cinemaRoomRequest);
            iCinemaRoomRepository.save(cinemaRoom);
        }
    }

    public List<CinemaRoomResponse> getAllCinemaRoom() {
        List<CinemaRoom> scheduleSeat = iCinemaRoomRepository.findAll();
        return scheduleSeat.stream().map(mapper::map).collect(Collectors.toList());
    }

    public CinemaRoomResponse getCinemaRoomInfo(int cinemaRoomId) {
        Optional<CinemaRoom> cinemaRoom = iCinemaRoomRepository.findById(cinemaRoomId);
        CinemaRoomResponse cinemaRoomResponse = mapper.map(cinemaRoom.get());
        return cinemaRoomResponse;
    }
}
