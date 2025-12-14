package com.revcart.delivery.service;

import com.revcart.delivery.entity.Delivery;
import com.revcart.delivery.entity.DeliveryAgent;
import com.revcart.delivery.repository.DeliveryRepository;
import com.revcart.delivery.repository.DeliveryAgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DeliveryAnalyticsService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryAgentRepository agentRepository;

    public Map<String, Object> getAgentDashboard(Long agentId) {
        Map<String, Object> dashboard = new HashMap<>();
        List<Delivery> deliveries = deliveryRepository.findByAgentId(agentId);
        
        long totalDeliveries = deliveries.size();
        long successfulDeliveries = deliveries.stream().filter(d -> "DELIVERED".equals(d.getStatus())).count();
        long failedDeliveries = deliveries.stream().filter(d -> "FAILED".equals(d.getStatus())).count();
        
        dashboard.put("totalDeliveries", totalDeliveries);
        dashboard.put("successfulDeliveries", successfulDeliveries);
        dashboard.put("failedDeliveries", failedDeliveries);
        dashboard.put("successRate", totalDeliveries > 0 ? (successfulDeliveries * 100.0) / totalDeliveries : 0.0);
        
        return dashboard;
    }

    public Map<String, Object> getDeliveryMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        List<Delivery> allDeliveries = deliveryRepository.findAll();
        
        long totalDeliveries = allDeliveries.size();
        long successfulDeliveries = allDeliveries.stream().filter(d -> "DELIVERED".equals(d.getStatus())).count();
        long failedDeliveries = allDeliveries.stream().filter(d -> "FAILED".equals(d.getStatus())).count();
        long activeAgents = agentRepository.findByActiveTrue().size();
        
        metrics.put("totalDeliveries", totalDeliveries);
        metrics.put("successfulDeliveries", successfulDeliveries);
        metrics.put("failedDeliveries", failedDeliveries);
        metrics.put("activeAgents", activeAgents);
        
        return metrics;
    }
}
