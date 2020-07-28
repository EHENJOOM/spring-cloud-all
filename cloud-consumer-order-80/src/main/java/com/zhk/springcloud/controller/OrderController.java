package com.zhk.springcloud.controller;

import com.zhk.springcloud.entities.CommonResult;
import com.zhk.springcloud.entities.Payment;
import com.zhk.springcloud.lb.MyLoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

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

    @Resource
    private MyLoadBalance myLoadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    // private static final String PAYMENT_URL = "http://localhost:8001";         单机版
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";  // 集群版

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("正在调用 create 服务...");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("正在调用 get 服务...");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = myLoadBalance.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
