package com.ciaoshen.sia4.ch05.post_form_54.spittr.config;

// spring framework
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
    basePackages={"com.ciaoshen.sia4.ch05.post_form_54.spittr"},
    excludeFilters={
        @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
    }
)
public class RootConfig {

}
