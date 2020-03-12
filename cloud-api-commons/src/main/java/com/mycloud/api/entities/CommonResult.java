package com.mycloud.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: spring-cloud2020
 * @description: 返回结果处理
 * @Author: heliang.wang
 * @Date: 2020/3/10 7:35 下午
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
public class CommonResult<T> {

	private Integer code;
	private String msg;
	private T	data;

	public CommonResult(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = null;
	}
}
