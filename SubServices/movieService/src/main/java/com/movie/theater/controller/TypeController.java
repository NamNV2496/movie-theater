package com.movie.theater.controller;

import com.movie.theater.DTO.TypeDTO;
import com.movie.theater.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type-movie")
public class TypeController {
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping(value = "/get-types")
    public List<TypeDTO> getMovieTypes() {
        return typeService.findAll();
    }
}
