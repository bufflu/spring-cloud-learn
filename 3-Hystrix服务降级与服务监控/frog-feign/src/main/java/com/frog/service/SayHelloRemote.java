package com.frog.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: SayHelloRemote
 * Description: 调用其他微服务的方法接口
 * Date: 2018/8/14 18:32
 *
 * @author guoxinlu
 */
@Service
@FeignClient(value = "frog-producer", fallback = SayHelloRemoteFallback.class)
public interface SayHelloRemote {

    /**
     * 请求的参数、请求方式、返回值必须保持一致
     * @RequestParam 的value不能为空，feign是根据value绑定参数的，为空时会抛出异常
     */
    @RequestMapping(
            value = "/sayHello",
            method = RequestMethod.GET
    )
    String sayHello(@RequestParam("name") String name);
}
