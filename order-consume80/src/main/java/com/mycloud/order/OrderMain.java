package com.mycloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: spring-cloud2020
 * @description: 订单主启动类
 * @Author: heliang.wang
 * @Date: 2020/3/12 1:44 下午
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain {

	public static void main(String[] args) {
		SpringApplication.run(OrderMain.class,args);
	}
}
