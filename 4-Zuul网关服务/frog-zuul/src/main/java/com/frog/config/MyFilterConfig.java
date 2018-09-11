package com.frog.config;

import com.frog.filter.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MyFilterConfig
 * Description: 自定义过滤器配置
 * Date: 2018/8/21 09:59
 *
 * @author guoxinlu
 */
@Configuration
public class MyFilterConfig {

    @Bean
    public MyFilter myFilter() {
        return new MyFilter();
    }
}
