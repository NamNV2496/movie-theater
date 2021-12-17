package com.movie.theater.controller;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.request.TicketRequest;
import com.movie.theater.model.response.Response;
import com.movie.theater.model.response.TicketResponse;
import com.movie.theater.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/ticket")
public class TicketController {
    @Autowired
    private ITicketService iTicketService;

    @PostMapping ("/createTicket")
    public ResponseEntity<SystemResponse<Object>> createTicket(@RequestBody TicketRequest ticketRequest) {
        iTicketService.create(ticketRequest);
        return Response.ok();
    }

    @GetMapping("/getTicket")
    public ResponseEntity<SystemResponse<TicketResponse>> getTicket (@RequestBody TicketRequest ticketRequest) {
        return Response.ok(iTicketService.read(ticketRequest));
    }
}
