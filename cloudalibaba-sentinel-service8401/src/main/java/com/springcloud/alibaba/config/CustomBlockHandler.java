package com.springcloud.alibaba.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author i531869
 * @Date 2021/2/26 19:17
 * @Version 1.0
 */
public class CustomBlockHandler {
  public static String handleException(BlockException b) {
    return "自定义blockhandler异常";
  }
}
