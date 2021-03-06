package com.zhk.springcloud.controller;

import com.zhk.springcloud.entities.CommonResult;
import com.zhk.springcloud.entities.Payment;
import com.zhk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/7/25 19:07
 * @description
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，serverPort：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败，serverPort：" + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，serverPort：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，serverPort：" + serverPort, null);
        }
    }

    /**
     * 手写负载均衡算法配套测试
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
