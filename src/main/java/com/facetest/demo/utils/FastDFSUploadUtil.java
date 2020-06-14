//package com.facetest.demo.utils;
//
//import org.csource.fastdfs.ClientGlobal;
//import org.csource.fastdfs.StorageClient;
//import org.csource.fastdfs.TrackerClient;
//import org.csource.fastdfs.TrackerServer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//@Component
//public class FastDFSUploadUtil {
//
//    @Value("${trackerUrl}")
//    private String url;
//
//    public String uploadImage(MultipartFile multipartFile){
//    // 获得配置文件路径
//        String tracker = FastDFSUploadUtil.class.getResource("/tracker.conf").getPath();
//
//        try{
//            ClientGlobal.init(tracker);
//            TrackerClient trackerClient =  new TrackerClient();
//
//            TrackerServer trackerServer = trackerClient.getTrackerServer();
//
//            StorageClient storageClient = new StorageClient(trackerServer,null);
//            byte[] bytes = multipartFile.getBytes();
//            String path = multipartFile.getOriginalFilename();
//
//            String extName = path.substring(path.lastIndexOf('.')+1);
//
//            String[] uploadInfos = storageClient.upload_file(bytes, extName, null);
//
//            for (String uploadInfo : uploadInfos) {
//                url +=  "/" + uploadInfo;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return url;
//    }
//}