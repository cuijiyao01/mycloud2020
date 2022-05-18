package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.ResultVO;
import com.atguigu.springcloud.lb.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther zzyy
 * @create 2020-02-18 17:23
 */
@RestController
@Slf4j
public class OrderController {
  // public static final String PAYMENT_URL = "http://localhost:8001";

  public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
  public static final String GATEWAY_URL = "http://CLOUD-GATEWAY";

  @Resource
  private RestTemplate restTemplate;

  @Resource
  private ILoadBalancer loadBalancer;
  @Resource
  private DiscoveryClient discoveryClient;

  @GetMapping("/consumer/payment/create")
  public ResultVO<String> create(Payment payment) {
    return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, ResultVO.class);
  }

  @GetMapping("/consumer/payment/{id}")
  public Payment getPayment(@PathVariable("id") Long id) {
    return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, Payment.class);
  }

  @GetMapping(value = "/consumer/payment/lb")
  public String getPaymentLB(HttpServletRequest request) {
    List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    String uname = request.getParameter("uname");
    Map<String, String> map = new HashMap<>();
    map.put("uname",uname);
    if (instances == null || instances.size() <= 0) {
      return null;
    }

    ServiceInstance serviceInstance = loadBalancer.instances(instances);
    URI uri = serviceInstance.getUri();
    System.out.println(uri);
    return restTemplate.getForObject(GATEWAY_URL + "/payment/lb?uname="+uname, String.class, map);
  }

  @GetMapping("/consume/zipkin")
  public String paymentZipkin() {
    String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    return result;
  }
}
