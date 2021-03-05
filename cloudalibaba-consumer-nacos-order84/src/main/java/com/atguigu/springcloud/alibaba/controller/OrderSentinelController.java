package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.springcloud.alibaba.exception_handler.PaymentBlockerHandler;
import com.atguigu.springcloud.alibaba.exception_handler.PaymentFallbackHandler;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author i531869
 * @Date 2021/3/3 17:39
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderSentinelController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PaymentService paymentService;

  public static final String SERVICE_URL = "http://nacos-payment-provider";

  @GetMapping("/con/fallback/{id}")
  @SentinelResource(value = "consumeFallback", fallbackClass = PaymentFallbackHandler.class, fallback = "handleFallback",
      blockHandlerClass = PaymentBlockerHandler.class, blockHandler = "handleBlock")
  public Payment fallback(@PathVariable("id") Long id) {
    // Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,CommonResult.class,id);

    if (id == 4) {
      throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
    } else {
      throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
    }
  }

  @GetMapping("/consume/fallback/{id}")
  @SentinelResource(value = "feignFallback", fallbackClass = PaymentFallbackHandler.class, fallback = "handleFallback"
      , blockHandlerClass = PaymentBlockerHandler.class, blockHandler = "handleBlock")
  public Payment getPaymentBySentinel(@PathVariable("id") Long id) {
    return paymentService.getPaymentBySentinel(id);
  }
  //
  // public Payment handleFallback(@PathVariable("id") Long id) {
  //   return new Payment(1l, "feign 降级, 降级异常: ");
  // }

}
