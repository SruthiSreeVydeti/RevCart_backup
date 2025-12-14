package com.revcart.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "delivery_agents")
@Data
public class DeliveryAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String vehicleType;

    private String vehicleNumber;

    @Column(nullable = false)
    private String status = "AVAILABLE";

    private boolean active = true;
}
