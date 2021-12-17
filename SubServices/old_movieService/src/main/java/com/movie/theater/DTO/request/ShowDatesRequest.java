package com.movie.theater.DTO.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShowDatesRequest {
    private LocalDate showDate;
    private String dateName;

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }
}
