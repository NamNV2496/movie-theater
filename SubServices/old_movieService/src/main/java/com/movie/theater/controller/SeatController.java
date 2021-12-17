package com.movie.theater.controller;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.request.SeatRequest;
import com.movie.theater.model.request.TicketRequest;
import com.movie.theater.model.response.Response;
import com.movie.theater.model.response.SeatResponse;
import com.movie.theater.model.response.TicketResponse;
import com.movie.theater.service.ISeatService;
import com.movie.theater.service.ITicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seat")
@RequiredArgsConstructor
public class SeatController {
    @Autowired
    private ISeatService iSeatService;
    @Autowired
    private ITicketService iTicketService;

    @PostMapping("/createSeat")
    public ResponseEntity<SystemResponse<Object>> creatSeat(@RequestBody SeatRequest seatRequest) {
        System.out.println("createSeat");
        iSeatService.creat(seatRequest);
        System.out.println("createSeat done");
        return Response.ok();
    }

    @GetMapping("/getTicket")
    public ResponseEntity<SystemResponse<TicketResponse>> getTicket(@RequestBody TicketRequest ticketRequest) {
        TicketResponse ticketResponse = iTicketService.read(ticketRequest);
        return Response.ok(ticketResponse);
    }

    @GetMapping("/updateSeat")
    public ResponseEntity<SystemResponse<Object>> updateSeat(@RequestBody SeatRequest seatRequest) {
        iSeatService.updateStatus(seatRequest);
        SeatResponse seatResponse = iSeatService.read(seatRequest);
        return Response.ok(seatResponse);
    }
    @GetMapping("/getAvailableSeat")
    public ResponseEntity<SystemResponse<Object>> getAvailableSeat(@RequestBody SeatRequest seatRequest) {
        List<String> list = iSeatService.getAvailableSeat(seatRequest.getCinemaRoomId());

        return Response.ok(list);
    }
}
