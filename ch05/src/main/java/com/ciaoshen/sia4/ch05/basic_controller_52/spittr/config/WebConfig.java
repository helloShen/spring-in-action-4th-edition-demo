package com.ciaoshen.sia4.ch05.basic_controller_52.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * WebMvcConfigurerAdapter是WebMvcConfigurer接口的基本实现。
 * 继承WebMvcConfigurerAdapter就只需要重写部分有改动的方法即可。
 * 从Java 8开始接口允许可以有default默认实现，所以WebMvcConfigurerAdapter整个类被弃用。
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.ciaoshen.sia4.ch05.basic_controller_52.spitter.web")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 要求DispatcherServlet将对静态资源的请求转发到容器中默认的Servlet上，
     * 而不是使用DispatcherServlet本身来处理此类请求。
     * 比如请求静态资源 "http://localhost:8080/spittr/resource.txt" 时，
     * resolver会将路径映射为 "classpath:/META-INF/resources/spittr/resource.txt"
     */
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
