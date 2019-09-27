package com.kill.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 生产消息
 * @author shiyanlou
 */
@Component
public class Provider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String msg){
        System.out.println("提供者 发送消息：" + msg);
        amqpTemplate.convertAndSend("fanoutExchange","", msg);
    }
}
