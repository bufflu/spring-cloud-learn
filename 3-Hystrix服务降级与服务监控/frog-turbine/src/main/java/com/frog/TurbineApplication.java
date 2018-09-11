package com.frog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * ClassName: TurbineApplication
 * Description: 集群监控
 * Date: 2018/8/20 15:19
 *
 * @author guoxinlu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class TurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApplication.class, args);
    }
}
