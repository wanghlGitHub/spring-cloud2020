package com.mycloud.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: spring-cloud2020
 * @description: 支付 entity
 * @Author: heliang.wang
 * @Date: 2020/3/10 7:09 下午
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

	private Long id;
	private String serial;
}
