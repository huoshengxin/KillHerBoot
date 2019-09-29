package com.kill.controller;

import com.kill.domain.User;
import com.kill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("findAll")
    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> ret=new ArrayList<>();
        userService.findAll().forEach(user -> {
            Map<String,Object> row=new LinkedHashMap<>();
            row.put("id,",user.getId());
            row.put("username",user.getUsername());
            row.put("password",user.getPassword());
            row.put("email","邮箱占位符");
            row.put("age","年龄占位符");
            row.put("sex","性别占位符");
            ret.add(row);
        });
        System.out.println("查询成功, 返回记录条数 = "+ret.size());
        return ret;
    }

    //使用post请求新建
    @PostMapping()
    public String save(User user) {
        userService.save(user);
        return "save success";
    }

    //使用put请求更新 会拦截类似/user/1这种形式的路径
    @PutMapping("{id}")
    public String update(User user, @PathVariable int id) {
        //当数据不存在时，不允许更新
        if (userService.findById(id) == null) {
            return "Not Exist";
        }
        //防止传入的id不一致，如user中id属性是2，而url路径中id为1；
        if (user.getId() != id) {
            return "Unmatched parameters";
        }
        userService.update(user);
        return "update success";
    }

    //使用delete请求删除
    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "delete success";
    }

    //使用get方法查询
    @GetMapping()
    public List<User> list() {
        return userService.list();
    }

    //使用get方法查询单个数据
    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return userService.findById(id);
    }
}
