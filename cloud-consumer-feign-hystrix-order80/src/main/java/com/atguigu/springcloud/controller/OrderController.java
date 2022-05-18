package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 2021/1/21 20:42
 * @Version 1.0
 */
@RestController
// @DefaultProperties(defaultFallback = "paymentGlobaleFallback")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping("/consume/hystrix/ok/{id}")
  @HystrixCommand
  public String paymentOk(@PathVariable("id") Integer id) {
    // int i = 1 / 0;
    return orderService.paymentOk(id);
  }

  @GetMapping("/consume/hystrix/timeout/{id}")
  @HystrixCommand(fallbackMethod = "paymentTimeoutFallback", commandProperties = @HystrixProperty(
      name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500"
  ))
  public String paymentTimeout(@PathVariable("id") Integer id) {
    // int i = 1 / 0;
    return orderService.paymentTimeout(id);
  }

  private String paymentTimeoutFallback(@PathVariable("id") Integer id) {
    return "id:" + id + "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
  }

  private String paymentGlobaleFallback() {
    return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
  }
}
