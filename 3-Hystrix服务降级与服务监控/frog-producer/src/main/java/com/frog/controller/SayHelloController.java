package com.frog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: SayHelloController
 * Description: 测试服务提供者
 * Date: 2018/8/10 16:15
 *
 * @author guoxinlu
 */
@RestController
public class SayHelloController {

    @RequestMapping(
            value = "/sayHello",
            method = RequestMethod.GET
    )
    public String sayHello(String name) {
        return name + " say hello! ============";
    }

    @GetMapping("/testSay")
    public String testSay() {
        return "this is test return port:10002";
    }
}
