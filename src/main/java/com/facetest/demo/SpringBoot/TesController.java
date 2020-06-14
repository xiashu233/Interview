package com.facetest.demo.SpringBoot;

import com.facetest.demo.utils.FastDFSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
// 启用引入映射配置文件的配置类
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
public class TesController {
    @Autowired
    ConfigBean configBean;
    @Autowired
    TestConfigBean testConfigBean;

    @RequestMapping("/my")
    public String getMyInfo(){
        System.out.println("获取到 Spring 注入的配置");
        return "configBean:" + configBean.getName() + ":" + configBean.getAge()
                + "testConfigBean:" + testConfigBean.getName() + ":" + testConfigBean.getAge();
    }

    @Autowired
    private FastDFSClientUtil dfsClient;

    @PostMapping("/upload")
    public String fdfsUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String fileUrl = "";
        try {
            fileUrl = dfsClient.uploadFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

}
