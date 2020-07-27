package com.zhk.springcloud.controller;

import com.zhk.springcloud.entities.CommonResult;
import com.zhk.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/7/25 23:13
 * @description
 */
@Slf4j
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/zk")
    public String getPayment() {
        log.info("正在调用 get 服务...");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk" , String.class);
    }

}
