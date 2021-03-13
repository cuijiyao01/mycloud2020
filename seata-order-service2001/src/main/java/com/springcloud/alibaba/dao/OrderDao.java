package com.springcloud.alibaba.dao;

import com.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author i531869
 * @Date 2021/3/5 15:43
 * @Version 1.0
 */
@Mapper
public interface OrderDao {
  //1 新建订单
  void create(Order order);

  //2 修改订单状态，从零改为1
  void update(@Param("userId") Long userId,@Param("status") Integer status);
}
