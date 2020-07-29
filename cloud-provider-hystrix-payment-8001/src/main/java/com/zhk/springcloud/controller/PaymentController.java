package com.zhk.springcloud.controller;

import com.zhk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/7/29 18:16
 * @description
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService service;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        String result = service.paymentOk(id);
        log.info("****result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout")
    public String paymentTimeout() {
        String result = service.paymentTimeout();
        log.info("****result:" + result);
        return result;
    }

    @GetMapping("/test")
    public String test() {
        return "测试成功！";
    }

}
