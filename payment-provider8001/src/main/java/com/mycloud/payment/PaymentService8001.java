package com.mycloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: spring-cloud2020
 * @description: 支付模块 启动类
 * @Author: heliang.wang
 * @Date: 2020/3/10 4:32 下午
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //启动服务发现
@EnableCircuitBreaker //服务熔断降级
public class PaymentService8001 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentService8001.class, args);
	}
}
