package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author i531869
 * @Date 2021/1/26 21:14
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements OrderService {
  @Override
  public String paymentOk(Integer id) {
    return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
  }

  @Override
  public String paymentTimeout(Integer id) {
    return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
  }
}
