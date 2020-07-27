package com.zhk.springcloud.service.impl;

import com.zhk.springcloud.dao.PaymentDao;
import com.zhk.springcloud.entities.Payment;
import com.zhk.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/7/25 19:03
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
