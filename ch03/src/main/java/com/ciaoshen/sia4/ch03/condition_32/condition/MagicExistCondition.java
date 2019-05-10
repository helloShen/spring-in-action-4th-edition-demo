package com.ciaoshen.sia4.ch03.condition_32.condition;

// spring framework
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
// slf4j
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicExistCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Logger log = LoggerFactory.getLogger(MagicExistCondition.class);
        Environment env = context.getEnvironment();
        if (env == null) {
            if (log.isDebugEnabled()) {
                log.debug("Environment object is null!");
            }
        } else {
            String magicProp = env.getProperty("magic");
            if (log.isDebugEnabled()) {
                log.debug("magic environment property = " + magicProp);
            }
        }
        return env.getProperty("magic", "OFF").equals("ON");
    }

}
