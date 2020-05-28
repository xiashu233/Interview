package com.facetest.demo.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class Hash类型 {
    @Autowired
    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        Hash类型 test = new Hash类型();
        test.testPutHash();
    }

    void testPutHash(){
        redisTemplate.opsForHash().put("hash:1:info","name","zs");
    }
}
