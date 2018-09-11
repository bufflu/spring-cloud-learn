package com.frog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:
 * Description:
 * Date: 2018/9/5 16:57
 *
 * @author guoxinlu
 */
@RestController
public class TestController {

    @Value("${spring.cloud.stream.kafka.binder.brokers}")
    private String str;

    @GetMapping("/test")
    public String test() {
        return str;
    }
}
