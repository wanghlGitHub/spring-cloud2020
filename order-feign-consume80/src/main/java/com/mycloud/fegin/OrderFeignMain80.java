package com.mycloud.fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: spring-cloud2020
 * @description: feign 负载均衡
 * @Author: heliang.wang
 * @Date: 2020/3/15 4:28 下午
 * @Version: 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderFeignMain80.class,args);
	}
}
