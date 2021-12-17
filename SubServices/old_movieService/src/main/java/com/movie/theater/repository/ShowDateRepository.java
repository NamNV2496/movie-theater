package com.movie.theater.repository;

import com.movie.theater.model.entity.ShowDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ShowDateRepository extends JpaRepository<ShowDates, Integer> {
    ShowDates findByShowDateId(Integer showDateId);
    ShowDates findByShowDate(LocalDate showDate);
}
