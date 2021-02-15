package com.atguigu.springcloud.exception;

import lombok.Getter;

/**
 * @Author i531869
 * @Date 2020/12/9 17:13
 * @Version 1.0
 */
@Getter
public class ApiException extends RuntimeException {
  private Integer code;
  private String msg;

  public ApiException() {
    this(1001, "接口错误");
  }

  public ApiException(String msg) {
    this(1001, msg);
  }

  public ApiException(Integer code, String msg) {
    super(msg);
    this.code = code;
    this.msg = msg;
  }
}
