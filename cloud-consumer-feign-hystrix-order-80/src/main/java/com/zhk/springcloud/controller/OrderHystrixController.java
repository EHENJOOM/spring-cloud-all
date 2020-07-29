package com.zhk.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhk.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/7/29 19:06
 * @description
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping("/consumer/hystrix/ok/{id}")
    String paymentOk(@PathVariable("id") Integer id) {
        String result = service.paymentOk(id);
        log.info("****PaymentOk服务调用：" + result);
        return result;
    }

    @GetMapping("/consumer/hystrix/timeout")
    @HystrixCommand
    /*@HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    String paymentTimeout() {
        String result = service.paymentTimeout();
        log.info("****paymentTimeout服务调用：" + result);
        return result;
    }

    public String paymentTimeoutHandler() {
        return "消费者80：对方支付系统繁忙，请稍后再试。";
    }

    // 全局fallback
    public String globalFallBack() {
        return "全局异常信息，请稍后再试！";
    }

}
