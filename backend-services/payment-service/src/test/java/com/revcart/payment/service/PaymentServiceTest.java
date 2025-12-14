package com.revcart.payment.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.revcart.payment.dto.PaymentRequest;
import com.revcart.payment.dto.PaymentVerifyRequest;
import com.revcart.payment.entity.Payment;
import com.revcart.payment.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private RazorpayClient razorpayClient;

    @InjectMocks
    private PaymentService paymentService;

    private Payment payment;
    private PaymentRequest paymentRequest;
    private PaymentVerifyRequest verifyRequest;

    @BeforeEach
    void setUp() {
        payment = new Payment();
        payment.setId(1L);
        payment.setOrderId(1L);
        payment.setUserId(1L);
        payment.setAmount(BigDecimal.valueOf(150.00));
        payment.setPaymentMethod("CARD");
        payment.setStatus("CREATED");
        payment.setRazorpayOrderId("order_123");

        paymentRequest = new PaymentRequest();
        paymentRequest.setOrderId(1L);
        paymentRequest.setUserId(1L);
        paymentRequest.setAmount(BigDecimal.valueOf(150.00));
        paymentRequest.setPaymentMethod("CARD");

        verifyRequest = new PaymentVerifyRequest();
        verifyRequest.setRazorpayOrderId("order_123");
        verifyRequest.setRazorpayPaymentId("pay_123");
        verifyRequest.setRazorpaySignature("signature_123");
    }

    @Test
    void testGetUserPayments() {
        List<Payment> payments = Arrays.asList(payment);
        when(paymentRepository.findByUserId(anyLong())).thenReturn(payments);

        List<Payment> result = paymentService.getUserPayments(1L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getUserId());
        verify(paymentRepository).findByUserId(1L);
    }

    @Test
    void testGetPaymentByOrderId() {
        when(paymentRepository.findByOrderId(anyLong())).thenReturn(Optional.of(payment));

        Payment result = paymentService.getPaymentByOrderId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getOrderId());
        verify(paymentRepository).findByOrderId(1L);
    }

    @Test
    void testGetPaymentByOrderIdNotFound() {
        when(paymentRepository.findByOrderId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> paymentService.getPaymentByOrderId(1L));
    }

    @Test
    void testVerifyPayment() throws Exception {
        when(paymentRepository.findByRazorpayOrderId(anyString())).thenReturn(Optional.of(payment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment result = paymentService.verifyPayment(verifyRequest);

        assertNotNull(result);
        assertEquals("SUCCESS", result.getStatus());
        assertEquals("pay_123", result.getRazorpayPaymentId());
        verify(paymentRepository).save(any(Payment.class));
    }

    @Test
    void testVerifyPaymentNotFound() {
        when(paymentRepository.findByRazorpayOrderId(anyString())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> paymentService.verifyPayment(verifyRequest));
    }
}