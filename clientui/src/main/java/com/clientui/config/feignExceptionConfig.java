package com.clientui.config;

import com.clientui.exceptions.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class feignExceptionConfig {
    
    @Bean
    public CustomErrorDecoder mCustomErrorDecoder () {
        return  new CustomErrorDecoder();
    }

}
