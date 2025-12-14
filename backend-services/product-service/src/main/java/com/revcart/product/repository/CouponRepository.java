package com.revcart.product.repository;

import com.revcart.product.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    List<Coupon> findByActiveTrue();
    Optional<Coupon> findByCode(String code);
}
