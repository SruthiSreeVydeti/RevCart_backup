package com.revcart.cart.controller;

import com.revcart.cart.dto.CartItemRequest;
import com.revcart.cart.entity.Cart;
import com.revcart.cart.entity.CartItem;
import com.revcart.cart.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CartController.class)
class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @Test
    void testGetCart() throws Exception {
        Cart cart = new Cart();
        cart.setId(1L);
        cart.setUserId(1L);

        CartItem item = new CartItem();
        item.setId(1L);
        item.setProductId(100L);
        item.setProductName("Test Product");
        item.setQuantity(2);
        item.setPrice(BigDecimal.valueOf(50.00));

        cart.setItems(Arrays.asList(item));

        when(cartService.getCartByUserId(1L)).thenReturn(cart);

        mockMvc.perform(get("/api/cart/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.items[0].productName").value("Test Product"))
                .andExpect(jsonPath("$.items[0].quantity").value(2));
    }

    @Test
    void testAddToCart() throws Exception {
        Cart cart = new Cart();
        cart.setUserId(1L);
        
        when(cartService.addItemToCart(eq(1L), any(CartItemRequest.class))).thenReturn(cart);

        mockMvc.perform(post("/api/cart/1/add")
                .param("productId", "100")
                .param("quantity", "2"))
                .andExpect(status().isOk());
    }

    @Test
    void testRemoveFromCart() throws Exception {
        Cart cart = new Cart();
        cart.setUserId(1L);
        
        when(cartService.removeItemFromCart(1L, 100L)).thenReturn(cart);

        mockMvc.perform(delete("/api/cart/1/remove/100"))
                .andExpect(status().isOk());
    }
}