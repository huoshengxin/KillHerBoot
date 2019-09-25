package com.kill.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

//@Configuration表示该类为配置类，该注解可以被@ComponentScan扫描到
@Configuration
public class ServletConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        //设置端口为8080, 代码的优先级比配置文件高
//        factory.setPort(8089);
//        factory.spring.


    }
}
