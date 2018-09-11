package com.frog.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * ClassName: FeignLogginConfig
 * Description: feign客户端日志打印的配置
 * Date: 2018/8/20 11:06
 *
 * @author guoxinlu
 */
@Configuration
public class FeignLogginConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        // Feign日志级别：
        // NONE:不记录任何信息
        // BASIC: 仅记录方法、URL、响应状态码和执行时间
        // HEADERS: 除了BASIC还有请求头响应头的信息
        // FULL: 所有请求响应明细，请求头，请求体和元数据等
        return Logger.Level.FULL;
    }
}
