package com.atguigu.springcloud.alibaba.exception_handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author i531869
 * @Date 2021/3/3 17:51
 * @Version 1.0
 */
public class PaymentBlockerHandler {
  public static Payment handleBlock(@PathVariable("id") Long id , BlockException e){
    return new Payment(400l, "BlockerHandler异常: " + e.getMessage());
  }
}
