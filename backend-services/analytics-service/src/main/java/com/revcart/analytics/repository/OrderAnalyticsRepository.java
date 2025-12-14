package com.revcart.analytics.repository;

import com.revcart.analytics.entity.OrderAnalytics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderAnalyticsRepository extends MongoRepository<OrderAnalytics, String> {
    List<OrderAnalytics> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);
    List<OrderAnalytics> findByUserId(Long userId);
}
