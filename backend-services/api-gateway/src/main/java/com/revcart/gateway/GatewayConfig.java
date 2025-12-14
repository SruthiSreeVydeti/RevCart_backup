package com.revcart.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/users/**", "/api/auth/**")
                        .uri("http://user-service:8081"))
                .route("product-service", r -> r.path("/api/products/**")
                        .uri("http://product-service:8082"))
                .route("cart-service", r -> r.path("/api/cart/**", "/api/wishlist/**")
                        .uri("http://cart-service:8083"))
                .route("order-service", r -> r.path("/api/orders/**", "/api/coupons/**")
                        .uri("http://order-service:8084"))
                .route("payment-service", r -> r.path("/api/payments/**")
                        .uri("http://payment-service:8085"))
                .route("delivery-service", r -> r.path("/api/delivery/**")
                        .uri("http://delivery-service:8086"))
                .route("notification-service", r -> r.path("/api/notifications/**")
                        .uri("http://notification-service:8087"))
                .route("analytics-service", r -> r.path("/api/analytics/**")
                        .uri("http://analytics-service:8088"))
                .build();
    }
}