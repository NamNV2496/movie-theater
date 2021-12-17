package com.movie.theater.service.impl;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.DTO.request.ShowDatesRequest;
import com.movie.theater.model.entity.ShowDates;
import com.movie.theater.repository.ShowDateRepository;
import com.movie.theater.service.ShowDatesService;
import com.movie.theater.service.mapper.ShowDateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class ShowDatesServiceImpl implements ShowDatesService {
    private final ShowDateRepository showDateRepository;
    private final ShowDateMapper showDateMapper;

    @Autowired
    public ShowDatesServiceImpl(ShowDateRepository showDateRepository, ShowDateMapper showDateMapper) {
        this.showDateRepository = showDateRepository;
        this.showDateMapper = showDateMapper;
    }


    @Override
    public Set<ShowDatesRequest> findAll() {
        Set<ShowDatesRequest> showDatesRequests = new HashSet<>();
        for (ShowDates item:showDateRepository.findAll()
             ) {
            ShowDatesRequest request = showDateMapper.mapEntityToDto(item);
            showDatesRequests.add(request);
        }
        return showDatesRequests;
    }

    @Override
    public ShowDates save(ShowDatesRequest showDatesRequest) {
        ShowDates showDates = new ShowDates();
        showDates = showDateMapper.mapDtoToEntity(showDatesRequest);
        return showDateRepository.save(showDates);
    }

    @Override
    public Set<Integer> saveFromMovieRequest(MovieRequest movieRequest) {
        Set<ShowDatesRequest> showDatesRequests = new HashSet<>();
        Set<Integer> returnShowDateIds = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        for (LocalDate date = movieRequest.getFromDate(); date.isBefore(movieRequest.getToDate().plusDays(1)); date=date.plusDays(1)) {
            Date convertDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            ShowDatesRequest showDatesRequest = new ShowDatesRequest();
            showDatesRequest.setShowDate(date);
            showDatesRequest.setDateName(format.format(convertDate));
            if (!this.findAll().contains(showDatesRequest)) {
                showDatesRequests.add(showDatesRequest);
            } else {
                returnShowDateIds.add(showDateRepository.findByShowDate(date).getShowDateId());
            }
        }
        Set<ShowDates> savedShowDates = new HashSet<>();
        for (ShowDatesRequest item: showDatesRequests
             ) {
            ShowDates showDates = this.save(item);
            savedShowDates.add(showDates);
        }
        for (ShowDates iteam: savedShowDates
             ) {
            returnShowDateIds.add(iteam.getShowDateId());
        }
        return returnShowDateIds;
    }

    @Override
    public ShowDates findByShowDateId(Integer showDateId) {
        return showDateRepository.findByShowDateId(showDateId);
    }
}
