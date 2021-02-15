package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 2021/2/15 20:13
 * @Version 1.0
 */
@RestController
@Slf4j
public class NacosProviderController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping(value = "/payment/nacos/{id}")
  public String getPayment(@PathVariable("id") Integer id) {
    return "nacos registry, serverPort: " + serverPort + "\t id" + id;
  }
}
