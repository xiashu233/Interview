package com.facetest.demo.SpringMVC;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.facetest.demo.Java8.Apple;
import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.Redis.BloomFileter;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@Api
@CrossOrigin
public class testControl {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StudentMapper studentMapper;



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


    @RequestMapping("testUploadFile")
    public String testUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getName());
        return "";

    }

    @PostMapping("/ss/{id}")
    public String ss(@PathVariable("id")String id){
        System.out.println(id);
        return id;
    }

    @PostMapping("rqbody")
    public String rqbody(@RequestBody Apple apple){
        System.out.println(apple);
        return apple.toString();
    }

    @PostMapping("getDataNot")
    public Long getDataNot(Apple apple) throws Exception {
        throw new Exception("no");
        // return 1265075615523016700L;
    }

/**
 * 经过试验得知 Session在用户不关闭浏览器的情况下会一直存在，其原理就是请求时携带JSESSIONID这个Cookie
 * 通过Cookie来判断是某个用户
 * @param request
 * @return
 */
    @GetMapping("testSession")
    public Long testSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Object user_token = session.getAttribute("user_Token");

        boolean flag = false;
        Cookie userCookie = null;
        for (Cookie cookie : request.getCookies()) {
            if ("user_Token".equals(cookie.getName())){
                flag = true;
                userCookie = cookie;
                break;
            }
        }

        if (!flag){
            String userToken = "加密后的数据符合特殊格式";
            userCookie = new Cookie("user_Token","加密后的数据符合特殊格式");
            userCookie.setMaxAge(60 * 60 * 24);
            // 放进 Redis 里
            redisTemplate.opsForValue().set(userToken,"memberId",24, TimeUnit.HOURS);

            response.addCookie(userCookie);
        }

        log.info("用户存储的Cookie：" + userCookie.getValue());

        if (user_token == null){
            Date date = new Date();
            user_token = date.getTime();
            session.setAttribute("user_Token",user_token);
        }

        return (long)user_token;
        // return 1265075615523016700L;
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

    @RequestMapping("testTransactional")
    // 添加事务 一般在Service层使用 指定发生什么错误时回滚事务
    // rollbackFor：触发回滚的异常，默认是RuntimeException和Error
    // isolation: 事务的隔离级别，默认是Isolation.DEFAULT也就是数据库自身的默认隔离级别，比如MySQL是ISOLATION_REPEATABLE_READ可重复读
    @Transactional(rollbackFor = {RuntimeException.class,Error.class})
    public void testTransactional(){
        Student stu1 = new Student(6,"zs",23,"asd");
        Student stu2 = new Student(7,"ls",23,"asd");
        Student stu3 = new Student(1,"zs",23,"asd");

        studentMapper.insert(stu1);
        studentMapper.insert(stu2);
        // studentMapper.insert(stu3);
    }

    @RequestMapping("testMyBatisPlus")
    public void testMyBatisPlus(){
        Wrapper<Student> studentWrapper = new QueryWrapper<>();

        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);

    }



}
