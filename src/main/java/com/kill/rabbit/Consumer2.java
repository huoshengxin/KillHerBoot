package com.kill.rabbit;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 消费者
 * 内部有负载均衡, 如果同时启动3个服务, 则依次拿到消息
 *
 * @RabbitListener 可以标注到类上, 当有收到消息的时候，就交给 @RabbitHandler 的方法处理
 */
@Component
public class Consumer2 {

    @Bean
    public Queue testQu1() {
        return new Queue("test_qu1");
    }
    @Bean
    public Queue testQu2() {
        return new Queue("test_qu2");
    }
    /**
     * 建立一个fanout(分列)模式的Exchange
     *
     * @return
     */
    @Bean
    FanoutExchange testQuList() {
        return new FanoutExchange("test_qu_list");
    }
    /**
     * 绑定队列到交换机, 队列名和交换机名字都是方法名, 写错会报错
     *
     * @param testQu2
     * @param testQuList
     * @return
     */
    @Bean
    public Binding bindingQueueQu(Queue testQu2, FanoutExchange testQuList) {
        return BindingBuilder.bind(testQu2).to(testQuList);
    }




    //  监听器
    @RabbitListener(queues = "key_test")
    public void getMsg(String msg){
        System.out.println("直接/分列消费模式 = "+msg);
    }

    //  监听器
    @RabbitListener(queues = "key_test2")
    public void getMsg2(String msg){
        System.out.println("直接/分列消费模式 = "+msg);
    }

    //  监听器
    @RabbitListener(queues = "test_zhuti_qu1")
    public void getMsg3(String msg){
        System.out.println("主题消费模式1 = "+msg);
    }

    //  监听器
    @RabbitListener(queues = "test_zhuti_qu2")
    public void getMsg4(String msg){
        System.out.println("主题消费模式2 = "+msg);
    }



}
