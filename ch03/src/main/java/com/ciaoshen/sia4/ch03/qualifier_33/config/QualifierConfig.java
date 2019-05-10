package com.ciaoshen.sia4.ch03.qualifier_33.config;

// spring framework
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
// my package
import com.ciaoshen.sia4.ch03.qualifier_33.Dessert;
import com.ciaoshen.sia4.ch03.qualifier_33.IceCream;
import com.ciaoshen.sia4.ch03.qualifier_33.Popsicle;
// slf4j
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class QualifierConfig {

    @Autowired
    @Bean
    public Dessert getIceCream(Logger log) {
        Dessert icecream = new IceCream();
        if (log.isDebugEnabled()) {
            log.debug("1 dessert created. -> " + icecream);
        }
        return icecream;
    }

    @Autowired
    @Bean
    public Dessert getPopsicle(Logger log) {
        Dessert popsicle = new Popsicle();
        if (log.isDebugEnabled()) {
            log.debug("1 dessert created. -> " + popsicle);
        }
        return popsicle;
    }

    @Bean
    public Logger getLogger() {
        Logger log = LoggerFactory.getLogger(QualifierConfig.class);
        if (log != null && log.isDebugEnabled()) {
            log.debug("logger created in qualifier_33 test.");
        }
        return log;
    }

}
