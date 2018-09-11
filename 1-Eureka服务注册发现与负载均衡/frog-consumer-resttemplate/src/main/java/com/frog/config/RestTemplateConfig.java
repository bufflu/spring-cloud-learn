package com.frog.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: RestTemplateConfig
 * Description: RestTemplate的配置
 * Date: 2018/8/14 16:42
 *
 * @author guoxinlu
 */
@Configuration
public class RestTemplateConfig {

    /**
     * @LoadBalanced: eureka包中依赖了spring-cloud-ribbon，可以实现负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
