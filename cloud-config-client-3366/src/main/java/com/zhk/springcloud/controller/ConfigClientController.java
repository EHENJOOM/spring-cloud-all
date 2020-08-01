package com.zhk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵洪苛
 * @date 2020/7/31 12:50
 * @description
 */
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${config.all}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/config")
    public String getConfig() {
        return serverPort + "===>" + configInfo;
    }

}
