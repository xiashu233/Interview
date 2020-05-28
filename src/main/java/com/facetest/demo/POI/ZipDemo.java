package com.facetest.demo.POI;

import com.facetest.demo.utils.ZipUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 压缩文件为 Zip
 */
@RestController
public class ZipDemo {

    @RequestMapping("/testZip")
    public void testZip(HttpServletRequest request, HttpServletResponse response){
        List<String> fileList = new ArrayList<>();
        fileList.add("D://test.xls");
        fileList.add("D://springboot.log");
        ZipUtil.downloadZipFiles(response,fileList,"testZip");
    }
}
