package com.revcart.analytics.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "order_analytics")
@Data
public class OrderAnalytics {
    @Id
    private String id;
    private Long orderId;
    private Long userId;
    private BigDecimal amount;
    private String status;
    private LocalDateTime orderDate;
    private String paymentMethod;
}
