package com.zhk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 赵洪苛
 * @date 2020/7/31 11:59
 * @description
 */
@EnableConfigServer
@SpringBootApplication
public class MainAppConfig3344 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppConfig3344.class, args);
    }

}
