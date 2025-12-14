package com.revcart.delivery.service;

import com.revcart.delivery.entity.Delivery;
import com.revcart.delivery.entity.DeliveryAgent;
import com.revcart.delivery.repository.DeliveryAgentRepository;
import com.revcart.delivery.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryAgentRepository agentRepository;

    public Delivery assignDelivery(Long orderId, Long agentId, String address) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setAgentId(agentId);
        delivery.setDeliveryAddress(address);
        delivery.setTrackingNumber("TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        delivery.setStatus("ASSIGNED");
        return deliveryRepository.save(delivery);
    }

    public Delivery trackByOrderId(Long orderId) {
        return deliveryRepository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
    }

    public Delivery trackByNumber(String trackingNumber) {
        return deliveryRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
    }

    public Delivery updateStatus(Long id, String status) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        delivery.setStatus(status);
        if ("DELIVERED".equals(status)) {
            delivery.setDeliveredAt(LocalDateTime.now());
        }
        return deliveryRepository.save(delivery);
    }

    public List<DeliveryAgent> getAvailableAgents() {
        return agentRepository.findByStatus("AVAILABLE");
    }

    public DeliveryAgent createAgent(DeliveryAgent agent) {
        return agentRepository.save(agent);
    }
}
