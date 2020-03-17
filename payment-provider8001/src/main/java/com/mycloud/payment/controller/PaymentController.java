package com.mycloud.payment.controller;

import com.mycloud.api.entities.CommonResult;
import com.mycloud.api.entities.Payment;
import com.mycloud.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: spring-cloud2020
 * @description:
 * @Author: heliang.wang
 * @Date: 2020/3/10 7:37 下午
 * @Version: 1.0
 */
@RestController
@RequestMapping("/payment")
//全局的服务降级方法，方法上标注 @HystrixCommand 注解的，有指定具体兜底的方法，使用指定的，没有指定的，使用全局的
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Value("${server.port}")
	private Integer port;

	@Resource
	DiscoveryClient discoveryClient;

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

	@GetMapping("/discovery")
	@HystrixCommand //服务降级，但是未指定兜底方法，使用默认的
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			System.out.println("服务发现，服务名===== " + service);
			System.out.println("服务发现，服务名===== " + service);
		}

		List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-SERVICE");
		for (ServiceInstance instance : instances) {
			System.out.println("PAYMENT-SERVICE 服务实例的 URI ：" + instance.getUri());
		}
		return this.discoveryClient;
	}

	@GetMapping("/ok/{id}")
	public String testOk(@PathVariable("id") Long id) {
		return "压测 ok,id ===== " + id;
	}

	@GetMapping("/timeOut/{id}")
	@HystrixCommand(fallbackMethod = "timeOutFallBack",
			commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")})
	public String testTimeOut(@PathVariable("id") Long id) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "压测 timeOut,id ===== " + id;
	}

	public String timeOutFallBack(@PathVariable("id") Long id) {
		return "服务忙，请稍后再试！" + id;
	}

	public String defaultFallbackMethod() {
		return "服务忙，请稍后再试！服务已降级";
	}

}
