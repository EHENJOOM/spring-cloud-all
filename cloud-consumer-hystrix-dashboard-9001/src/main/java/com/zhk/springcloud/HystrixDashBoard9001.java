package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author 赵洪苛
 * @date 2020/7/30 13:05
 * @description
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoard9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard9001.class, args);
    }

}
