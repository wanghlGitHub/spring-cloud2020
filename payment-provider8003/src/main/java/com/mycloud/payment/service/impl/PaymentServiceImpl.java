package com.mycloud.payment.service.impl;

import com.mycloud.api.entities.Payment;
import com.mycloud.payment.dao.PaymentDao;
import com.mycloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: spring-cloud2020
 * @description:
 * @Author: heliang.wang
 * @Date: 2020/3/10 7:13 下午
 * @Version: 1.0
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Resource
	PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}
