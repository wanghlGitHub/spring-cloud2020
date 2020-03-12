package com.mycloud.payment.service;


import com.mycloud.api.entities.Payment;

/**
 * @program: spring-cloud2020
 * @description:
 * @Author: heliang.wang
 * @Date: 2020/3/10 7:12 下午
 */
public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentById(Long id);
}
