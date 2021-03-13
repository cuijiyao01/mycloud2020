package com.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author i531869
 * @Date 2021/3/8 15:36
 * @Version 1.0
 */
@Mapper
public interface StorageDao {
  //扣减库存
  void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
