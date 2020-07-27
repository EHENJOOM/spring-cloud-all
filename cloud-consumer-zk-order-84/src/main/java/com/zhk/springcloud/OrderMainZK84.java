package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 赵洪苛
 * @date 2020/7/27 19:21
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMainZK84 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainZK84.class, args);
    }

}
