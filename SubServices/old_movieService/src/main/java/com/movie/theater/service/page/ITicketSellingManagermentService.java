package com.movie.theater.service.page;

import com.movie.theater.model.request.page.TicketSellingManagementRequest;
import com.movie.theater.model.response.page.TicketSellingManagementResponse;

import java.util.List;

public interface ITicketSellingManagermentService {
    List<TicketSellingManagementResponse> selectMovieAndShowTime(TicketSellingManagementRequest ticketSellingManagementRequest);
    // get available seat to show on selecting seat page
    List<String> getAvailableSeat(TicketSellingManagementRequest ticketSellingManagementRequest);
    // save booking seat
    void selectSeat(TicketSellingManagementRequest ticketSellingManagementRequest);
    TicketSellingManagementResponse comfirmBookTicket(TicketSellingManagementRequest ticketSellingManagementRequest);
}
