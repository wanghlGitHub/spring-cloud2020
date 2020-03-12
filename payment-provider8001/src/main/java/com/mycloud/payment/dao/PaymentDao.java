package com.mycloud.payment.dao;

import com.mycloud.api.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: spring-cloud2020
 * @description: 支付 dao
 * @Author: heliang.wang
 * @Date: 2020/3/10 7:11 下午
 */
@Mapper
public interface PaymentDao {

	int create(Payment payment);

	Payment getPaymentById(@Param("id") Long id);

}
