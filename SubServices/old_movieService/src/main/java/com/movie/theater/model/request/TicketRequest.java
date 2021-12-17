package com.movie.theater.model.request;

import lombok.Data;

@Data
public class TicketRequest {
    private int ticketId;
    private int price;
    private int tiketType;
}
