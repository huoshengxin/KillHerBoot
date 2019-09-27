package com.kill.service.impl;

import com.kill.dao.BaseMapper;
import com.kill.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Resource
    protected BaseMapper<T> baseMapper;

    @Override
    public void delete(Integer id) {
        baseMapper.delete(id);
    }

    @Override
    public Integer save(T t) {
        return baseMapper.save(t);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public T findById(Integer id) {
        return baseMapper.findById(id);
    }


    @Override
    public List<T> list() {
        return baseMapper.list();
    }

}
