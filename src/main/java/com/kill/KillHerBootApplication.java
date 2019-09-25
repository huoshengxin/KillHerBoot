package com.kill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication注解相当于同时使用@EnableAutoConfiguration、@ComponentScan、@Configurations三个注解
//@EnableAutoConfiguration用于打开SpringBoot自动配置，而其余注解为Spring注解
//通过@ImportResource加载xml配置文件
//@ImportResource(value = "classpath:config.xml")
@SpringBootApplication
public class KillHerBootApplication {

    /*//设置配置类
    @Configuration
    static class WebConfig implements WebMvcConfigurer {

        //重写addResourceHandlers方法
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //设置静态资源映射路径为/**，资源位置为类路径下的upload
            registry.addResourceHandler("/**").addResourceLocations("classpath:/upload/");
        }
    }*/


	public static void main(String[] args) {
		SpringApplication.run(KillHerBootApplication.class, args);
	}

}
