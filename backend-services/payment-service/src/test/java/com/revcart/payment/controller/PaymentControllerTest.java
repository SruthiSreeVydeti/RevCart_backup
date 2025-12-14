package com.revcart.payment.controller;

import com.revcart.payment.dto.PaymentRequest;
import com.revcart.payment.entity.Payment;
import com.revcart.payment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @Test
    void testCreatePayment() throws Exception {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setOrderId(1L);
        payment.setAmount(BigDecimal.valueOf(150.00));
        payment.setStatus("CREATED");

        when(paymentService.createPayment(any(PaymentRequest.class))).thenReturn(payment);

        mockMvc.perform(post("/api/payments/create")
                .param("orderId", "1")
                .param("amount", "150.00")
                .param("paymentMethod", "CARD"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetPaymentByOrderId() throws Exception {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setOrderId(1L);
        payment.setAmount(BigDecimal.valueOf(150.00));
        payment.setStatus("SUCCESS");

        when(paymentService.getPaymentByOrderId(1L)).thenReturn(payment);

        mockMvc.perform(get("/api/payments/order/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").value(1))
                .andExpect(jsonPath("$.status").value("SUCCESS"));
    }

    @Test
    void testGetUserPayments() throws Exception {
        mockMvc.perform(get("/api/payments/user/1"))
                .andExpect(status().isOk());
    }
}