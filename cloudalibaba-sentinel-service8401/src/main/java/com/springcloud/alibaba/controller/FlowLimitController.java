package com.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther zzyy
 * @create 2020-02-24 16:26
 */
@RestController
@Slf4j
public class FlowLimitController {

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/testA")
  public String testA() {
    // try {
    //   Thread.sleep(200);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    // int a = 10 / 0;
    // try {
    //   Thread.sleep(300);
    // } catch (InterruptedException e) {
    //   e.printStackTrace();
    // }
    return "------testA";
  }

  @GetMapping("/testB")
  public String testB() {
    log.info(Thread.currentThread().getName() + "\t" + "...testB");
    String res = restTemplate.getForObject("http://localhost:8401/testA", String.class);
    return "------testB, 返回结果: " + res;
  }

  @GetMapping("/testC")
  public String testC() {
    log.info(Thread.currentThread().getName() + "\t" + "...testC");
    String res = restTemplate.getForObject("http://localhost:8401/testA", String.class);
    return "------testC, 返回结果: " + res;
  }

  @GetMapping("/testHotKey")
  @SentinelResource(value = "abc", blockHandler = "processBlock")
  public String testHotKey(@RequestParam(name = "p1", required = false) String p1,
      @RequestParam(name = "p2", required = false) String p2) {
    return p1 + ":" + p2;
  }

  public String processBlock(String p1,String p2, BlockException b) {
    return "------deal_testHotKey,o(╥﹏╥)o";  //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
  }
}
