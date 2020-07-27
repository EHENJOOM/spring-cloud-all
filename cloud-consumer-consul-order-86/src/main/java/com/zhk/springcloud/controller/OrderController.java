package com.zhk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 赵洪苛
 * @date 2020/7/27 23:46
 * @description
 */
@Slf4j
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @GetMapping("/consumer/payment/consul")
    public String create() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }

}
