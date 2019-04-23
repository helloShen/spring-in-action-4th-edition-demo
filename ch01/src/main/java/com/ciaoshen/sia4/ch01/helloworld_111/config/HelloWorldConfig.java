package com.ciaoshen.sia4.ch01.helloworld_111.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ciaoshen.sia4.ch01.helloworld_111.HelloWorldBean;

@Configuration
public class HelloWorldConfig {
    @Bean
    public HelloWorldBean helloworld() {
        return new HelloWorldBean();
    }
}
