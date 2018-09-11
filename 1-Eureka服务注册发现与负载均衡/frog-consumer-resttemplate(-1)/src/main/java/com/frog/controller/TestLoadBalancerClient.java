package com.frog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: TestLoadBalancerClient
 * Description: 测试负载均衡
 * Date: 2018/8/14 16:44
 *
 * @author guoxinlu
 */
@RestController
public class TestLoadBalancerClient {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        // 负载均衡策略：轮询，根据端口号可以看出
        ServiceInstance serviceInstance = loadBalancerClient.choose("frog-producer");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/testSay";
        System.out.println("request url: " + url);
        return restTemplate.getForObject(url, String.class);
    }
}
