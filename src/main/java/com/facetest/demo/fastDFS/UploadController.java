package com.facetest.demo.fastDFS;

import java.io.IOException;
import java.io.InputStream;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facetest.demo.utils.FastDFSClientUtil;
import io.swagger.annotations.Api;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@Api(tags = "FastDFS常见方法")
@RequestMapping("/FastDFS")
public class UploadController {
 
	@Autowired
	private FastDFSClientUtil dfsClient;

	@RequestMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileUrl = "";
		try {
			fileUrl = dfsClient.uploadFile(file);
			request.setAttribute("msg", "成功上传文件，  '" + fileUrl + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileUrl;
	}
 
	
	/*
	 * http://localhost/download?filePath=group1/M00/00/00/wKgIZVzZEF2ATP08ABC9j8AnNSs744.jpg
	 */
	@RequestMapping("download")
	public void download(String filePath ,HttpServletRequest request ,HttpServletResponse response) throws IOException {
		
		//    group1/M00/00/00/wKgIZVzZEF2ATP08ABC9j8AnNSs744.jpg
		String[] paths = filePath.split("/");
		String groupName = null ;
		for (String item : paths) {
			if (item.indexOf("group") != -1) {
				groupName = item;
				break ;
			}
		}
		String path = filePath.substring(filePath.indexOf(groupName) + groupName.length() + 1, filePath.length());
		InputStream input = dfsClient.download(groupName, path);
		
        //根据文件名获取 MIME 类型
		String fileName = paths[paths.length-1] ;
		System.out.println("fileName :" + fileName); // wKgIZVzZEF2ATP08ABC9j8AnNSs744.jpg
        String contentType = request.getServletContext().getMimeType(fileName);
        String contentDisposition = "attachment;filename=" + fileName;
        
        // 设置头
        response.setHeader("Content-Type",contentType);
        response.setHeader("Content-Disposition",contentDisposition);
 
        // 获取绑定了客户端的流
        ServletOutputStream output = response.getOutputStream();
 
        // 把输入流中的数据写入到输出流中
        IOUtils.copy(input,output);
        input.close();
		
	}
	
	/**
	 * http://localhost/deleteFile?filePath=group1/M00/00/00/wKgIZVzZaRiAZemtAARpYjHP9j4930.jpg
	 * @param filePath  group1/M00/00/00/wKgIZVzZaRiAZemtAARpYjHP9j4930.jpg
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("deleteFile")
	public String delFile(String filePath , HttpServletRequest request ,HttpServletResponse response)  {
		
		try {
			dfsClient.delFile(filePath); 
		} catch(Exception e) { 
			// 文件不存在报异常 ： com.github.tobato.fastdfs.exception.FdfsServerException: 错误码：2，错误信息：找不到节点或文件
			// e.printStackTrace();
		}
		request.setAttribute("msg", "成功删除，'" + filePath);
		
		return "index";
	}
	
 
}