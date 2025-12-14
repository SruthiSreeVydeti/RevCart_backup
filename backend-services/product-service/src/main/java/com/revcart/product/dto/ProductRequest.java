package com.revcart.product.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private String category;
    private String brand;
    private Integer stock;
    private String imageUrl;
}
