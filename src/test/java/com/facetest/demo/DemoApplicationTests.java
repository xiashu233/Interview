//package com.facetest.demo;
//
//import com.facetest.demo.ElasticSearch.Article;
//import com.facetest.demo.ElasticSearch.ArticleEsRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class DemoApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
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
//
//}
