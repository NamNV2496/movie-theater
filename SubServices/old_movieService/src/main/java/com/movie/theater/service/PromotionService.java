package com.movie.theater.service;

import com.movie.theater.model.entity.Promotion;
import com.movie.theater.model.request.PromotionRequest;
import com.movie.theater.model.response.PromotionResponse;

import java.util.List;

public interface PromotionService {
    PromotionResponse create(PromotionRequest promotionRequest);
    List<PromotionResponse> listAllPromotion();
    PromotionResponse getPromotion(PromotionRequest promotionRequest);

}
