package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author i531869
 * @Date 2021/1/4 21:05
 * @Version 1.0
 */
public interface ILoadBalancer {
  ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
