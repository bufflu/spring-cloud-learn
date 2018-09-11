package com.frog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: ProducerApplication
 * Description: 生产者，服务提供者
 * Date: 2018/8/10 16:07
 * @EnableDiscoveryClient 被注册中心发现的客户端
 * @author guoxinlu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
