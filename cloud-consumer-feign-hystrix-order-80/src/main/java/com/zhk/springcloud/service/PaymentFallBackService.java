package com.zhk.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 赵洪苛
 * @date 2020/7/29 23:24
 * @description 服务降级的解耦实现
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentOk(Integer id) {
        return "=====> PaymentFallBackService paymentOk fall back";
    }

    @Override
    public String paymentTimeout() {
        return "=====> PaymentFallBackService paymentTimeout fall back";
    }
}
