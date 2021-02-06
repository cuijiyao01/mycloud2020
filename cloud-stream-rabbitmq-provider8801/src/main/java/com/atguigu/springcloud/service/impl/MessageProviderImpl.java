package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author i531869
 * @Date 2021/2/3 20:53
 * @Version 1.0
 */
@EnableBinding({Source.class})
public class MessageProviderImpl implements IMessageProvider {

  @Resource
  private MessageChannel output; // 消息发送管道

  @Override
  public String send() {
    String serial = UUID.randomUUID().toString();
    Message message = MessageBuilder.withPayload(serial).build();
    output.send(message);
    System.out.println("*******serial: " + serial);
    return null;
  }
}
