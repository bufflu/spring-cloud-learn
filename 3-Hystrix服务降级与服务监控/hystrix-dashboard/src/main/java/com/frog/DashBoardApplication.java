package com.frog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * ClassName: DashBoardApplication
 * Description: Hystrix仪表盘
 * Date: 2018/8/20 11:24
 *
 * 通过仪表盘对单个实例做监控信息
 * @author guoxinlu
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashBoardApplication.class, args);
    }
}
