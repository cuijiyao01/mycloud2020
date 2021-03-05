package com.atguigu.springcloud.alibaba.exception_handler;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author i531869
 * @Date 2021/3/4 19:54
 * @Version 1.0
 */
public class PaymentFallbackHandler {
  public static Payment handleFallback(@PathVariable("id") Long id, Throwable e) {
    return new Payment(300l, "FallbackHandler降级异常: " + e.getMessage());
  }
}
