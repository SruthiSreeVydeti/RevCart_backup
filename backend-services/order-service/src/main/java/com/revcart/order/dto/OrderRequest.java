package com.revcart.order.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequest {
    private Long userId;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private String shippingAddress;
    private List<OrderItemRequest> items;
}
