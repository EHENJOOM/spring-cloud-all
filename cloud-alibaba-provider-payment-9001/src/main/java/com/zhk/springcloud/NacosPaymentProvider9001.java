package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 赵洪苛
 * @date 2020/8/3 19:02
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosPaymentProvider9001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentProvider9001.class, args);
    }

}
