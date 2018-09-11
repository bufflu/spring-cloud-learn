package com.frog.service;

import org.springframework.stereotype.Service;

/**
 * ClassName: SayHelloRemoteFollback
 * Description: 服务降级
 * Date: 2018/8/20 10:23
 *
 * @author guoxinlu
 */
@Service
public class SayHelloRemoteFallback implements SayHelloRemote {

    @Override
    public String sayHello(String name) {
        return "此功能模块正在维护中...";
    }
}
