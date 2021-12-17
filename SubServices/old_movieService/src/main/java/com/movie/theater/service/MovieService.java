package com.movie.theater.service;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.DTO.response.MovieResponse;
import com.movie.theater.model.entity.Movie;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {
    MovieResponse save(MovieRequest movieRequest);
    MovieResponse update(MovieRequest updateMovie);
    void delete(String id);
    List<MovieResponse> findAll(Pageable pageble);
    List<MovieResponse> findAll();
    int getTotalItem();
    MovieResponse findOne(String id);

    void save(Movie movie);
}
