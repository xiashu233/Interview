//package com.facetest.demo.ElasticSearch;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ESDemo {
//
//    @Autowired
//    private ArticleEsRepository articleEsRepository;
//
//    @RequestMapping("testES")
//    public void testSave() {
//        Article article = new Article();
//        article.setAuthor("Alice");
//        article.setContent("spring boot data es");
//        article.setId(1l);
//        article.setPv(100);
//        article.setSummary("spring boot es");
//        articleEsRepository.save(article);
//    }
//}
