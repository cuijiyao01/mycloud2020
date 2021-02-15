package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author i531869
 * @Date 2021/2/15 20:07
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9001 {
  public static void main(String[] args) {
    SpringApplication.run(NacosProviderMain9001.class, args);
  }
}
