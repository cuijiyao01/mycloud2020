package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author i531869
 * @Date 2021/1/13 16:51
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZK {
  public static void main(String[] args) {
    SpringApplication.run(OrderZK.class, args);
  }
}
