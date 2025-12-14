package com.revcart.cart.controller;

import com.revcart.cart.entity.Wishlist;
import com.revcart.cart.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistRepository wishlistRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getWishlist(@PathVariable Long userId) {
        try {
            var wishlist = wishlistRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Wishlist newWishlist = new Wishlist();
                    newWishlist.setUserId(userId);
                    return wishlistRepository.save(newWishlist);
                });
            return ResponseEntity.ok(wishlist);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error fetching wishlist"));
        }
    }

    @PostMapping("/{userId}/add/{productId}")
    public ResponseEntity<?> addToWishlist(@PathVariable Long userId, @PathVariable Long productId) {
        try {
            var wishlist = wishlistRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Wishlist newWishlist = new Wishlist();
                    newWishlist.setUserId(userId);
                    return wishlistRepository.save(newWishlist);
                });
            
            if (!wishlist.getProductIds().contains(productId)) {
                wishlist.getProductIds().add(productId);
                wishlistRepository.save(wishlist);
            }
            
            return ResponseEntity.ok(Map.of("message", "Added to wishlist"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error adding to wishlist"));
        }
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public ResponseEntity<?> removeFromWishlist(@PathVariable Long userId, @PathVariable Long productId) {
        try {
            var wishlist = wishlistRepository.findByUserId(userId).orElseThrow();
            wishlist.getProductIds().remove(productId);
            wishlistRepository.save(wishlist);
            
            return ResponseEntity.ok(Map.of("message", "Removed from wishlist"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", "Error removing from wishlist"));
        }
    }
}
