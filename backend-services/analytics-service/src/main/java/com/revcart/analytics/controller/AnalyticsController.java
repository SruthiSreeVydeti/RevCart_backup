package com.revcart.analytics.controller;

import com.revcart.analytics.entity.OrderAnalytics;
import com.revcart.analytics.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @PostMapping("/orders")
    public ResponseEntity<OrderAnalytics> recordOrder(@RequestBody OrderAnalytics analytics) {
        return ResponseEntity.ok(analyticsService.recordOrder(analytics));
    }

    @GetMapping("/sales")
    public ResponseEntity<Map<String, Object>> getSalesReport(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(analyticsService.getSalesReport(start, end));
    }

    @GetMapping("/orders/user/{userId}")
    public ResponseEntity<List<OrderAnalytics>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(analyticsService.getUserOrders(userId));
    }

    @GetMapping("/orders/range")
    public ResponseEntity<List<OrderAnalytics>> getOrdersByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(analyticsService.getOrdersByDateRange(start, end));
    }
}
