package com.thanos.api.service;



import com.thanos.api.domain.Coupon;
import com.thanos.api.repository.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    public Coupon findById(long id) {
        return couponRepository.findOne(id);
    }
}
