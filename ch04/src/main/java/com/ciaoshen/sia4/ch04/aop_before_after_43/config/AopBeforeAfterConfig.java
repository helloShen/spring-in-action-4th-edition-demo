package com.ciaoshen.sia4.ch04.aop_before_after_43.config;

// spring framework
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
// my project
import com.ciaoshen.sia4.ch04.aop_before_after_43.concert.Audience;
import com.ciaoshen.sia4.ch04.aop_before_after_43.concert.GuoDeGangZhuanChang;
import com.ciaoshen.sia4.ch04.aop_before_after_43.concert.Performance;


@Configuration
@EnableAspectJAutoProxy
public class AopBeforeAfterConfig {

    @Bean(name = "performance")
    public Performance getPerformance() {
        return new GuoDeGangZhuanChang();
    }

    @Bean(name = "audience")
    public Audience getAudience() {
        return new Audience();
    }

}
