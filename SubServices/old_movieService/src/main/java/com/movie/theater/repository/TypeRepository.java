package com.movie.theater.repository;

import com.movie.theater.model.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type findByTypeId(Integer typeId);
}
