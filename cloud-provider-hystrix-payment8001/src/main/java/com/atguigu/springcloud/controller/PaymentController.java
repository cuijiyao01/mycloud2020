package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 2021/1/21 20:29
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
  @Autowired
  private PaymentService paymentService;

  /**
   * 正常访问，肯定OK
   *
   * @param id
   * @return
   */
  @GetMapping("/payment/hystrix/ok/{id}")
  public String paymentInfo_OK(@PathVariable("id") Integer id) {
    return paymentService.paymentInfo_OK(id);
  }

  @GetMapping("/payment/hystrix/timeout/{id}")
  public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
    return paymentService.paymentInfo_TimeOut(id);
  }

  @GetMapping("payment/circuit/{id}")
  public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
    String result = paymentService.paymentCircuit(id);
    log.info("****result: " + result);
    return result;
  }
}
