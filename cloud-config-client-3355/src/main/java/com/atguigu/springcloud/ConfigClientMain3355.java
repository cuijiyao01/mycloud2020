package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author i531869
 * @Date 2021/2/1 20:37
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {
  public static void main(String[] args) {
    SpringApplication.run(ConfigClientMain3355.class, args);
  }
}
