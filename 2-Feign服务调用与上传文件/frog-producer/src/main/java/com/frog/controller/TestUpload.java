package com.frog.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: TestUpload
 * Description: 测试文件上传
 * Date: 2018/8/14 19:09
 *
 * @author guoxinlu
 */
@RestController
public class TestUpload {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("file") MultipartFile file) {
        return "name:" + file.getOriginalFilename() + " size:" + file.getSize();
    }
}
