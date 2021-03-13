package com.springcloud.alibaba.service;

import com.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author i531869
 * @Date 2021/3/5 17:45
 * @Version 1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
  @PostMapping(value = "/account/decrease")
  CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
