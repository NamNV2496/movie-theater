package com.movie.theater.service.impl;

import com.movie.theater.DTO.TypeDTO;
import com.movie.theater.model.entity.Type;
import com.movie.theater.repository.TypeRepository;
import com.movie.theater.service.TypeService;
import com.movie.theater.service.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository, TypeMapper typeMapper) {
        this.typeRepository = typeRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public List<TypeDTO> findAll() {
        List<Type> typeList = typeRepository.findAll();
        List<TypeDTO> typeDTOList = new ArrayList<>();
        for (Type item: typeList
             ) {
            TypeDTO typeDTO = typeMapper.mapEntityToDto(item);
            typeDTOList.add(typeDTO);
        }
        return typeDTOList;
    }

    @Override
    public Type findByTypeId(Integer typeId) {
        return typeRepository.findByTypeId(typeId);
    }
}
