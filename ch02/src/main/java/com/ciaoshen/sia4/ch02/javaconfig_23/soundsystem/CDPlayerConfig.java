package com.ciaoshen.sia4.ch02.javaconfig_23.soundsystem;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;

import com.ciaoshen.sia4.ch02.javaconfig_23.soundsystem.CompactDisc;
import com.ciaoshen.sia4.ch02.javaconfig_23.soundsystem.SixPense;
import com.ciaoshen.sia4.ch02.javaconfig_23.soundsystem.MyOldClassmate;
import com.ciaoshen.sia4.ch02.javaconfig_23.soundsystem.CDPlayer;

import java.util.Random;

@Configuration
public class CDPlayerConfig {

    @Bean(name = "six-pense")
    public CompactDisc sixPense() {
        return new SixPense();
    }

    @Bean(name = "my-old-classmate")
    public CompactDisc myOldClassmate() {
        return new MyOldClassmate();
    }

    // 不会真的调用sixPense()或myOldClassmate()，会被spring监控拦截，返回单例。
    @Bean(name = "random-player")
    public CDPlayer randomPlayer() {
        Random r = new Random();
        int num = r.nextInt(1);
        switch (num) {
            case 0:
                return new CDPlayer(sixPense());
            case 1:
                return new CDPlayer(myOldClassmate());
            default:
                return null;
        }
    }

}
