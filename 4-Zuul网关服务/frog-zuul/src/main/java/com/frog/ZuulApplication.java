package com.frog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ClassName: ZuulApplication
 * Description: API网关
 * Date: 2018/8/21 09:22
 * @EnableZuulProxy 开启zuul的api网关功能
 * @author guoxinlu
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
