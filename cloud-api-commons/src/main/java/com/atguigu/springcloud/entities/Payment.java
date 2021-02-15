package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author i531869
 * @Date 2020/12/27 22:13
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment implements Serializable {
  private Long id;
  private String serial;
}
