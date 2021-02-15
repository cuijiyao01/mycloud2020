package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author i531869
 * @Date 2021/1/4 21:06
 * @Version 1.0
 */
@Component
public class MyLoadBalancer implements ILoadBalancer {

  private AtomicInteger atomicInteger = new AtomicInteger(0);

  @Override
  public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
    int index = getAndIncrement() % serviceInstances.size();
    return serviceInstances.get(index);
  }

  private int getAndIncrement() {
    int current;
    int next;
    do {
      current = atomicInteger.get();
      next = current > Integer.MAX_VALUE ? 0 : current + 1;
    } while (!atomicInteger.compareAndSet(current, next));
    System.out.println("第几次访问:" + next);
    return next;
  }
}
