package com.frog.controller;

import com.frog.service.SayHelloRemote;
import com.frog.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName:
 * Description:
 * Date: 2018/8/14 18:30
 *
 * @author guoxinlu
 */
@RestController
public class TestController {

    @Autowired
    private SayHelloRemote sayHelloRemote;

    @GetMapping("/say/{who}")
    public String test(@PathVariable("who") String name) {
        return sayHelloRemote.sayHello(name);
    }


    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "/uploada", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("file") MultipartFile file) {
        return uploadService.upload(file);
    }
}
