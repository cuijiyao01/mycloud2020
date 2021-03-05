package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author i531869
 * @Date 2021/3/3 17:40
 * @Version 1.0
 */
@Configuration
public class MyConfig {

  @Bean
  @LoadBalanced
  public RestTemplate getTemplate() {
    return new RestTemplate();
  }
}
