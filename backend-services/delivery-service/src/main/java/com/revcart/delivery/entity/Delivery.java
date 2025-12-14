package com.revcart.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "deliveries")
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private Long agentId;

    @Column(nullable = false)
    private String status = "ASSIGNED";

    private String trackingNumber;

    @Column(length = 1000)
    private String deliveryAddress;

    private LocalDateTime assignedAt = LocalDateTime.now();
    private LocalDateTime deliveredAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
