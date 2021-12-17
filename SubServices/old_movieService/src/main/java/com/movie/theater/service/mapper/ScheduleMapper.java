package com.movie.theater.service.mapper;

import com.movie.theater.DTO.ScheduleDTO;
import com.movie.theater.model.entity.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {

    public ScheduleDTO mapEntityToDto(Schedule schedule) {
        ScheduleDTO result = new ScheduleDTO();
        result.setScheduleId(schedule.getScheduleId());
        result.setScheduleTime(schedule.getScheduleTime());
        return result;
    }

    public Schedule mapDtoToEntity(ScheduleDTO scheduleDTO) {
        Schedule result = new Schedule();
        result.setScheduleId(scheduleDTO.getScheduleId());
        result.setScheduleTime(scheduleDTO.getScheduleTime());
        return result;
    }
}
