package com.springcloud.alibaba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author i531869
 * @Date 2021/2/23 14:07
 * @Version 1.0
 */
@Configuration
public class MyConfig {

  @Bean
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
