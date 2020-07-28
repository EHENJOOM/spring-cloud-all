package com.zhk.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 赵洪苛
 * @date 2020/7/25 23:17
 * @description
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // @LoadBalanced  手写负载均衡算法
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
