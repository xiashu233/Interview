package com.facetest.demo.Spring;

import com.facetest.demo.Spring.AOP.LoginCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/Spring")
public class SpringController {

    @RequestMapping("SpringAOPAnnotation")
    @LoginCheck
    public void SpringAOPAnnotation(){
        log.info("SpringAOPAnnotation 方法以执行");
    }
}
