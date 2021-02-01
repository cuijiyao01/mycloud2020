package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author i531869
 * @Date 2021/2/1 20:05
 * @Version 1.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain {
  public static void main(String[] args) {
    SpringApplication.run(ConfigCenterMain.class, args);
  }
}
