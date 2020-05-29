package com.facetest.demo.Java基础;

import java.io.*;
import java.nio.file.Files;

public class IODemo {
    public static void main(String[] args) throws IOException {
        InputStream stream = new FileInputStream("D://test.xls");
        File file = new File("D://testCopy.xls");

//        Reader reader = new FileReader("D://test.xls");
//        Writer writer = new FileWriter("D://testWrite.xls");



        // 创建文件 如果文件存在则不创建 返回false 否则正确创建返回 true
        file.createNewFile();
        OutputStream outputStream = new FileOutputStream(file);
        int size = 0;
        // 数据缓冲区
        byte[] st = new byte[4096];
        // 读取文件
        while ((size = stream.read(st))>0){
            // 写入文件
            outputStream.write(st);
        }

        // Files.copy("",new FileOutputStream(file))
        outputStream.close();
        stream.close();
    }
}
