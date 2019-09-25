package com.kill.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//RestController相当于同时使用@Controller和@ResponseBody注解
//@RestController
//加载classpath目录下的shiyanlou.properties文件, 如果是application.properties则不需要配置
@PropertySource(value = "classpath:shiyanlou.properties")
//因为需要返回视图，所以不能使用@ResponseBody
@Controller
public class ShiyanlouController {

    //使用@Value注解注入属性值
    // 只能访问 application.properties 中的属性，
    // 如果是其他自定义的配置文件中的属性是访问不到的，还需要其他的处理
    @Value("${shiyanlou.test}")
    private String shiyanlou;

    @RequestMapping("shiyanlou")
    public String shiyanlou() {
//        return shiyanlou;
        return "shiyanlou";
    }
}