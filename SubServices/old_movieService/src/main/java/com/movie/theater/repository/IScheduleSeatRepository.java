package com.movie.theater.repository;

import com.movie.theater.model.entity.ScheduleSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScheduleSeatRepository extends JpaRepository<ScheduleSeat, Integer> {
}
