package com.movie.theater.service.page;

import com.movie.theater.DTO.response.MovieResponse;
import com.movie.theater.model.entity.Seat;
import com.movie.theater.model.request.SeatRequest;
import com.movie.theater.model.request.page.TicketSellingManagementRequest;
import com.movie.theater.model.response.SeatResponse;
import com.movie.theater.model.response.page.TicketSellingManagementResponse;
import com.movie.theater.service.*;
import com.movie.theater.service.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketSellingManagermentServiceImpl implements ITicketSellingManagermentService{
    @Autowired
    private MovieService imovieService;
    @Autowired
    private ISeatService iSeatService;
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private MemberService memberService;


    @Override
    public List<TicketSellingManagementResponse> selectMovieAndShowTime(TicketSellingManagementRequest ticketSellingManagementRequest) {
        List<TicketSellingManagementResponse> list = new ArrayList<>();
        TicketSellingManagementResponse ticketSellingManagementResponse = new TicketSellingManagementResponse();
        if (ticketSellingManagementRequest.getMovie().getMovieId() != null) {
            ticketSellingManagementResponse.setMovie(imovieService.findOne(ticketSellingManagementRequest.getMovie().getMovieId()));
            list.add(ticketSellingManagementResponse);
        } else {
            // get movie and time
            List<MovieResponse> listFilm = imovieService.findAll();

            for (MovieResponse m : listFilm) {
                ticketSellingManagementResponse.setMovie(m);
                list.add(ticketSellingManagementResponse);
            }
        }
        return list;
    }

    @Override
    public List<String> getAvailableSeat(TicketSellingManagementRequest ticketSellingManagementRequest) {
        return iSeatService.getAvailableSeat(ticketSellingManagementRequest.getMovie().getCinemaRoomId());
    }

    @Override
    public void selectSeat(TicketSellingManagementRequest ticketSellingManagementRequest) {
        SeatRequest seatRequest = new SeatRequest(ticketSellingManagementRequest.getSeat().getSeatId(),
                ticketSellingManagementRequest.getSeat().getCinemaRoomId(),
                ticketSellingManagementRequest.getSeat().getSeatColumn(),
                ticketSellingManagementRequest.getSeat().getSeatRow(),
                ticketSellingManagementRequest.getSeat().getSeatStatus());
        iSeatService.updateStatus(seatRequest);
    }

    @Override
    public TicketSellingManagementResponse comfirmBookTicket(TicketSellingManagementRequest ticketSellingManagementRequest) {
        TicketSellingManagementResponse ticketSellingManagementResponse = new TicketSellingManagementResponse();
        // get a list of seat that booked
        SeatRequest seatRequest = new SeatRequest(ticketSellingManagementRequest.getSeat().getSeatId(),
                ticketSellingManagementRequest.getSeat().getCinemaRoomId(),
                ticketSellingManagementRequest.getSeat().getSeatColumn(),
                ticketSellingManagementRequest.getSeat().getSeatRow(),
                ticketSellingManagementRequest.getSeat().getSeatStatus());
        ticketSellingManagementResponse.setSeat(iSeatService.getAllSeatBooked(seatRequest));
        // get ticket that booked
        invoiceService.findOne(ticketSellingManagementRequest.getInvoice().getInvoiceId());
        // get member information
//        memberService.getMemberByAccountName(iAuthenticationFacade.getUserName());

        return ticketSellingManagementResponse;
    }

}
