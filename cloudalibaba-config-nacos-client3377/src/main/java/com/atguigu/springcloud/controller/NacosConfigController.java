package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 2021/2/15 10:24
 * @Version 1.0
 */
@RestController
@Slf4j
@RefreshScope
public class NacosConfigController {

  @Value("${config.info}")
  private String configInfo;

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("nacos/config")
  public String getPort() {
    return configInfo + "  serverport: " + serverPort;
  }
}
