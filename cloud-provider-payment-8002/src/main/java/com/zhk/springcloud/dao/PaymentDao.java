package com.zhk.springcloud.dao;

import com.zhk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 赵洪苛
 * @date 2020/7/25 15:54
 * @description
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);



}
