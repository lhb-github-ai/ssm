package com.lhb.service;/*
 *@Author lee
 * @date 2020/06/18
 */

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    public String UploadFile(MultipartFile file) ;
}
