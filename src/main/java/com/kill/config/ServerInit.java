package com.kill.config;


import com.kill.domain.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner接口可以让在SpringBoot启动后马上执行想要执行的方法
 */
@Component
public class ServerInit implements ApplicationRunner {

//    @Resource
//    private UserService userService;

    /**
     * 该方法再SpringBoot启动完成后立即执行
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
//        user.setId(12312312);
//        user.setUsername("小黑");
//        userService.save(user);

//        User query = userService.query(1);
//        System.out.println("amdamdamdamdamdamdamdamdamdamdamdamdamdamdamdamd");
//        System.out.println(query);
//        System.out.println("amdamdamdamdamdamdamdamdamdamdamdamdamdamdamdamd");



    }
}
