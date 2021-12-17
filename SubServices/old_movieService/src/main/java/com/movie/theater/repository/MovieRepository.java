package com.movie.theater.repository;

import com.movie.theater.DTO.MovieDTO;
import com.movie.theater.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    Movie findMovieByMovieId(String id);
}
