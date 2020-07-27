package com.zhk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 赵洪苛
 * @date 2020/7/27 23:16
 * @description
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String payment() {
        return "Spring Cloud with Consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
