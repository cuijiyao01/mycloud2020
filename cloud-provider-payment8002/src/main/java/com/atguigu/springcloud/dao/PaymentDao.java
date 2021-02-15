package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author i531869
 * @Date 2020/12/27 22:10
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
  Integer create(Payment payment);

  Payment getPaymentById(Long id);
}
