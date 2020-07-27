package com.zhk.springcloud.service;

import com.zhk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 赵洪苛
 * @date 2020/7/25 19:02
 * @description
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
