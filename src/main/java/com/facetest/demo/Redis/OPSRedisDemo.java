package com.facetest.demo.Redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequestMapping("/Redis")
public class OPSRedisDemo {
    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("testRedisValue")
    public void testRedisValue(){
        // redisTemplate.opsForValue().set("testRedisValue",null,1, TimeUnit.MILLISECONDS);
        redisTemplate.opsForValue().set("testRedisValue","1");
        Object redisValue = redisTemplate.opsForValue().get("testRedisValue");
        System.out.println(redisValue);
        // 正数增加
        redisTemplate.opsForValue().increment("testRedisValue",1);
        Object redisValueAdd = redisTemplate.opsForValue().get("testRedisValue");
        System.out.println(redisValueAdd);
        // 负数减少
        redisTemplate.opsForValue().increment("testRedisValue",-1);
        Object redisValueSub = redisTemplate.opsForValue().get("testRedisValue");
        System.out.println(redisValueSub);

        // 获取操作类
        ListOperations listOperations = redisTemplate.opsForList();

        for (int i = 0; i < 10; i++) {
            // 右入队列 就是正常的 1 2 3
            listOperations.rightPush("testRedisList",i+"");
        }
        // 获得指定长度的数组
        List testRedisListRange = listOperations.range("testRedisList", 0, 5);
        System.out.println(testRedisListRange);
        Object o = null;
        StringBuffer sb = new StringBuffer();
        while (true){
            // 右出队列 3 2 1 这样的顺序 出完队列为空自动删除
            o = listOperations.rightPop("testRedisList");
            if (o == null){
                break;
            }
            sb.append(o).append("--");

        }
        System.out.println(sb);

        // ZSet 有序数组
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        for (int i = 0; i < 10; i++) {
            zSetOperations.add("testRedisZSet",i + "",Math.random());
        }
        Set testRedisZSet = zSetOperations.range("testRedisZSet", 0, 9);
        System.out.println(testRedisZSet);

    }

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

    /**
     * 使用布隆过滤器
     * @param data
     */
    @RequestMapping("testSingleton")
    public void testSingleton(String data){
        BloomFileter bloomFileter = BloomFileter.getBloomFileter();
        System.out.println(bloomFileter.check(data));

    }

    /**
     * 添加布隆过滤器的值
     * @param data
     */
    @RequestMapping("testBloomFileterAdd")
    public void testBloomFileterAdd(String data){
        BloomFileter bloomFileter = BloomFileter.getBloomFileter();
        System.out.println(bloomFileter.addIfNotExist(data));
        bloomFileter.saveFilterToFile(bloomFileter.objPath);

    }
}
