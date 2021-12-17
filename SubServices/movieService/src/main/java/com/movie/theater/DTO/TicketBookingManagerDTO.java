package com.movie.theater.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TicketBookingManagerDTO {
    private int id;
    private String bookingId;
    private String memberId;
    private String fullName;
    private String identityCard;
    private String phoneNumber;
    private String movie;
    private String time;
    private List<String> seat;
    private Boolean booked;
}
