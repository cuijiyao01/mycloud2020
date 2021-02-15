package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author i531869
 * @Date 2021/1/14 20:36
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {
  @Autowired
  private RestTemplate restTemplate;

  private String url = "http://consul-provider-payment";

  @GetMapping("/consume/consul")
  public String consumeConsul() {
    return restTemplate.getForObject(url+"/payment/consul", String.class);
  }
}

