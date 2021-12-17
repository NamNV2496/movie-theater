package com.movie.theater.service;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.DTO.request.ShowDatesRequest;
import com.movie.theater.model.entity.ShowDates;

import java.util.Set;

public interface ShowDatesService {
    Set<ShowDatesRequest> findAll();
    ShowDates save(ShowDatesRequest showDatesRequest);
    Set<Integer> saveFromMovieRequest(MovieRequest movieRequest);
    ShowDates findByShowDateId(Integer showDateId);
}
