package com.ciaoshen.sia4.ch04.aop_aspectj_45.config;

// spring framework
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
// my project
import com.ciaoshen.sia4.ch04.aop_aspectj_45.concert.CriticismEngine;
import com.ciaoshen.sia4.ch04.aop_aspectj_45.concert.CriticismEngineImpl;
import com.ciaoshen.sia4.ch04.aop_aspectj_45.concert.Performance;
import com.ciaoshen.sia4.ch04.aop_aspectj_45.concert.PerformanceImpl;


@Configuration
@ImportResource("classpath:aop_aspectj_45/concert.xml")
public class AopAspectjConfig {

    @Bean(name = "performance")
    public Performance getPerformance() {
        return new PerformanceImpl();
    }

    @Bean(name = "criticismEngine")
    public CriticismEngine getCriticismEngine() {
        return new CriticismEngineImpl();
    }

}
