package com.movie.theater.service.impl;

import com.movie.theater.DTO.ScheduleDTO;
import com.movie.theater.model.entity.Schedule;
import com.movie.theater.repository.ScheduleRepository;
import com.movie.theater.service.ScheduleService;
import com.movie.theater.service.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchedulerServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Autowired
    public SchedulerServiceImpl(ScheduleRepository scheduleRepository, ScheduleMapper scheduleMapper) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public List<ScheduleDTO> findAll() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        for (Schedule item: scheduleList
             ) {
            ScheduleDTO scheduleDTO = scheduleMapper.mapEntityToDto(item);
            scheduleDTOList.add(scheduleDTO);
        }
        return scheduleDTOList;
    }

    @Override
    public Schedule findOne(Integer scheduleId) {
        return scheduleRepository.findByScheduleId(scheduleId);
    }
}
