package com.movie.theater.controller;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.request.PromotionRequest;
import com.movie.theater.model.response.PromotionResponse;
import com.movie.theater.model.response.Response;
import com.movie.theater.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
    private final PromotionService promotionService;

    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @PostMapping("/create")
    public ResponseEntity<SystemResponse<PromotionResponse>> create(@Valid @RequestBody PromotionRequest promotionRequest){

        return Response.ok(promotionService.create(promotionRequest));
    }

    @GetMapping("/listAllPromotion")
    public ResponseEntity<SystemResponse<List<PromotionResponse>>> listAllPromotion() {
        return Response.ok(promotionService.listAllPromotion());
    }

    @GetMapping("/getPromotion")
    public ResponseEntity<SystemResponse<PromotionResponse>> getPromotion(@RequestBody PromotionRequest promotionRequest) {
        return Response.ok(promotionService.getPromotion(promotionRequest));
    }
}
