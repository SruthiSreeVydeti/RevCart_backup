package com.revcart.cart.service;

import com.revcart.cart.dto.CartItemRequest;
import com.revcart.cart.entity.Cart;
import com.revcart.cart.entity.CartItem;
import com.revcart.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUserId(userId);
                    return cartRepository.save(cart);
                });
    }

    @Transactional
    public Cart addItemToCart(Long userId, CartItemRequest request) {
        Cart cart = getCartByUserId(userId);
        
        CartItem existingItem = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(request.getProductId()))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity());
        } else {
            // Fetch product details from product service
            Map<String, Object> product = fetchProductDetails(request.getProductId());
            
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProductId(request.getProductId());
            newItem.setProductName((String) product.get("name"));
            newItem.setQuantity(request.getQuantity());
            newItem.setPrice(new BigDecimal(product.get("price").toString()));
            cart.getItems().add(newItem);
        }

        return cartRepository.save(cart);
    }
    
    private Map<String, Object> fetchProductDetails(Long productId) {
        try {
            String productServiceUrl = "http://product-service:8082/api/products/" + productId;
            return restTemplate.getForObject(productServiceUrl, Map.class);
        } catch (Exception e) {
            // Fallback if product service is not available
            throw new RuntimeException("Product not found: " + productId);
        }
    }

    @Transactional
    public Cart removeItemFromCart(Long userId, Long productId) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().removeIf(item -> item.getProductId().equals(productId));
        return cartRepository.save(cart);
    }

    @Transactional
    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
