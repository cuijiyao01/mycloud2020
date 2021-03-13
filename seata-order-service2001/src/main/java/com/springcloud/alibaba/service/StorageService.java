package com.springcloud.alibaba.service;

import com.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author i531869
 * @Date 2021/3/5 17:51
 * @Version 1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

  @PostMapping("/storage/decrease")
  CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
