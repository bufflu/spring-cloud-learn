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
    private RestTemplate restTemplate;

    /**
     * 2 在创建resttemplate时已用loadblance注解标注
     * @return
     */
    @GetMapping("/test")
    public String test() {
        // ribbon 与 eureka 集成时会从服务注册列表中获取服务实例
        // spring cloud ribbon 有一个拦截器，实际调用时会自动选取服务的实例，将ip和端口替换服务名完成调用
        return restTemplate.getForObject("http://frog-producer/testSay", String.class);
    }


    //@Autowired
    //private LoadBalancerClient loadBalancerClient;

    /**
     * 1 手动的负载均衡
     * @return
     */
    /*@GetMapping("/test")
    public String test() {
        // 负载均衡策略：轮询，根据端口号可以看出
        // 通过choose选择一个frog-producer的实例后进行消费
        ServiceInstance serviceInstance = loadBalancerClient.choose("frog-producer");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/testSay";
        System.out.println("request url: " + url);
        return restTemplate.getForObject(url, String.class);
    }*/
}
