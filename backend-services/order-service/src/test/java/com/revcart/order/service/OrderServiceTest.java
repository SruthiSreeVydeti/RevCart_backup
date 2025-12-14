package com.revcart.order.service;

import com.revcart.order.dto.OrderRequest;
import com.revcart.order.entity.Order;
import com.revcart.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;
    private OrderRequest orderRequest;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.setId(1L);
        order.setUserId(1L);
        order.setOrderNumber("ORD-12345678");
        order.setTotalAmount(BigDecimal.valueOf(150.00));
        order.setStatus("PENDING");
        order.setPaymentMethod("CARD");

        orderRequest = new OrderRequest();
        orderRequest.setUserId(1L);
        orderRequest.setTotalAmount(BigDecimal.valueOf(150.00));
        orderRequest.setPaymentMethod("CARD");
        orderRequest.setShippingAddress("123 Test Street");
        orderRequest.setItems(new ArrayList<>());
    }

    @Test
    void testCreateOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.createOrder(orderRequest);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        assertEquals(BigDecimal.valueOf(150.00), result.getTotalAmount());
        assertEquals("PENDING", result.getStatus());
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void testGetUserOrders() {
        List<Order> orders = Arrays.asList(order);
        when(orderRepository.findByUserId(anyLong())).thenReturn(orders);

        List<Order> result = orderService.getUserOrders(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getUserId());
        verify(orderRepository).findByUserId(1L);
    }

    @Test
    void testGetOrderById() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        Order result = orderService.getOrderById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(orderRepository).findById(1L);
    }

    @Test
    void testGetOrderByIdNotFound() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> orderService.getOrderById(1L));
    }

    @Test
    void testGetOrderByNumber() {
        when(orderRepository.findByOrderNumber(anyString())).thenReturn(Optional.of(order));

        Order result = orderService.getOrderByNumber("ORD-12345678");

        assertNotNull(result);
        assertEquals("ORD-12345678", result.getOrderNumber());
        verify(orderRepository).findByOrderNumber("ORD-12345678");
    }

    @Test
    void testUpdateOrderStatus() {
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order result = orderService.updateOrderStatus(1L, "COMPLETED");

        assertNotNull(result);
        assertEquals("COMPLETED", result.getStatus());
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    void testGetOrdersByStatus() {
        List<Order> orders = Arrays.asList(order);
        when(orderRepository.findByStatus(anyString())).thenReturn(orders);

        List<Order> result = orderService.getOrdersByStatus("PENDING");

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(orderRepository).findByStatus("PENDING");
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = Arrays.asList(order);
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAllOrders();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(orderRepository).findAll();
    }
}