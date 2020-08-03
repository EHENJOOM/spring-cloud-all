package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 赵洪苛
 * @date 2020/8/3 12:28
 * @description
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamRabbitMQConsumer8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQConsumer8802.class, args);
    }

}
