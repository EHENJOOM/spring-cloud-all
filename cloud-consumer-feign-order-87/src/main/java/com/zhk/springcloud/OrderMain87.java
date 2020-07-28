package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 赵洪苛
 * @date 2020/7/28 23:14
 * @description
 */
@EnableFeignClients
@SpringBootApplication
public class OrderMain87 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain87.class, args);
    }

}
