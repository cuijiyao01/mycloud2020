package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Author i531869
 * @Date 2020/12/27 22:10
 * @Version 1.0
 */
public interface PaymentService {
  Integer create(Payment payment);

  Payment getPymentById(Long id);
}
