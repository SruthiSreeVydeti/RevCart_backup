package com.revcart.product.controller;

import com.revcart.product.entity.Product;
import com.revcart.product.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/for-user/{userId}")
    public ResponseEntity<?> getRecommendationsForUser(@PathVariable Long userId) {
        try {
            List<Product> recommendations = recommendationService.getRecommendationsForUser(userId);
            return ResponseEntity.ok(recommendations);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error fetching recommendations"));
        }
    }

    @GetMapping("/popular")
    public ResponseEntity<?> getPopularProducts() {
        try {
            List<Product> products = recommendationService.getPopularProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error fetching popular products"));
        }
    }

    @GetMapping("/similar/{productId}")
    public ResponseEntity<?> getSimilarProducts(@PathVariable Long productId) {
        try {
            List<Product> products = recommendationService.getSimilarProducts(productId);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error fetching similar products"));
        }
    }
}
