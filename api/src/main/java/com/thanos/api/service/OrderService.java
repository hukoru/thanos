package com.thanos.api.service;

import com.thanos.api.domain.Coupon;
import com.thanos.api.domain.Order;
import com.thanos.api.repository.CouponRepository;
import com.thanos.api.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CouponRepository couponRepository;


    public Order order() {
        final Order order = Order.builder().price(1_0000).build(); // 10,000 상품주문
        Coupon coupon = couponRepository.getOne(1L);    // 1,000 할인 쿠폰
      //  Coupon coupon = couponService.findById(1);
        order.applyCoupon(coupon);
        return orderRepository.save(order);
    }

    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }
}
