package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 赵洪苛
 * @date 2020/8/2 12:40
 * @description
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamRabbitMQProvider8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQProvider8801.class, args);
    }
}
