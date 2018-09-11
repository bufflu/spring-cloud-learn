package com.frog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController
 * Description:
 * Date: 2018/8/28 16:38
 * @RefreshScope： 通过配置中心获取的值得类上加该注解，通过POST请求/refresh可刷新值
 * @author guoxinlu
 */
@RestController
@RefreshScope
public class TestController {

    @GetMapping("/test")
    public String test() {
        return this.str;
    }

    @Value("${str}")
    private String str;
}
