package com.mycloud.fegin.service;

import com.mycloud.api.entities.CommonResult;
import com.mycloud.api.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: spring-cloud2020
 * @description: 支付接口
 * @Author: heliang.wang
 * @Date: 2020/3/15 4:29 下午
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {

	@GetMapping("/payment/get/{id}")
	CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
