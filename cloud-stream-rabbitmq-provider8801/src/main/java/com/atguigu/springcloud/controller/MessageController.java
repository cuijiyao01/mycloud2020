package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author i531869
 * @Date 2021/2/3 21:07
 * @Version 1.0
 */
@RestController
@Slf4j
public class MessageController {
  @Autowired
  IMessageProvider messageProvider;

  @GetMapping("sendMessage")
  public String send() {
    return messageProvider.send();
  }
}
