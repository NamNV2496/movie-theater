package com.movie.theater.service;

import com.movie.theater.model.request.ScheduleSeatRequest;
import com.movie.theater.model.response.ScheduleSeatResponse;

import java.util.List;

public interface IScheduleSeatService {
    void create(ScheduleSeatRequest scheduleSeatRequest);
    List<ScheduleSeatResponse> getAvailableScheSeat(ScheduleSeatRequest scheduleSeatRequest);

}
