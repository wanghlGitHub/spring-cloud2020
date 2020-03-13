package com.mycloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: spring-cloud2020
 * @description: 订单配置类
 * @Author: heliang.wang
 * @Date: 2020/3/12 1:46 下午
 * @Version: 1.0
 */
@Configuration
public class OrderConfig {

	@Bean
	@LoadBalanced //ribbon 负载均衡配置
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
