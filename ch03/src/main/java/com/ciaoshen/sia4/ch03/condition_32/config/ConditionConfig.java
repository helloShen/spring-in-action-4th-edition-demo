package com.ciaoshen.sia4.ch03.condition_32.config;

// spring framework
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
// log4j & slf4j
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// my project
import com.ciaoshen.sia4.ch03.condition_32.MagicBean;
import com.ciaoshen.sia4.ch03.condition_32.condition.MagicExistCondition;

@Configuration
@PropertySource("classpath:env.properties")
public class ConditionConfig {

    @Autowired
    @Bean(name="magic-exist")
    @Conditional(MagicExistCondition.class)
    public MagicBean getMagicBean(Logger log) {
        MagicBean magic = new MagicBean();
        if (log.isDebugEnabled()) {
            log.debug("Magic bean created!");
        }
        return magic;
    }

    @Bean(name="log")
    public Logger getLogger() {
        Logger log = LoggerFactory.getLogger(ConditionConfig.class);
        if (log.isDebugEnabled()) {
            log.debug("General logger created!");
        }
        return log;
    }

}
