package com.mycloud.fegin.controller;

import com.mycloud.api.entities.CommonResult;
import com.mycloud.api.entities.Payment;
import com.mycloud.fegin.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: spring-cloud2020
 * @description:
 * @Author: heliang.wang
 * @Date: 2020/3/15 4:31 下午
 * @Version: 1.0
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping("/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		return paymentFeignService.getPayment(id);
	}
}
