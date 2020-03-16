package com.mycloud.fegin.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-cloud2020
 * @description:
 * @Author: heliang.wang
 * @Date: 2020/3/15 5:11 下午
 * @Version: 1.0
 */
@Configuration
public class FeignConfig {

	/**
	 * feign 的日志级别
	 * @return
	 */
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
