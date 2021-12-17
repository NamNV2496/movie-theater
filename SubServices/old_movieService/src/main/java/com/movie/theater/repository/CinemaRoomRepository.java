package com.movie.theater.repository;

import com.movie.theater.model.entity.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer > {
    CinemaRoom findCinemaRoomByCinemaRoomName(String name);
    CinemaRoom findByCinemaRoomId(Integer cinemaRoomId);
}
