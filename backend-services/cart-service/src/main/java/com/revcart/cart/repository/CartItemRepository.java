package com.revcart.cart.repository;

import com.revcart.cart.entity.Cart;
import com.revcart.cart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartAndProductId(Cart cart, Long productId);
    void deleteByCart(Cart cart);
    
    @Modifying
    @Query("DELETE FROM CartItem")
    void deleteAllCartItems();
}