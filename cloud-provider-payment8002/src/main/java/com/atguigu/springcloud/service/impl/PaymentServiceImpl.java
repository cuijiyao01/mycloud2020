package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author i531869
 * @Date 2020/12/27 22:11
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentDao paymentDao;

  @Override
  public Integer create(Payment payment) {
    return paymentDao.create(payment);
  }

  @Override
  public Payment getPymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
