package com.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.alibaba.config.CustomBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 2021/2/26 19:02
 * @Version 1.0
 */
@RestController
public class RateLimitController {

  @GetMapping("/byResource")
  @SentinelResource(value = "byResource", blockHandler = "handleException")
  public String byResource() {
    return "按资源名称限流测试OK";
  }

  public String handleException(BlockException exception) {
    return "服务不可用";
  }

  @GetMapping("/rateLimit/byUrl")
  @SentinelResource(value = "byUrl")
  public String byUrl() {
    return "按url限流测试OK";
  }

  @GetMapping("/rateLimit/custom")
  @SentinelResource(value = "custom", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException")
  public String byCustom() {
    return "自定义正常";
  }

}
