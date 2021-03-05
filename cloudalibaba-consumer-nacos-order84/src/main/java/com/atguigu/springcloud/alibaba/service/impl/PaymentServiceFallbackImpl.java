package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author i531869
 * @Date 2021/3/3 17:36
 * @Version 1.0
 */
@Component
public class PaymentServiceFallbackImpl implements PaymentService {
  @Override
  public Payment getPaymentBySentinel(Long id) {
    return new Payment(100L, "服务降级返回,---PaymentFallbackService");
  }
}
