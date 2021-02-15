package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.data_enum.ResultCodeEnum;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.ResultVO;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author i531869
 * @Date 2020/12/27 22:21
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @Autowired
  private DiscoveryClient discoveryClient;

  @PostMapping("payment")
  public ResultVO<String> create(@RequestBody Payment payment) {
    int res = paymentService.create(payment);
    if (res > 0) {
      return new ResultVO<String>("插入成功!");
    }
    return new ResultVO<String>(ResultCodeEnum.FAILED, "插入失败!");
  }

  @GetMapping("payment/{id}")
  public Payment getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPymentById(id);
    payment.setSerial(payment.getSerial() + ", serverPort: " + serverPort);
    return payment;
  }

  @GetMapping("payment/discovery")
  public Object discovery() {
    List<String> services = discoveryClient.getServices();
    System.out.println(services);
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    for (ServiceInstance instance : instances) {
      System.out.println(
          instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
    }
    return discoveryClient;
  }

  @GetMapping("/payment/lb")
  public String getPaymentlb() {
    return serverPort;
  }

  @GetMapping("/payment/timeout")
  public String paymentTimeout() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return serverPort + ": Not Timeout";
  }

  @GetMapping("/payment/zipkin")
  public String paymentZipkin() {
    return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
  }

}
