package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author i531869
 * @Date 2021/1/21 20:29
 * @Version 1.0
 */
@Service
public class PaymentService {
  /**
   * 正常访问，肯定OK
   *
   * @param id
   * @return
   */
  public String paymentInfo_OK(Integer id) {
    return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_OK,id:  " + id + "\t" + "O(∩_∩)O哈哈~";
  }

  @HystrixCommand(fallbackMethod = "paymentInfo_fallback",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
      })
  public String paymentInfo_TimeOut(Integer id) {
    // int age = 10/0;
    try {
      TimeUnit.MILLISECONDS.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "O(∩_∩)O哈哈~" + "  耗时(秒): ";
  }

  private String paymentInfo_fallback(Integer id) {
    return "线程池:  " + Thread.currentThread().getName() + "  8001系统繁忙或者运行报错，请稍后再试,id:  " + id + "\t" + "o(╥﹏╥)o";
  }

  @HystrixCommand(fallbackMethod ="paymentCircuit_fallback",commandProperties = {
      @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
  })
  public String paymentCircuit(Integer id) {
    if (id < 0) {
      throw new RuntimeException("=====id不能为负数");
    }
    String serial = IdUtil.simpleUUID();
    return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serial;
  }

  private String paymentCircuit_fallback(Integer id) {
    return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
  }

}
