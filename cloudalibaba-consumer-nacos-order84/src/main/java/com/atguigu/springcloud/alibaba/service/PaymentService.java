package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.service.impl.PaymentServiceFallbackImpl;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author i531869
 * @Date 2021/3/3 17:31
 * @Version 1.0
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceFallbackImpl.class)
public interface PaymentService {

  @GetMapping("/paymentSentinel/{id}")
  Payment getPaymentBySentinel(@PathVariable("id") Long id);
}
