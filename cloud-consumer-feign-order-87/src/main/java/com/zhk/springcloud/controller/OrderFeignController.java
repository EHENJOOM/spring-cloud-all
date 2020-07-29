package com.zhk.springcloud.controller;

import com.zhk.springcloud.entities.CommonResult;
import com.zhk.springcloud.entities.Payment;
import com.zhk.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/7/28 23:20
 * @description
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService service;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return service.getPaymentById(id);
    }

    @GetMapping("/consumer/feign/timeout")
    public String paymentFeignTimeOut() {
        // 底层使用了ribbon，默认超时1秒
        return service.paymentFeignTimeOut();
    }
}
