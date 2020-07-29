package com.zhk.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @author 赵洪苛
 * @date 2020/7/29 18:12
 * @description
 */
@Service
public class PaymentService {

    public String paymentOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentOk\t" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentTimeout() {
        int a = 10 / 0;
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentTimeout ==> Error!!!!";
    }

    public String paymentTimeoutHandler() {
        return "线程池：" + Thread.currentThread().getName() + "\tpaymentTimeoutHandler ===> paymentTimeout服务繁忙";
    }

}
