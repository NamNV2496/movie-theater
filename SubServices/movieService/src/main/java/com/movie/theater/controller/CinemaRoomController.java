package com.movie.theater.controller;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.request.CinemaRoomRequest;
import com.movie.theater.model.response.CinemaRoomResponse;
import com.movie.theater.model.response.Response;
import com.movie.theater.service.ICinemaRoom;
import com.movie.theater.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinemaRoom")
public class CinemaRoomController {
    @Autowired
    private ISeatService iSeatService;
    @Autowired
    private ICinemaRoom iCinemaRoom;

    @GetMapping("/CreateRoom")
    public ResponseEntity<SystemResponse<Object>> CreateRoom(@RequestBody CinemaRoomRequest cinemaRoomRequest) {
        iCinemaRoom.create(cinemaRoomRequest);
        return Response.ok();
    }

    @GetMapping ("/getRoomSeat")
    public ResponseEntity<SystemResponse<List<String>>> getRoomSeat(@RequestBody CinemaRoomRequest cinemaRoomRequest) {
        return Response.ok(iSeatService.getAvailableSeat(cinemaRoomRequest.getCinemaRoomId()));
    }

    @GetMapping("/getAllCinemaRoom")
    public ResponseEntity<SystemResponse<Object>> getAllCinemaRoom() {
        return Response.ok(iCinemaRoom.getAllCinemaRoom());
    }

    @GetMapping("/getCinemaRoomInfo")
    public ResponseEntity<SystemResponse<CinemaRoomResponse>> getCinemaRoomInfo(@RequestBody CinemaRoomRequest cinemaRoomRequest) {
        return Response.ok(iCinemaRoom.getCinemaRoomInfo(cinemaRoomRequest.getCinemaRoomId()));
    }
}
