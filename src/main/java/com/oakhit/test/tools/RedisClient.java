package com.oakhit.test.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean setString(String key, String value) throws Exception {
        stringRedisTemplate.opsForValue().set(key, value);
        Thread.sleep(1000);
        return redisTemplate.hasKey(key);
    }

    public boolean setObj(String key, Object o) throws Exception {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
//        operations.set(key, new Gson().toJson(o));
        operations.set(key, o);
        Thread.sleep(1000);
        return redisTemplate.hasKey(key);
    }

    public Object getObj(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}