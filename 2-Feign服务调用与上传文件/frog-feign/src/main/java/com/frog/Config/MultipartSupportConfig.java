package com.frog.Config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * ClassName: MultipartSupportConfig
 * Description: 上传文件
 * Date: 2018/8/15 19:00
 *
 * @author guoxinlu
 */
@Configuration
public class MultipartSupportConfig {

    @Bean
    public Encoder feignFormEncoder(){
        return new SpringFormEncoder();
    }
}
