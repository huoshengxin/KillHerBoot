package com.kill.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@SuppressWarnings("all")
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //  前两个最常用
//    stringRedisTemplate.opsForValue().set("test", "100",60*10,TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间
//    stringRedisTemplate.opsForValue().get("test")//根据key获取缓存中的val
//    stringRedisTemplate.boundValueOps("test").increment(-1);//val做-1操作
//    stringRedisTemplate.boundValueOps("test").increment(1);//val +1
//    stringRedisTemplate.getExpire("test")//根据key获取过期时间
//    stringRedisTemplate.getExpire("test",TimeUnit.SECONDS)//根据key获取过期时间并换算成指定单位
//    stringRedisTemplate.delete("test");//根据key删除缓存
//    stringRedisTemplate.hasKey("546545");//检查key是否存在，返回boolean值
//    stringRedisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间
//    stringRedisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合
//    stringRedisTemplate.opsForSet().isMember("red_123", "1")//根据key查看集合中是否存在指定数据
//    stringRedisTemplate.opsForSet().members("red_123");//根据key获取set集合



    /**
     * 将字符串值 value 关联到 key 。
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 返回 key 所关联的字符串值。
     *
     * @param key 键
     * @return 值 string
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 获取键过期时间
     *
     * @param key      键
     * @param timeUnit 时间单位
     * @return the long
     */
    public long ttl(String key, TimeUnit timeUnit) {
        return stringRedisTemplate.getExpire(key, timeUnit);
    }

    /**
     * 设置键过期时间
     *
     * @param key      键
     * @param timeout  过期时间
     * @param timeUnit 时间单位
     * @return boolean boolean
     */
    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return stringRedisTemplate.expire(key, timeout, timeUnit);
    }

    /**
     * 获取旧值并且更新值
     *
     * @param key   键
     * @param value 新值
     * @return 旧值
     */
    public String getSet(String key, String value) {
        return stringRedisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 删除
     *
     * @param key 键
     * @return the boolean
     */
    public boolean del(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * Hset  将哈希表 key 中的域 field 的值设为 value 。
     *
     * @param key   键
     * @param field 域
     * @param value 值
     */
    public void hset(String key, String field, Object value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * Hget 返回哈希表 key 中给定域 field 的值。
     *
     * @param key   键
     * @param field 域
     * @return 值
     */
    public String hget(String key, String field) {
        return (String) stringRedisTemplate.opsForHash().get(key, field);
    }
}

