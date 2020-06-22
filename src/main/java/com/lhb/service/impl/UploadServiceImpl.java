//package com.lhb.ssm_vue.service.impl;
//
//import com.github.tobato.fastdfs.domain.fdfs.StorePath;
//import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
//import com.github.tobato.fastdfs.service.FastFileStorageClient;
//import com.project.file.mapper.FileMapper;
//import com.project.file.pojo.File;
//import com.project.file.service.UploadService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Date;
//
///**
// * @Author: CHENLIHUI
// * @Description:
// * @Date: Create in 14:37 2020/6/8
// */
//@Slf4j
//@Service
//public class UploadServiceImpl implements UploadService {
//
//    @Autowired
//    private FastFileStorageClient fastFileStorageClient;
//
//    @Autowired
//    private FileMapper fileMapper;
//
//    @Value("${upload.base-url}")
//    private String Host;
//
//    @Override
//    public String UploadFile(MultipartFile file) {
//        try{
////           StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
//            StorePath storePath = fastFileStorageClient.uploadFile("group1", file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()));
//            File fileSave = new File();
//            fileSave.setFileName(file.getOriginalFilename());
//            fileSave.setFileUrl(Host+storePath.getFullPath());
//            fileSave.setSaveTime(new Date());
//            fileSave.setSize(file.getSize());
//            fileSave.setType(file.getContentType());
//            fileMapper.saveFile(fileSave);
//
//            return fileSave.getFileUrl();
//
//        }catch (IOException e) {
//            log.error("文件上传失败",e);
//            throw new RuntimeException("文件上传失败" + e.getMessage());
//        }
//    }
//
//    @Override
//    public String deleteFile(String fileUrl) {
//        if (StringUtils.isEmpty(fileUrl)) {
//            return "不能为空";
//        }
//        try {
//            StorePath storePath = StorePath.parseFromUrl(fileUrl);
//            fastFileStorageClient.deleteFile(storePath.getGroup(), storePath.getPath());
//            return "删除成功";
//        } catch (FdfsUnsupportStorePathException e) {
//            throw new RuntimeException("文件上传失败" + e.getMessage());
//        }
//    }
//
//}
