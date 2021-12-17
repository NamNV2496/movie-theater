package com.movie.theater.service;

import com.movie.theater.model.request.TicketRequest;
import com.movie.theater.model.response.TicketResponse;

public interface ITicketService {
    void create(TicketRequest ticketRequest);
    TicketResponse read(TicketRequest ticketRequest);
}
