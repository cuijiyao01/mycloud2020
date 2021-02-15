package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author i531869
 * @Date 2021/1/20 21:35
 * @Version 1.0
 */
@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface OrderService {

  @GetMapping("/payment/{id}")
  Payment getPayment(@PathVariable("id") Integer id);

  @GetMapping("/payment/timeout")
  String paymentTimeout();
}
