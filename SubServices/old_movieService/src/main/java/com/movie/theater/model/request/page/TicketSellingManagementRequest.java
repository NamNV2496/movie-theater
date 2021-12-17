package com.movie.theater.model.request.page;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.model.entity.*;
import com.movie.theater.model.request.InvoiceRequest;
import com.movie.theater.model.request.SeatRequest;
import lombok.Data;

@Data
public class TicketSellingManagementRequest {
    private MovieRequest movie;
    private SeatRequest seat;
    private InvoiceRequest invoice;
}
