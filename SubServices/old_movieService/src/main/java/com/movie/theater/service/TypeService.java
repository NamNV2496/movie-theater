package com.movie.theater.service;

import com.movie.theater.DTO.TypeDTO;
import com.movie.theater.model.entity.Type;

import java.util.List;

public interface TypeService {
    List<TypeDTO> findAll();
    Type findByTypeId(Integer typeId);
}
