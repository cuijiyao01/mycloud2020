package com.atguigu.springcloud.data_enum;

import lombok.Getter;

/**
 * @Author i531869
 * @Date 2020/12/9 17:47
 * @Version 1.0
 */
@Getter
public enum ResultCodeEnum {

  SUCCESS(1000, "操作成功"),

  FAILED(1001, "响应失败"),

  VALIDATE_FAILED(1002, "参数校验失败"),

  ERROR(5000, "未知错误");

  private Integer code;
  private String msg;

  ResultCodeEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public String getMsgByCode(Integer code) {
    for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
      if (resultCodeEnum.getCode().equals(code)) {
        return resultCodeEnum.getMsg();
      }
    }
    return null;
  }

  public ResultCodeEnum getEnumByCode(Integer code) {
    for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()) {
      if (resultCodeEnum.getCode().equals(code)) {
        return resultCodeEnum;
      }
    }
    return null;
  }
}
