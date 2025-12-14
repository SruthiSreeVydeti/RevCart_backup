package com.revcart.product.service;

import com.revcart.product.entity.Product;
import com.revcart.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final ProductRepository productRepository;

    public List<Product> getRecommendationsForUser(Long userId) {
        return productRepository.findAll().stream()
            .limit(10)
            .collect(Collectors.toList());
    }

    public List<Product> getPopularProducts() {
        return productRepository.findAll().stream()
            .limit(10)
            .collect(Collectors.toList());
    }

    public List<Product> getSimilarProducts(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) return new ArrayList<>();

        return productRepository.findAll().stream()
            .filter(p -> p.getCategory().equals(product.getCategory()) && !p.getId().equals(productId))
            .limit(5)
            .collect(Collectors.toList());
    }
}
