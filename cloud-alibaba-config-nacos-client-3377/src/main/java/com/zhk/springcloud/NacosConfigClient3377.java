package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 赵洪苛
 * @date 2020/8/4 11:42
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClient3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377.class, args);
    }

}
