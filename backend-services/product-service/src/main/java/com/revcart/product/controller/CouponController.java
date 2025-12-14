package com.revcart.product.controller;

import com.revcart.product.entity.Coupon;
import com.revcart.product.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    
    @Autowired
    private CouponRepository couponRepository;
    
    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponRepository.findByActiveTrue();
    }
    
    @GetMapping("/validate")
    public ResponseEntity<Map<String, Object>> validateCoupon(
            @RequestParam String code,
            @RequestParam BigDecimal orderAmount) {
        
        Map<String, Object> response = new HashMap<>();
        
        Coupon coupon = couponRepository.findByCode(code).orElse(null);
        
        if (coupon == null || !Boolean.TRUE.equals(coupon.getActive())) {
            response.put("valid", false);
            response.put("message", "Invalid coupon code");
            return ResponseEntity.ok(response);
        }
        
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(coupon.getValidFrom()) || now.isAfter(coupon.getValidUntil())) {
            response.put("valid", false);
            response.put("message", "Coupon has expired");
            return ResponseEntity.ok(response);
        }
        
        if (orderAmount.compareTo(coupon.getMinOrderAmount()) < 0) {
            response.put("valid", false);
            response.put("message", "Minimum order amount is ₹" + coupon.getMinOrderAmount());
            return ResponseEntity.ok(response);
        }
        
        if (coupon.getUsedCount() >= coupon.getUsageLimit()) {
            response.put("valid", false);
            response.put("message", "Coupon usage limit reached");
            return ResponseEntity.ok(response);
        }
        
        BigDecimal discount;
        if ("PERCENTAGE".equals(coupon.getDiscountType())) {
            discount = orderAmount.multiply(coupon.getDiscountValue()).divide(new BigDecimal(100));
            if (coupon.getMaxDiscountAmount() != null && discount.compareTo(coupon.getMaxDiscountAmount()) > 0) {
                discount = coupon.getMaxDiscountAmount();
            }
        } else {
            discount = coupon.getDiscountValue();
        }
        
        response.put("valid", true);
        response.put("discount", discount);
        response.put("message", "Coupon applied successfully");
        
        return ResponseEntity.ok(response);
    }
}
