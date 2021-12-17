package com.movie.theater.model.response.page;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.DTO.response.MovieResponse;
import com.movie.theater.model.entity.*;
import com.movie.theater.model.response.AccountMemberResponse;
import com.movie.theater.model.response.InvoiceResponse;
import com.movie.theater.model.response.SeatResponse;
import lombok.Data;

import java.util.List;

@Data
public class TicketSellingManagementResponse {
    private MovieResponse movie;
    private List<SeatResponse> seat;
    private InvoiceResponse invoice;
    private AccountMemberResponse member;
}
