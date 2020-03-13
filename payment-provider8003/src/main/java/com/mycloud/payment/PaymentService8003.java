package com.mycloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class PaymentService8003 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentService8003.class, args);
	}
}
