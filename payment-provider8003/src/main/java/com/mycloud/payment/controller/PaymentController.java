package com.mycloud.payment.controller;

import com.mycloud.api.entities.CommonResult;
import com.mycloud.api.entities.Payment;
import com.mycloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @program: spring-cloud2020
 * @description:
 * @Author: heliang.wang
 * @Date: 2020/3/10 7:37 下午
 * @Version: 1.0
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Value("${server.port}")
	private Integer port;

	@PostMapping("/create")
	public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		if (result > 0) {
			return new CommonResult(200, "创建成功！端口号：" + port, result);
		} else {
			return new CommonResult(400, "创建失败！端口号：" + port);
		}
	}

	@GetMapping("/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		if (payment != null) {
			return new CommonResult(200, "成功查询到结果,端口号：" + port, payment);

		} else {
			return new CommonResult(400, "查询结果不存在，端口号：" + port + ",ID为：" + id);
		}
	}

}
