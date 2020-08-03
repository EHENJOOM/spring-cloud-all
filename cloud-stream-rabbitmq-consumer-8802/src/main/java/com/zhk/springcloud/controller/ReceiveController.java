package com.zhk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author 赵洪苛
 * @date 2020/8/3 12:29
 * @description
 */
@Slf4j
@Controller
@EnableBinding(Sink.class)
public class ReceiveController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener
    public void input(Message<String> message) {
        log.info("消费者1号，===收到的消息：{}，端口号：{}", message.getPayload(), serverPort);
    }

}
