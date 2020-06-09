package com.facetest.demo.SpringMVC;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.facetest.demo.Java8.Apple;
import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.Mybatis.service.StudentService;
import com.facetest.demo.Redis.BloomFileter;

import com.facetest.demo.Spring.IOC.TeacherBean;
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
    @Autowired
    StudentService studentService;
//    @Autowired
//    Student student;
    @Autowired
    TeacherBean teacherBean;




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



    @RequestMapping("testTransactional")
    // 添加事务 一般在Service层使用 指定发生什么错误时回滚事务
    // rollbackFor：触发回滚的异常，默认是RuntimeException和Error
    // isolation: 事务的隔离级别，默认是Isolation.DEFAULT也就是数据库自身的默认隔离级别，比如MySQL是ISOLATION_REPEATABLE_READ可重复读
    @Transactional(rollbackFor = {RuntimeException.class,Error.class})
    public void testTransactional(){
        Student stu1 = new Student(6,"zs",23,"asd");
        Student stu2 = new Student(7,"ls",23,"asd");
        Student stu3 = new Student(1,"zs",23,"asd");

        System.out.println(studentService.save(stu1));
        System.out.println(studentService.save(stu2));
        System.out.println(studentService.save(stu3));
    }

    @RequestMapping("testMyBatisPlus")
    public void testMyBatisPlus(){
        Wrapper<Student> studentWrapper = new QueryWrapper<>();

        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);



    }

    @RequestMapping("testThreadLocal")
    public void testThreadLocal(){
        studentService.t.set("主线程");
        new Thread(()->{
            studentService.t.set("Thread1");
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread1-----" + studentService.t.get().toString());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1").start();

        new Thread(()->{
            studentService.t.set("Thread2");
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread2-----" + studentService.t.get().toString());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程2").start();

        new Thread(()->{
            studentService.t.set("Thread3");
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread3-----" + studentService.t.get().toString());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程3").start();
    }

    @RequestMapping("testBean")
    public void testBean(){
        // System.out.println(student);
        teacherBean.sayStudent();
    }



}
