package com.movie.theater.DTO;

import lombok.Data;

//@Data
public class ScheduleDTO {
    private Integer scheduleId;
    private String scheduleTime;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}
