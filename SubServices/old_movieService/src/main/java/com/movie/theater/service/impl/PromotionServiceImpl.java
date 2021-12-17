package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.entity.Promotion;
import com.movie.theater.model.request.PromotionRequest;
import com.movie.theater.model.response.PromotionResponse;
import com.movie.theater.repository.PromotionRepository;
import com.movie.theater.service.PromotionService;
import com.movie.theater.service.mapper.PromotionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService{
    @Autowired
    private PromotionMapper mapper;
    private final PromotionMapper promotionMapper;
    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionMapper promotionMapper, PromotionRepository promotionRepository) {
        this.promotionMapper = promotionMapper;
        this.promotionRepository = promotionRepository;
    }

    @Override
    public PromotionResponse create(PromotionRequest promotionRequest) {
        Promotion promotion = promotionMapper.map(promotionRequest);

        promotionRepository.save(promotion);

        return promotionMapper.map(promotion);
    }

    @Override
    public List<PromotionResponse> listAllPromotion() {
        List<Promotion> promotion = promotionRepository.findAll();
        List<PromotionResponse> promotionResponses = new ArrayList<>();
        for (Promotion p : promotion) {
            promotionResponses.add(mapper.map(p));
        }
        return promotionResponses;
    }

    @Override
    public PromotionResponse getPromotion(PromotionRequest promotionRequest) {
        Optional<Promotion> promotion = promotionRepository.findById(promotionRequest.getPromotionId());
        return mapper.map(promotion.get());
    }
}
