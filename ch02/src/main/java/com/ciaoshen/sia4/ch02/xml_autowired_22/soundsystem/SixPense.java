package com.ciaoshen.sia4.ch02.xml_autowired_22.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class SixPense implements CompactDisc {

    private String title = "Life is more than six pense";
    private String artist = "Dajin AI";

    public void play() {
        System.out.println("Playing [" + title + "] by @" + artist);
    }

}
