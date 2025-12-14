package com.revcart.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/user")
    public Mono<String> userFallback() {
        return Mono.just("User service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/product")
    public Mono<String> productFallback() {
        return Mono.just("Product service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/cart")
    public Mono<String> cartFallback() {
        return Mono.just("Cart service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/order")
    public Mono<String> orderFallback() {
        return Mono.just("Order service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/payment")
    public Mono<String> paymentFallback() {
        return Mono.just("Payment service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/delivery")
    public Mono<String> deliveryFallback() {
        return Mono.just("Delivery service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/notification")
    public Mono<String> notificationFallback() {
        return Mono.just("Notification service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/analytics")
    public Mono<String> analyticsFallback() {
        return Mono.just("Analytics service is temporarily unavailable. Please try again later.");
    }
}