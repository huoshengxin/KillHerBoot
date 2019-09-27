package com.kill.service.impl;

import com.kill.dao.UserMapper;
import com.kill.domain.User;
import com.kill.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
//public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
public class UserServiceImpl implements UserService {

    @Resource
    protected UserMapper userMapper;

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public Integer save(User t) {
        return userMapper.save(t);
    }

    @Override
    public void update(User t) {
        userMapper.update(t);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }


    @Override
    public List<User> list() {
        return userMapper.list();
    }


//    @Resource Hibernate用
//    private UserRepository userRepository;

    //   Hibernate用
//    @Transactional(rollbackFor = Exception.class)
//    @Override
//    public void save(User user) {
//        userRepository.save(user);
//    }
//   Hibernate用
//    @Override
//    public User query(int id) {
//        System.out.println("用户查询方法开始");
//        return userRepository.findById(id).get();
//    }
}
