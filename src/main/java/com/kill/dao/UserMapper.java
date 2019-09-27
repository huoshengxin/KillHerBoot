package com.kill.dao;

import com.kill.domain.User;

import java.util.List;

public interface UserMapper { //} extends BaseMapper<User> {
    /**
     * 保存
     */
    Integer save(User t);

    /**
     * 删除
     */
    void delete(Integer id);

    /**
     * 通过id查询
     */
    User findById(Integer id);

    /**
     * 更新
     */
    void update(User t);

    /**
     * 返回所有信息
     */
    List<User> list();
}