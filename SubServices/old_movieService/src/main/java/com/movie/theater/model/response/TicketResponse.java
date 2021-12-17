package com.movie.theater.model.response;

import lombok.Data;

@Data
public class TicketResponse {
    private int ticketId;
    private int price;
    private int tiketType;

    @Override
    public String toString() {
        return "TicketResponse{" +
                "ticketId=" + ticketId +
                ", price=" + price +
                ", tiketType=" + tiketType +
                '}';
    }
}
