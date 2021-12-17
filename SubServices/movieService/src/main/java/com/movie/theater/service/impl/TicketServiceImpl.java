package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.common.ErrorCode;
import com.movie.theater.model.entity.Ticket;
import com.movie.theater.model.request.TicketRequest;
import com.movie.theater.model.response.TicketResponse;
import com.movie.theater.repository.ITicketRepository;
import com.movie.theater.service.ITicketService;
import com.movie.theater.service.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketServiceImpl implements ITicketService {
    @Autowired
    private ITicketRepository iTicketRepository;

    @Autowired
    private TicketMapper mapper;

    @Override
    public void create(TicketRequest ticketRequest) {
        if (iTicketRepository.findById(ticketRequest.getTicketId()).isPresent()) {
            throw new AppException(ErrorCode.TICKET_ALREADY_EXISTS);
        } else {
            Ticket ticket = mapper.map(ticketRequest);
            iTicketRepository.save(ticket);
        }
    }

    @Override
    public TicketResponse read(TicketRequest ticketRequest) {
        Optional<Ticket> ticket = iTicketRepository.findById(ticketRequest.getTicketId());
        System.out.println("read: " + ticketRequest.getTicketId() + " isPresent: " +ticket.isPresent());
        if (ticket.isPresent()) {
            Ticket ticket1 = ticket.get();
            return mapper.map(ticket1);
        } else {
            return null;
        }
    }
}
