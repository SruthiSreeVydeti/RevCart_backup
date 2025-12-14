package com.revcart.order.controller;

import com.revcart.order.entity.Coupon;
import com.revcart.order.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponRepository couponRepository;

    @GetMapping
    public ResponseEntity<List<Coupon>> getAllActiveCoupons() {
        return ResponseEntity.ok(couponRepository.findByActiveTrue());
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateCoupon(@RequestBody Map<String, Object> request) {
        String code = (String) request.get("code");
        Double orderAmount = ((Number) request.get("orderAmount")).doubleValue();
        
        Coupon coupon = couponRepository.findByCode(code);
        
        if (coupon == null || !coupon.isActive()) {
            return ResponseEntity.badRequest().body(Map.of("valid", false, "message", "Invalid coupon code"));
        }
        
        // Skip date validation for now
        // LocalDateTime now = LocalDateTime.now();
        // if (now.isBefore(coupon.getValidFrom()) || now.isAfter(coupon.getValidUntil())) {
        //     return ResponseEntity.badRequest().body(Map.of("valid", false, "message", "Coupon expired"));
        // }
        
        if (coupon.getMinOrderAmount() != null && orderAmount < coupon.getMinOrderAmount()) {
            return ResponseEntity.badRequest().body(Map.of("valid", false, "message", "Minimum order amount not met"));
        }
        
        if (coupon.getUsageLimit() != null && coupon.getUsedCount() >= coupon.getUsageLimit()) {
            return ResponseEntity.badRequest().body(Map.of("valid", false, "message", "Coupon usage limit reached"));
        }
        
        double discount = 0;
        if ("PERCENTAGE".equals(coupon.getDiscountType())) {
            discount = (orderAmount * coupon.getDiscountValue()) / 100;
            if (coupon.getMaxDiscountAmount() != null && discount > coupon.getMaxDiscountAmount()) {
                discount = coupon.getMaxDiscountAmount();
            }
        } else {
            discount = coupon.getDiscountValue();
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("valid", true);
        response.put("discount", discount);
        response.put("finalAmount", orderAmount - discount);
        response.put("coupon", coupon);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        return ResponseEntity.ok(couponRepository.save(coupon));
    }

    @PostMapping("/apply")
    public ResponseEntity<?> applyCoupon(@RequestBody Map<String, Object> request) {
        String code = (String) request.get("code");
        Coupon coupon = couponRepository.findByCode(code);
        
        if (coupon != null) {
            coupon.setUsedCount(coupon.getUsedCount() + 1);
            couponRepository.save(coupon);
            return ResponseEntity.ok(Map.of("success", true, "message", "Coupon applied"));
        }
        
        return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Invalid coupon"));
    }
}
