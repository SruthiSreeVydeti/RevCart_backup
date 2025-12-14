package com.revcart.cart.service;

import com.revcart.cart.dto.CartItemRequest;
import com.revcart.cart.entity.Cart;
import com.revcart.cart.entity.CartItem;
import com.revcart.cart.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartService cartService;

    private Cart cart;
    private CartItem cartItem;
    private CartItemRequest cartItemRequest;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        cart.setId(1L);
        cart.setUserId(1L);
        cart.setItems(new ArrayList<>());

        cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setProductId(100L);
        cartItem.setProductName("Test Product");
        cartItem.setQuantity(2);
        cartItem.setPrice(BigDecimal.valueOf(50.00));
        cartItem.setCart(cart);

        cartItemRequest = new CartItemRequest();
        cartItemRequest.setProductId(100L);
        cartItemRequest.setProductName("Test Product");
        cartItemRequest.setQuantity(2);
        cartItemRequest.setPrice(BigDecimal.valueOf(50.00));
    }

    @Test
    void testGetCartByUserIdExists() {
        when(cartRepository.findByUserId(anyLong())).thenReturn(Optional.of(cart));

        Cart result = cartService.getCartByUserId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        verify(cartRepository).findByUserId(1L);
    }

    @Test
    void testGetCartByUserIdNotExists() {
        when(cartRepository.findByUserId(anyLong())).thenReturn(Optional.empty());
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart result = cartService.getCartByUserId(1L);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        verify(cartRepository).save(any(Cart.class));
    }

    @Test
    void testAddItemToCartNewItem() {
        when(cartRepository.findByUserId(anyLong())).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart result = cartService.addItemToCart(1L, cartItemRequest);

        assertNotNull(result);
        verify(cartRepository).save(any(Cart.class));
    }

    @Test
    void testAddItemToCartExistingItem() {
        cart.getItems().add(cartItem);
        when(cartRepository.findByUserId(anyLong())).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart result = cartService.addItemToCart(1L, cartItemRequest);

        assertNotNull(result);
        assertEquals(4, cart.getItems().get(0).getQuantity()); // 2 + 2
        verify(cartRepository).save(any(Cart.class));
    }

    @Test
    void testRemoveItemFromCart() {
        cart.getItems().add(cartItem);
        when(cartRepository.findByUserId(anyLong())).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart result = cartService.removeItemFromCart(1L, 100L);

        assertNotNull(result);
        assertTrue(cart.getItems().isEmpty());
        verify(cartRepository).save(any(Cart.class));
    }

    @Test
    void testClearCart() {
        cart.getItems().add(cartItem);
        when(cartRepository.findByUserId(anyLong())).thenReturn(Optional.of(cart));

        cartService.clearCart(1L);

        assertTrue(cart.getItems().isEmpty());
        verify(cartRepository).save(any(Cart.class));
    }
}