//package com.kill;
//
//import com.kill.domain.User;
//import com.kill.rabbit.Provider;
//import com.kill.service.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = KillHerBootApplication.class)
//public class RabbitApplicationTests {
//
//    @Autowired
//    private Provider provider;
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void providerTest() {
//        provider.sendMessage("Hello Shiyanlou");
//    }
//
//    @Test
//    public void testUser(){
//        User byId = userService.findById(4);
//        System.out.println("测试通过测试通过测试通过测试通过测试通过测试通过"+byId);
//    }
//
//}