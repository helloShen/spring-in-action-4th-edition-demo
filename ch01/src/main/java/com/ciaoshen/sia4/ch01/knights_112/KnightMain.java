package com.ciaoshen.sia4.ch01.knights_112;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightMain {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.ciaoshen.sia4.ch01.knights_112.config");
		Knight knight = context.getBean(Knight.class);
		knight.embarkOnQuest();
		context.close();
	}

}
