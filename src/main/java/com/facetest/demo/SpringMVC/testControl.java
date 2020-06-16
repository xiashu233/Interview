package com.facetest.demo.SpringMVC;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.facetest.demo.Java8.Apple;
import com.facetest.demo.Mybatis.bean.Student;
import com.facetest.demo.Mybatis.mapper.StudentMapper;
import com.facetest.demo.Mybatis.service.StudentService;

import com.facetest.demo.Spring.AOP.LoginCheck;
import com.facetest.demo.Spring.IOC.TeacherBean;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@Slf4j
@Api
@CrossOrigin
@RequestMapping("/SpringMVC")
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
        // 数据库中已经有了 id = 1的记录，所以在之后插入中将会报错
        Student stu3 = new Student(1,"zs",23,"asd");

        System.out.println(studentService.save(stu1));
        System.out.println(studentService.save(stu2));
        // 执行时报错 触发事务回滚
        System.out.println(studentService.save(stu3));
        List link = new LinkedList();
        link.get(0);
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
                studentService.t.set("Thread1");
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
                studentService.t.set("Thread2");
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
                studentService.t.set("Thread3");
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


    @RequestMapping("addCookie")
    public void addCookie(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Cookie testCookie = new Cookie("token","32" + new Date().getTime() + "11");
        testCookie.setMaxAge(10 * 60);
        // request.getRequestDispatcher("跳转页面path").forward(request,response);
        response.addCookie(testCookie);

    }

    /**
     * 值得一说的就是，IDEA的自测工具并不能很好的测试出cookie，
     * 所以cookie是跟随着浏览器请求来传输的
     * @param request
     */
    @RequestMapping("getAllCookies")
    public void getAllCookies(HttpServletRequest request){
        // System.out.println(student);
        Cookie[] cookies = request.getCookies();
        String cookiesStr = "";
        if (cookies != null){
            cookiesStr = Arrays.stream(cookies).map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(","));
        }
        log.info(cookiesStr);

    }

    @RequestMapping("testCheckLogin")
    @LoginCheck(loginSuccess = true)
    public void testCheckLogin(){
        log.info("开始测试是否携带注解");
    }

    @RequestMapping("hadUpload")
    public void hadUpload(@RequestParam("file")MultipartFile file,HttpServletResponse response) throws IOException {
        // 获取表单上传文件的输入流
        InputStream inputStream = file.getInputStream();
        // 缓冲区
        byte[] bytes = new byte[8];
        // 生成本地文件
        File file1 = new File("D://ddd.txt");
        if (file1.exists()){
            file1.delete();
        }
        FileOutputStream outputStream = new FileOutputStream(file1);

        // 输出到网页
        ServletOutputStream outputStream1 = response.getOutputStream();
        response.reset();
        // 设置文件头 及转码
        response.setHeader("Content-Disposition",
                "attchement;filename=" + new String(file.getOriginalFilename().getBytes("gb2312"), "ISO8859-1"));
        response.setContentType("application/msexcel");
        // 写入输出流
        while (inputStream.read(bytes) != -1){
            outputStream1.write(bytes);
        }


        inputStream.close();
        outputStream.close();
        // 刷出缓冲区
        // outputStream1.flush();
        outputStream1.close();


    }


}
