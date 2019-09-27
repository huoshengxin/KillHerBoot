package com.kill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication注解相当于同时使用@EnableAutoConfiguration、@ComponentScan、@Configurations三个注解
//@EnableAutoConfiguration用于打开SpringBoot自动配置，而其余注解为Spring注解
//通过@ImportResource加载xml配置文件
//@ImportResource(value = "classpath:config.xml")
@SpringBootApplication
//扫描mapper接口位置
@MapperScan(basePackages = {"com.kill.dao"})
public class KillHerBootApplication  extends SpringBootServletInitializer {

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


	/**
	 * 因为没有 web.xml 文件，所以需要继承SpringBootServletInitializer并且覆盖configure(SpringApplicationBuilder builder)方法
	 * 接下来的步骤和打包 jar 文件是一样的。打包好了之后将 war 文件放到 tomcat 的 webapps 目录中就可以了
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(KillHerBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(KillHerBootApplication.class, args);
	}

}
