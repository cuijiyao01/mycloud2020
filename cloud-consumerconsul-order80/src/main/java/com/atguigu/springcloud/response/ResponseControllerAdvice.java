package com.atguigu.springcloud.response;

import com.atguigu.springcloud.entities.ResultVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author i531869
 * @Date 2020/12/9 18:08
 * @Version 1.0
 */
@RestControllerAdvice(basePackages = "com.atguigu.springcloud.controller")
@Slf4j
public class ResponseControllerAdvice implements ResponseBodyAdvice {

  @Override
  public boolean supports(MethodParameter methodParameter, Class aClass) {
    return !methodParameter.getParameterType().equals(ResultVO.class);
  }

  @SneakyThrows
  @Override
  public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class aClass,
      ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    if (methodParameter.getGenericParameterType().equals(String.class)) {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(new ResultVO<>(data));
    }
    return new ResultVO<>(data);
  }
}
