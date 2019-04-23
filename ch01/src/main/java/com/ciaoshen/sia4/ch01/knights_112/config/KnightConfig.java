package com.ciaoshen.sia4.ch01.knights_112.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ciaoshen.sia4.ch01.knights_112.BraveKnight;
import com.ciaoshen.sia4.ch01.knights_112.Knight;
import com.ciaoshen.sia4.ch01.knights_112.Quest;
import com.ciaoshen.sia4.ch01.knights_112.SlayDragonQuest;

@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

}
