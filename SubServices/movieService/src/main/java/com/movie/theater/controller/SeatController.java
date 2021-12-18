package com.movie.theater.controller;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.request.SeatRequest;
import com.movie.theater.model.request.TicketRequest;
import com.movie.theater.model.response.Response;
import com.movie.theater.model.response.SeatResponse;
import com.movie.theater.model.response.TicketResponse;
import com.movie.theater.service.ISeatService;
import com.movie.theater.service.ITicketService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private ISeatService iSeatService;
    @Autowired
    private ITicketService iTicketService;
    private Boolean CheckToken(String token) {
        System.out.println("Check token SeatController");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        return (Boolean) restTemplate.postForObject("http://localhost:8081/check", request, Boolean.class);
    }

    @PostMapping("/createSeat")
    public ResponseEntity<SystemResponse<Object>> creatSeat(@RequestBody SeatRequest seatRequest, @RequestHeader("Authorization") String token) {
        if (CheckToken(token) == true) {
            System.out.println("createSeat");
            iSeatService.creat(seatRequest);
            System.out.println("createSeat done");
            return Response.ok();
        } else {
            return Response.fail("Fail");
        }
    }

    @GetMapping("/getTicket")
    public ResponseEntity<SystemResponse<Object>> getTicket(@RequestBody TicketRequest ticketRequest, @RequestHeader("Authorization") String token) {
        if (CheckToken(token) == true) {
            TicketResponse ticketResponse = iTicketService.read(ticketRequest);
            System.out.println("getTicket ok");
            return Response.ok(ticketResponse);
        } else {
            System.out.println("Check token fail");
            return Response.fail("fail");
        }
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
