package com.frog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: SpringCloudEurekaApplication
 * Description: 注册中心
 * Date: 2018/8/10 15:36
 * @EnableEurekaServer 注解表示开启注册中心服务
 * @author guoxinlu
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaApplication.class, args);

        // 可以设置关闭headless模式、web项目等
        // SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringCloudEurekaApplication.class);
        // builder.headless(false).web(true).run(args);
    }
}
