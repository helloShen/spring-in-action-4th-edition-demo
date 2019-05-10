package com.ciaoshen.sia4.ch03.profile_31;

// log4j & slf4j
import org.slf4j.Logger;

public class SayHelloFromDev implements SayHello {

    private Logger log;
    private String envName = "develop environment";

    public SayHelloFromDev(Logger log) {
        this.log = log;
        if (log.isDebugEnabled()) {
            log.debug("Call SayHelloFromDev constructor to create instance.");
        }
    }

    public String sayHello() {
        return "Say hello from " + envName + ".";
    }

}
