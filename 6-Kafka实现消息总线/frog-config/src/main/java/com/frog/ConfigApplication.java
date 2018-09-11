package com.frog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName: ConfigApplication
 * Description: 配置中心
 * Date: 2018/8/27 09:37
 *
 * @author guoxinlu
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigApplication {

    public static void main(String[] args) throws IOException {
        // 加载自定义配置文件
        Properties properties = new Properties();
        InputStream inputStream = ConfigApplication.class.getClassLoader().getResourceAsStream("properties/kafka-dev.properties");
        properties.load(inputStream);
        // 测试有没有加载
        System.out.println(properties.getProperty("spring.cloud.stream.kafka.binder.brokers"));
        SpringApplication sa = new SpringApplication(ConfigApplication.class);
        sa.setDefaultProperties(properties);
        sa.run(args);
    }
}
