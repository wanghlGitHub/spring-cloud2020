package com.mycloud.order.controller;

import com.mycloud.api.entities.CommonResult;
import com.mycloud.api.entities.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program: spring-cloud2020
 * @description: 订单 controller
 * @Author: heliang.wang
 * @Date: 2020/3/12 1:45 下午
 * @Version: 1.0
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderController {

	public static final String PAYMENT_URL = "http://localhost:8001";

	@Resource
	RestTemplate restTemplate;

	@PostMapping("/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForEntity(PAYMENT_URL + "/payment/create",payment, CommonResult.class).getBody();
	}

	@GetMapping("/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id ){
		return restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id,CommonResult.class).getBody();
	}
}
