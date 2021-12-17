package com.movie.theater.service.mapper;

import com.movie.theater.model.entity.ScheduleSeat;
import com.movie.theater.model.request.ScheduleSeatRequest;
import com.movie.theater.model.response.ScheduleSeatResponse;
import org.springframework.stereotype.Component;

@Component
public class ScheduleSeatMapper {

    public ScheduleSeatResponse map(ScheduleSeat scheduleSeat){
        ScheduleSeatResponse scheduleSeatResponse = new ScheduleSeatResponse();

        scheduleSeatResponse.setScheduleId(scheduleSeat.getScheduleId());
        scheduleSeatResponse.setSeatId(scheduleSeat.getSeatId());
        scheduleSeatResponse.setScheduleSeatId(scheduleSeat.getScheduleSeatId());
        scheduleSeatResponse.setSeatRow(scheduleSeat.getSeatRow());
        scheduleSeatResponse.setSeatColumn(scheduleSeat.getSeatColumn());
        scheduleSeatResponse.setSeatStatus(scheduleSeat.getSeatStatus());
        scheduleSeatResponse.setSeatType(scheduleSeat.getSeatType());
        scheduleSeatResponse.setMovieId(scheduleSeat.getMovieId());

        return scheduleSeatResponse;
    }
    public ScheduleSeat map(ScheduleSeatRequest scheduleSeatRequest){
        ScheduleSeat scheduleSeat = new ScheduleSeat();

        scheduleSeat.setScheduleId(scheduleSeatRequest.getScheduleId());
        scheduleSeat.setSeatId(scheduleSeatRequest.getSeatId());
        scheduleSeat.setScheduleSeatId(scheduleSeatRequest.getScheduleSeatId());
        scheduleSeat.setSeatRow(scheduleSeatRequest.getSeatRow());
        scheduleSeat.setSeatColumn(scheduleSeatRequest.getSeatColumn());
        scheduleSeat.setSeatStatus(0);
        scheduleSeat.setSeatType(0);
        scheduleSeat.setMovieId(scheduleSeatRequest.getMovieId());

        return scheduleSeat;
    }
}
