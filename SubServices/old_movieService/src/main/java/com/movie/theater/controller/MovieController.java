package com.movie.theater.controller;

import com.movie.theater.DTO.request.MovieRequest;
import com.movie.theater.DTO.response.MovieResponse;
import com.movie.theater.service.MovieService;
import com.movie.theater.service.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-management")
public class MovieController {
    public final MovieService movieService;
    public final MovieMapper movieMapper;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping(value = "/get-moives")
    public List<MovieResponse> getMovies() {
        return movieService.findAll();
    }

    @GetMapping(value = "/get-movie/{movieId}")
    public MovieResponse getMovie(@PathVariable("movieId") String movieId) {
        return movieService.findOne(movieId);
    }

    @PostMapping(value = "/post")
    public MovieResponse create(@RequestBody MovieRequest movieRequest){
        return movieService.save(movieRequest);
    }

    @PutMapping(value = "/update/{movieId}")
    public MovieResponse update(@PathVariable("movieId") String movieId ,@RequestBody MovieRequest movieRequest) {
        movieRequest.setMovieId(movieId);
        return movieService.update(movieRequest);
    }

    @DeleteMapping(value = "/delete/{movieId}")
    public void delete(@PathVariable("movieId") String movieId) {
        movieService.delete(movieId);
    }
}
