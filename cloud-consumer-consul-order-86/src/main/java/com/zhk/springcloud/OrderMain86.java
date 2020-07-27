package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 赵洪苛
 * @date 2020/7/27 23:44
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain86 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain86.class, args);
    }

}
