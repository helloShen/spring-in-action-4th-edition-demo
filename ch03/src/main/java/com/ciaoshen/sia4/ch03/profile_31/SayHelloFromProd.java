package com.ciaoshen.sia4.ch03.profile_31;

// log4j & slf4j
import org.slf4j.Logger;

public class SayHelloFromProd implements SayHello {

    private Logger log;
    private String envName = "production environment";

    public SayHelloFromProd(Logger log) {
        this.log = log;
        if (log.isDebugEnabled()) {
            log.debug("Call SayHelloFromProd constructor to create instance.");
        }
    }

    public String sayHello() {
        return "Say hello from " + envName + ".";
    }

}
