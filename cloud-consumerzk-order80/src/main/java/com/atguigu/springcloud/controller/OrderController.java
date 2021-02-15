package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author i531869
 * @Date 2021/1/13 16:54
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

  @Autowired
  private RestTemplate restTemplate;

  private String url = "http://cloud-provider-payment";
  // private String url = "http://localhost:8004";

  @GetMapping("/consume/zk")
  public String consumezk() {
    return restTemplate.getForObject(url + "/payment/zk", String.class);
  }
}
