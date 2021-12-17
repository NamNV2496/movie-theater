package com.movie.theater.service.mapper;

import com.movie.theater.DTO.TypeDTO;
import com.movie.theater.model.entity.Type;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper {

    public TypeDTO mapEntityToDto(Type type) {
        TypeDTO result = new TypeDTO();
        result.setTypeId(type.getTypeId());
        result.setTypeName(type.getTypeName());
        return result;
    }
}
