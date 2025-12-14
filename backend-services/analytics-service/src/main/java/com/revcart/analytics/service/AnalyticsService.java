package com.revcart.analytics.service;

import com.revcart.analytics.entity.OrderAnalytics;
import com.revcart.analytics.repository.OrderAnalyticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final OrderAnalyticsRepository analyticsRepository;

    public OrderAnalytics recordOrder(OrderAnalytics analytics) {
        return analyticsRepository.save(analytics);
    }

    public List<OrderAnalytics> getOrdersByDateRange(LocalDateTime start, LocalDateTime end) {
        return analyticsRepository.findByOrderDateBetween(start, end);
    }

    public Map<String, Object> getSalesReport(LocalDateTime start, LocalDateTime end) {
        List<OrderAnalytics> orders = getOrdersByDateRange(start, end);
        BigDecimal totalSales = orders.stream()
                .map(OrderAnalytics::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        return Map.of(
            "totalOrders", orders.size(),
            "totalSales", totalSales,
            "averageOrderValue", orders.isEmpty() ? BigDecimal.ZERO : totalSales.divide(BigDecimal.valueOf(orders.size()), 2, BigDecimal.ROUND_HALF_UP)
        );
    }

    public List<OrderAnalytics> getUserOrders(Long userId) {
        return analyticsRepository.findByUserId(userId);
    }
}
