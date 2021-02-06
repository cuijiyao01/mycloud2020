package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author i531869
 * @Date 2021/2/3 20:48
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitmqProvider8801 {
  public static void main(String[] args) {
    SpringApplication.run(RabbitmqProvider8801.class, args);
  }
}
