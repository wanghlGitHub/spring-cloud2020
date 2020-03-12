package com.mycloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: spring-cloud2020
 * @description: eureka 服务注册中心
 * @Author: heliang.wang
 * @Date: 2020/3/12 3:38 下午
 * @Version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerMain.class,args);
	}
}
