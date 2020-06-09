package com.facetest.demo.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateDemo {

    @RequestMapping("hello")
    public void hello(){
        System.out.println("hello");
    }


}
