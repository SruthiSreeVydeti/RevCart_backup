package com.revcart.delivery.controller;

import com.revcart.delivery.entity.Delivery;
import com.revcart.delivery.entity.DeliveryAgent;
import com.revcart.delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/assign")
    public ResponseEntity<Delivery> assignDelivery(@RequestParam Long orderId, @RequestParam Long agentId, @RequestParam String address) {
        return ResponseEntity.ok(deliveryService.assignDelivery(orderId, agentId, address));
    }

    @GetMapping("/track/order/{orderId}")
    public ResponseEntity<Delivery> trackByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(deliveryService.trackByOrderId(orderId));
    }

    @GetMapping("/track/{trackingNumber}")
    public ResponseEntity<Delivery> trackByNumber(@PathVariable String trackingNumber) {
        return ResponseEntity.ok(deliveryService.trackByNumber(trackingNumber));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Delivery> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(deliveryService.updateStatus(id, status));
    }

    @GetMapping("/agents/available")
    public ResponseEntity<List<DeliveryAgent>> getAvailableAgents() {
        return ResponseEntity.ok(deliveryService.getAvailableAgents());
    }

    @PostMapping("/agents")
    public ResponseEntity<DeliveryAgent> createAgent(@RequestBody DeliveryAgent agent) {
        return ResponseEntity.ok(deliveryService.createAgent(agent));
    }
}
