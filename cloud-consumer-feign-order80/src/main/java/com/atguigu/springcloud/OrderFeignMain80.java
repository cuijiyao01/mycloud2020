package com.atguigu.springcloud;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

/**
 * @Author i531869
 * @Date 2021/1/20 17:58
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderFeignMain80 {
  public static void main(String[] args) {
    SpringApplication.run(OrderFeignMain80.class, args);
    Date date = new Date();
    DateTime dateTime = DateUtil.date(1611196313974L);
    System.out.println("时间:" + dateTime);
  }
}
