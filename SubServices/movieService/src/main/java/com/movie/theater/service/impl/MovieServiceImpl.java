package com.movie.theater.service.impl;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.DTO.response.MovieResponse;
import com.movie.theater.model.entity.*;
import com.movie.theater.repository.CinemaRoomRepository;
import com.movie.theater.repository.MovieRepository;
import com.movie.theater.service.MovieService;
import com.movie.theater.service.ShowDatesService;
import com.movie.theater.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CinemaRoomRepository cinemaRoomRepository;
    private final MovieMapper movieMapper;
    private final ShowDatesService showDatesService;


    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, CinemaRoomRepository cinemaRoomRepository, MovieMapper movieMapper, ShowDatesService showDatesService) {
        this.movieRepository = movieRepository;
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.movieMapper = movieMapper;
        this.showDatesService = showDatesService;
    }

    @Override
    @Transactional
    public MovieResponse save(MovieRequest movie) {
        // save new movie
        CinemaRoom cinemaRoom = cinemaRoomRepository.findCinemaRoomByCinemaRoomName(movie.getCinemaRoom());
        Movie newMovie = new Movie();
        newMovie = movieMapper.mapDtoToEntity(movie);
        newMovie.setCinemaRoom(cinemaRoom);
        movieRepository.save(newMovie);
        return movieMapper.mapEntityToDto(newMovie);
    }

    @Override
    @Transactional
    public MovieResponse update(MovieRequest updateMovie) {
        CinemaRoom cinemaRoom = cinemaRoomRepository.findCinemaRoomByCinemaRoomName(updateMovie.getCinemaRoom());
        Movie newUpdateMovie = new Movie();
        if (updateMovie.getMovieId() != null) {
            Movie oldMovie = movieRepository.findMovieByMovieId(updateMovie.getMovieId());
            oldMovie.setCinemaRoom(cinemaRoom);
            newUpdateMovie = movieMapper.mapDtoToEntity(oldMovie, updateMovie);
        }
        return movieMapper.mapEntityToDto(movieRepository.save(newUpdateMovie));
    }

    @Override
    @Transactional
    public void delete(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieResponse> findAll(Pageable pageable) {
        List<MovieResponse> movieResponseList = new ArrayList<>();
        List<Movie> movieList = movieRepository.findAll(pageable).getContent();
        for (Movie item: movieList
             ) {
            MovieResponse movieResponse = movieMapper.mapEntityToDto(item);
            movieResponseList.add(movieResponse);
        }
        return movieResponseList;
    }

    @Override
    public List<MovieResponse> findAll() {
        List<MovieResponse> movieResponseList = new ArrayList<>();
        List<Movie> movieList = movieRepository.findAll();
        for (Movie item: movieList
        ) {
            MovieResponse movieResponse = movieMapper.mapEntityToDto(item);
            movieResponseList.add(movieResponse);
        }
        return movieResponseList;
    }

    @Override
    public int getTotalItem() {
        return 0;
    }

    @Override
    public MovieResponse findOne(String id) {
        Movie movie = movieRepository.findMovieByMovieId(id);
        return movieMapper.mapEntityToDto(movie);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }
}
