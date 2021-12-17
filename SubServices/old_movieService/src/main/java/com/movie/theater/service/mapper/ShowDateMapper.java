package com.movie.theater.service.mapper;

import com.movie.theater.DTO.request.ShowDatesRequest;
import com.movie.theater.model.entity.ShowDates;
import org.springframework.stereotype.Component;

@Component
public class ShowDateMapper {
    public ShowDatesRequest mapEntityToDto(ShowDates showDates) {
        ShowDatesRequest result = new ShowDatesRequest();
        result.setDateName(showDates.getDateName());
        result.setShowDate(showDates.getShowDate());
        return result;
    }

    public ShowDates mapDtoToEntity(ShowDatesRequest showDatesRequest) {
        ShowDates result = new ShowDates();
        result.setDateName(showDatesRequest.getDateName());
        result.setShowDate(showDatesRequest.getShowDate());
        return result;
    }
}
