package com.revcart.delivery.service;

import com.revcart.delivery.entity.Delivery;
import com.revcart.delivery.entity.DeliveryAgent;
import com.revcart.delivery.repository.DeliveryRepository;
import com.revcart.delivery.repository.DeliveryAgentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private DeliveryAgentRepository agentRepository;

    @InjectMocks
    private DeliveryService deliveryService;

    private Delivery delivery;
    private DeliveryAgent agent;

    @BeforeEach
    void setUp() {
        delivery = new Delivery();
        delivery.setId(1L);
        delivery.setOrderId(1L);
        delivery.setAgentId(1L);
        delivery.setDeliveryAddress("123 Test Street");
        delivery.setStatus("ASSIGNED");
        delivery.setTrackingNumber("TRK123456");
        
        agent = new DeliveryAgent();
        agent.setId(1L);
        agent.setName("John Doe");
        agent.setStatus("AVAILABLE");
    }

    @Test
    void testAssignDelivery() {
        when(deliveryRepository.save(any(Delivery.class))).thenReturn(delivery);

        Delivery result = deliveryService.assignDelivery(1L, 1L, "123 Test Street");

        assertNotNull(result);
        assertEquals(1L, result.getOrderId());
        assertEquals("ASSIGNED", result.getStatus());
        verify(deliveryRepository).save(any(Delivery.class));
    }

    @Test
    void testTrackByOrderId() {
        when(deliveryRepository.findByOrderId(anyLong())).thenReturn(Optional.of(delivery));

        Delivery result = deliveryService.trackByOrderId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getOrderId());
        verify(deliveryRepository).findByOrderId(1L);
    }

    @Test
    void testTrackByOrderIdNotFound() {
        when(deliveryRepository.findByOrderId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> deliveryService.trackByOrderId(1L));
    }

    @Test
    void testTrackByNumber() {
        when(deliveryRepository.findByTrackingNumber(anyString())).thenReturn(Optional.of(delivery));

        Delivery result = deliveryService.trackByNumber("TRK123456");

        assertNotNull(result);
        assertEquals("TRK123456", result.getTrackingNumber());
        verify(deliveryRepository).findByTrackingNumber("TRK123456");
    }

    @Test
    void testTrackByNumberNotFound() {
        when(deliveryRepository.findByTrackingNumber(anyString())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> deliveryService.trackByNumber("TRK123456"));
    }

    @Test
    void testUpdateStatus() {
        when(deliveryRepository.findById(anyLong())).thenReturn(Optional.of(delivery));
        when(deliveryRepository.save(any(Delivery.class))).thenReturn(delivery);

        Delivery result = deliveryService.updateStatus(1L, "DELIVERED");

        assertNotNull(result);
        verify(deliveryRepository).findById(1L);
        verify(deliveryRepository).save(any(Delivery.class));
    }

    @Test
    void testUpdateStatusNotFound() {
        when(deliveryRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> deliveryService.updateStatus(1L, "DELIVERED"));
    }

    @Test
    void testGetAvailableAgents() {
        List<DeliveryAgent> agents = Arrays.asList(agent);
        when(agentRepository.findByStatus(anyString())).thenReturn(agents);

        List<DeliveryAgent> result = deliveryService.getAvailableAgents();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(agentRepository).findByStatus("AVAILABLE");
    }

    @Test
    void testCreateAgent() {
        when(agentRepository.save(any(DeliveryAgent.class))).thenReturn(agent);

        DeliveryAgent result = deliveryService.createAgent(agent);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        verify(agentRepository).save(agent);
    }
}