package com.movie.theater.controller.page;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.request.page.TicketSellingManagementRequest;
import com.movie.theater.model.response.Response;
import com.movie.theater.service.page.ITicketSellingManagermentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticketSelling")
public class TicketSellingManagementController {
    @Autowired
    private ITicketSellingManagermentService iTicketSellingManagermentService;

    @GetMapping("/selectMovie")
    public ResponseEntity<SystemResponse<Object>> selectMovie(@RequestBody TicketSellingManagementRequest ticketSellingManagementRequest) {
        return Response.ok(iTicketSellingManagermentService.selectMovieAndShowTime(ticketSellingManagementRequest));
    }

    @GetMapping("/getAvailableSeat")
    public ResponseEntity<SystemResponse<Object>> getAvailableSeat(@RequestBody TicketSellingManagementRequest ticketSellingManagementRequest) {
        return Response.ok(iTicketSellingManagermentService.getAvailableSeat(ticketSellingManagementRequest));
    }

    @PostMapping("/selectSeat")
    public ResponseEntity<SystemResponse<Object>> selectSeat(@RequestBody TicketSellingManagementRequest ticketSellingManagementRequest) {
        iTicketSellingManagermentService.selectSeat(ticketSellingManagementRequest);
        return Response.ok();
    }

    @PostMapping("/comfirmBookTicket")
    public ResponseEntity<SystemResponse<Object>> comfirmBookTicket(TicketSellingManagementRequest ticketSellingManagementRequest) {

        return Response.ok(iTicketSellingManagermentService.comfirmBookTicket(ticketSellingManagementRequest));
    }
}
