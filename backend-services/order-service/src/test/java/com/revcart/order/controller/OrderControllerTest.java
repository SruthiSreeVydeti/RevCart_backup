package com.revcart.order.controller;

import com.revcart.order.dto.OrderRequest;
import com.revcart.order.entity.Order;
import com.revcart.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void testCreateOrder() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setUserId(1L);
        order.setTotalAmount(BigDecimal.valueOf(150.00));
        order.setStatus("PENDING");
        order.setOrderNumber("ORD-12345678");

        when(orderService.createOrder(any(OrderRequest.class))).thenReturn(order);

        mockMvc.perform(post("/api/orders/create"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetUserOrders() throws Exception {
        Order order1 = new Order();
        order1.setId(1L);
        order1.setUserId(1L);
        order1.setTotalAmount(BigDecimal.valueOf(100.00));
        order1.setStatus("COMPLETED");

        Order order2 = new Order();
        order2.setId(2L);
        order2.setUserId(1L);
        order2.setTotalAmount(BigDecimal.valueOf(200.00));
        order2.setStatus("PENDING");

        List<Order> orders = Arrays.asList(order1, order2);
        when(orderService.getUserOrders(1L)).thenReturn(orders);

        mockMvc.perform(get("/api/orders/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].status").value("COMPLETED"))
                .andExpect(jsonPath("$[1].status").value("PENDING"));
    }

    @Test
    void testGetOrderById() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setUserId(1L);
        order.setTotalAmount(BigDecimal.valueOf(150.00));
        order.setStatus("COMPLETED");

        when(orderService.getOrderById(1L)).thenReturn(order);

        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.status").value("COMPLETED"));
    }
}