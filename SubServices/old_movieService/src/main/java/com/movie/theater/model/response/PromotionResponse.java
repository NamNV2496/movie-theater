package com.movie.theater.model.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PromotionResponse {
    private int id;

    private String details;

    private int discountLevel;

    private LocalDate endTime;

    private String image;

    private LocalDate startTime;

    private String title;
}
