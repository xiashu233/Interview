package com.facetest.demo;
//
//import com.facetest.demo.ElasticSearch.Article;
//import com.facetest.demo.ElasticSearch.ArticleEsRepository;
import com.facetest.demo.Mybatis.bean.User;
import com.facetest.demo.Mybatis.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
// ES
//    @Autowired
//    private ArticleEsRepository articleEsRepository;
//
//    @Test
//    public void testSave() {
//        Article article = new Article();
//        article.setAuthor("Alice");
//        article.setContent("spring boot data es");
//        article.setId(1l);
//        article.setPv(100);
//        article.setSummary("spring boot es");
//        articleEsRepository.save(article);
//    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
