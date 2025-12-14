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
        try {
            System.out.println("Adding item to cart for user: " + userId + ", product: " + request.getProductId());
            Cart cart = getCartByUserId(userId);
            
            CartItem existingItem = cart.getItems().stream()
                    .filter(item -> item.getProductId().equals(request.getProductId()))
                    .findFirst()
                    .orElse(null);

            if (existingItem != null) {
                System.out.println("Updating existing item quantity from " + existingItem.getQuantity() + " to " + (existingItem.getQuantity() + request.getQuantity()));
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
                System.out.println("Added new item to cart: " + newItem.getProductName());
            }

            Cart savedCart = cartRepository.save(cart);
            System.out.println("Cart saved successfully with " + savedCart.getItems().size() + " items");
            return savedCart;
        } catch (Exception e) {
            System.err.println("Error in addItemToCart: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to add item to cart: " + e.getMessage(), e);
        }
    }
    
    private Map<String, Object> fetchProductDetails(Long productId) {
        try {
            String productServiceUrl = "http://product-service:8082/api/products/" + productId;
            System.out.println("Fetching product details from: " + productServiceUrl);
            Map<String, Object> product = restTemplate.getForObject(productServiceUrl, Map.class);
            if (product == null) {
                throw new RuntimeException("Product not found: " + productId);
            }
            System.out.println("Product details fetched: " + product.get("name"));
            return product;
        } catch (Exception e) {
            System.err.println("Error fetching product details: " + e.getMessage());
            throw new RuntimeException("Product not found: " + productId, e);
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
