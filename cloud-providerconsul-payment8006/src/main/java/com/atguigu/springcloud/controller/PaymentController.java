package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author i531869
 * @Date 2021/1/14 10:07
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

  @Value("${server.port}")
  public String serverPort;

  @GetMapping("payment/consul")
  public String paymentConsul() {
    return "springcloud with consul: " + serverPort + "\t   " + UUID.randomUUID().toString();
  }
}
