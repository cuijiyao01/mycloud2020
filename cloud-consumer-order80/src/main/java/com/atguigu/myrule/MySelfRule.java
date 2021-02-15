package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author i531869
 * @Date 2021/1/19 17:11
 * @Version 1.0
 */
@Configuration
public class MySelfRule {
  @Bean
  public IRule myRule(){
    return new RandomRule();
  }
}
