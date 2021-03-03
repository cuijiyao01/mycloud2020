package com.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author i531869
 * @Date 2021/2/18 18:03
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8401 {
  public static void main(String[] args) {
    SpringApplication.run(SentinelMain8401.class, args);
  }
}
