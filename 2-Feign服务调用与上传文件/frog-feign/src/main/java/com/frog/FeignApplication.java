package com.frog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: FeignApplication
 * Description: 通过声明示服务调用的客户端
 * Date: 2018/8/14 18:27
 * @EnableFeignClients: 开启feign
 * @author guoxinlu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @Controller
    public class RequestPath {
        @GetMapping("/index")
        public String toIndex() {
            return "index";
        }
    }
}
