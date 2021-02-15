package com.atguigu.springcloud.exception;

import com.atguigu.springcloud.data_enum.ResultCodeEnum;
import com.atguigu.springcloud.entities.ResultVO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author i531869
 * @Date 2020/12/9 17:02
 * @Version 1.0
 */
@RestControllerAdvice(basePackages = "com.atguigu.springcloud.controller")
public class ExceptionControllerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
    return new ResultVO<>(ResultCodeEnum.VALIDATE_FAILED, exception.getMessage());
  }

  /**
   * 自定义异常
   *
   * @param apiException
   * @return
   */
  @ExceptionHandler(ApiException.class)
  public ResultVO<String> ApiExceptionHandler(ApiException apiException) {
    return new ResultVO<>(ResultCodeEnum.FAILED, apiException.getMsg());
  }
}
