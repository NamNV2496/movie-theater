package com.movie.theater.service.mapper;

import com.movie.theater.model.entity.Promotion;
import com.movie.theater.model.request.PromotionRequest;
import com.movie.theater.model.response.PromotionResponse;
import org.springframework.stereotype.Component;

@Component
public class PromotionMapper {

    public Promotion map(PromotionRequest promotionRequest) {
        Promotion promotion = new Promotion();

        promotion.setDetails(promotionRequest.getDetails());
        promotion.setDiscountLevel(promotionRequest.getDiscountLevel());
        promotion.setEndTime(promotionRequest.getEndTime());
        promotion.setImage(promotionRequest.getImage());
        promotion.setTitle(promotionRequest.getTitle());
        promotion.setStartTime(promotionRequest.getStartTime());

        return promotion;
    }

    public PromotionResponse map(Promotion promotion) {
        PromotionResponse promotionResponse = new PromotionResponse();

        promotionResponse.setId(promotion.getPromotionId());
        promotionResponse.setDetails(promotion.getDetails());
        promotionResponse.setDiscountLevel(promotion.getDiscountLevel());
        promotionResponse.setEndTime(promotion.getEndTime());
        promotionResponse.setImage(promotion.getImage());
        promotionResponse.setTitle(promotion.getTitle());
        promotionResponse.setStartTime(promotion.getStartTime());

        return promotionResponse;

    }
}
