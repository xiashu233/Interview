package com.facetest.demo.Redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
public class Hash类型 {
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("testRedisHash")
    public Object testRedisHash(){

        String key = "hash";
        Map<String,String> map = new HashMap<>();
        map.put("f1","val1");
        map.put("f2","val2");
        //为hash结构设置多个键值对(hmset)
        redisTemplate.opsForHash().putAll(key,map);
        //获取hash结构指定字段的value，单个key(hget)
        Object f1 = redisTemplate.opsForHash().get(key, "f1");
        log.info("f1========"+f1);
        //为hash结构设置单个键值对(hset)
        redisTemplate.opsForHash().put(key,"f3","val3");
        Object f3 = redisTemplate.opsForHash().get(key, "f3");
        log.info("f3========"+f3);
        //判断hash结构中是否包含某字段(hexists)
        Boolean haskey = redisTemplate.opsForHash().hasKey(key, "f3");
        log.info("haskey========"+haskey);
        //获取hash结构中所有的键值对(hgetall)
        Map<String,String> entries = redisTemplate.opsForHash().entries(key);
        for(Map.Entry<String,String> entry : entries.entrySet()){
            log.info(entry.getKey()+"======"+entry.getValue());
        }
        //获取所有hash结构中所有的key(hkeys)
        Set<String> keys = redisTemplate.opsForHash().keys(key);
        for(String key1 : keys){
            log.info("key1=========="+keys);
        }
        //获取hash结构中所有的value(hvals)
        List<String> values = redisTemplate.opsForHash().values(key);
        for(String value : values){
            log.info("value======="+value);
        }
        //获取hash结构中指定key的value，可以是多个key（hmget）
        List<String> list = redisTemplate.opsForHash().multiGet(key, keys);
        for(String value2 : list){
            log.info("value2======="+value2);
        }
        //hash结构中若存在相应key才进行操作(hsetnx)
        Boolean success = redisTemplate.opsForHash().putIfAbsent(key, "f3", "6");
        log.info("succes======"+success);
        //删除hash结构中指定的key(hdel)
        Long delete = redisTemplate.opsForHash().delete(key, "f1", "f2");
        log.info("delete=========="+delete);
        return null;
    }
}
