package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 2021/1/20 21:32
 * @Version 1.0
 */
@RestController
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/consume/payment/{id}")
  public Payment getPayment(@PathVariable("id") Integer id) {
    return orderService.getPayment(id);
  }

  @GetMapping("/consume/payment/timeout")
  public String paymentTimeout() {
    return orderService.paymentTimeout();
  }
}
