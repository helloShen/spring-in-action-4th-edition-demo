package com.ciaoshen.sia4.ch01.helloworld_111;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.ciaoshen.sia4.ch01.helloworld_111.config");
        HelloWorldBean helloworld = context.getBean(HelloWorldBean.class);
        System.out.println(helloworld.sayHello());
        context.close();
    }

}
