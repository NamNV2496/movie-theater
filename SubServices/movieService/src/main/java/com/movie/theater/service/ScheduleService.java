package com.movie.theater.service;

import com.movie.theater.DTO.ScheduleDTO;
import com.movie.theater.model.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<ScheduleDTO> findAll();
    Schedule findOne(Integer scheduleId);
}
