package com.movie.theater.controller;

import com.movie.theater.DTO.ScheduleDTO;
import com.movie.theater.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schedule-movie")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/get-schedules")
    public List<ScheduleDTO> getScheduleList() {
        return scheduleService.findAll();
    }
}
