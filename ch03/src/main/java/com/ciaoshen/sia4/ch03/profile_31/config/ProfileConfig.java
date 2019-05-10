package com.ciaoshen.sia4.ch03.profile_31.config;

// spring
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Autowired;
// my package
import com.ciaoshen.sia4.ch03.profile_31.SayHello;
import com.ciaoshen.sia4.ch03.profile_31.SayHelloFromDev;
import com.ciaoshen.sia4.ch03.profile_31.SayHelloFromProd;
// log4j & slf4j
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// java utils
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

@Configuration
public class ProfileConfig {

    @Autowired
    @Bean(name="say-hello-from-dev")
    @Profile("dev")
    public SayHello sayHelloFromDev(Logger log) {
        SayHello hello = new SayHelloFromDev(log);
        if (log.isDebugEnabled()) {
            log.debug("My SayHelloFromDev war born alive!");
            log.debug("{}", hello.sayHello());
        }
        return hello;
    }

    @Autowired
    @Bean(name="say-hello-from-prod")
    @Profile("prod")
    public SayHello sayHelloFromProd(Logger log) {
        return new SayHelloFromProd(log);
    }

    @Bean(name="profile-log")
    @Profile({"dev", "prod"})
	public Logger getLogger() {
        Logger log = LoggerFactory.getLogger(ProfileConfig.class);
        if (log.isDebugEnabled()) {
            log.debug("Logger for profile created!");
        }
        return log;
    }

}
