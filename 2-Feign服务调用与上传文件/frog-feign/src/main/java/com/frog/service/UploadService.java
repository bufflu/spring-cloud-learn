package com.frog.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: UploadService
 * Description: 调用其他服务进行文件上传
 * Date: 2018/8/15 18:49
 *
 * @author guoxinlu
 */
@Service
@FeignClient(value = "frog-producer")
public interface UploadService {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile file);
}
