package com.ciaoshen.sia4.ch01.minstrel_113.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ciaoshen.sia4.ch01.minstrel_113.BraveKnight;
import com.ciaoshen.sia4.ch01.minstrel_113.Knight;
import com.ciaoshen.sia4.ch01.minstrel_113.Quest;
import com.ciaoshen.sia4.ch01.minstrel_113.SlayDragonQuest;
import com.ciaoshen.sia4.ch01.minstrel_113.Minstrel;


@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class MinstrelConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Minstrel minstrel() {
        return new Minstrel(System.out);
    }

}
