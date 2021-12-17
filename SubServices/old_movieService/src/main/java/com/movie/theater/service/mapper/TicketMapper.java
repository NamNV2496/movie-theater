package com.movie.theater.service.mapper;

import com.movie.theater.model.entity.Ticket;
import com.movie.theater.model.request.TicketRequest;
import com.movie.theater.model.response.TicketResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketMapper {
    public Ticket map(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketRequest.getTicketId());
        ticket.setTicketType(ticketRequest.getTiketType());
        ticket.setPrice(ticketRequest.getPrice());
        return ticket;
    }
    public TicketResponse map(Ticket ticket) {
        TicketResponse ticketResponse  = new TicketResponse();

        ticketResponse.setTicketId(ticket.getTicketId());
        ticketResponse.setTiketType(ticket.getTicketType());
        ticketResponse.setPrice(ticket.getPrice());

        return ticketResponse;
    }

}
