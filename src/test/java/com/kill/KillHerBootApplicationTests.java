package com.kill;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kill.domain.User;
import com.kill.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=KillHerBootApplication.class)
public class KillHerBootApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //  生产者 -> 主题模式 topic
    @Test
    public void test4Rabbit(){
        /**
         * 测试分列模式, 需要配多个queue队列, 一个交换机, 并且映射交换机和队列的关联
         * 映射关系时: Routing就是过滤关系, #代表所有, *代表占一位
         * 发送通知, 所有关联并且能够匹配上的的queue队列都会受到通知
         */
        rabbitTemplate.convertAndSend("test_zhuti","小黑.jpg","主题模式测试");

    }


    //  生产者 -> 分列模式 fanout
    @Test
    public void test3Rabbit(){
        /**
         * 测试分列模式, 需要配多个queue队列, 一个交换机, 并且映射交换机和队列的关联
         * 发送通知, 所有关联的queue队列都会受到通知
         */
        rabbitTemplate.convertAndSend("test_k","","分列模式测试");

    }


    // 生产者
    @Test
    public void test02Rabbit(){

        /**
         * 看似没有经过交换器, 实则经过了一个空字符串的额交换器
         * 需要先配置一个queue队列, 然后相应队列的消费者可以直接获取到数据
         *
         */
        rabbitTemplate.convertAndSend("key_test","直接模式测试");


    }


	@Test
	public void test01() throws JsonProcessingException {
	    String key="user.all";
        //  从redis查询
        String userList = redisTemplate.boundValueOps(key).get();
        //  检测是否查询成功  如果不存在数据则从数据库查询
        if(StringUtils.isEmpty(userList)){
            List<User> list = userService.list();
            ObjectMapper objectMapper=new ObjectMapper();
            userList = objectMapper.writeValueAsString(list);
            redisTemplate.boundValueOps(key).set(userList);
            System.out.println("================从数据库中获得user的数据===============");
        }else{
            System.out.println("================从Redis缓存中获得user的数据===============");
        }

        //  将数据打印到控制台
        System.out.println(userList);

//        redisTemplate.opsForValue().

	}



}
