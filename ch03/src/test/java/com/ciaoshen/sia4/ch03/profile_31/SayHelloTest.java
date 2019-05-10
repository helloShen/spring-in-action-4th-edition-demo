package com.ciaoshen.sia4.ch03.profile_31;

// junit & hamcrest
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
// spring
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
// other package in my project
import com.ciaoshen.sia4.ch03.profile_31.config.ProfileConfig;
// java utils
import java.util.Arrays;
// log4j & slf4j
import org.slf4j.Logger;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ProfileConfig.class})
@ActiveProfiles("dev")
public class SayHelloTest implements ApplicationContextAware {

	@Autowired
	private Logger log;
	@Autowired
	private SayHello sayHelloBot;
	private ApplicationContext context = null;

	private String devHello = "Say hello from develop environment.";
	private String prodHello = "Say hello from produce environment.";

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}

	@Test
	public void testSayHello() {
		if (log.isDebugEnabled()) {
			log.debug("Assign SayHello instance by @Autowired");
			log.debug(sayHelloBot.sayHello());
			SayHello hello = (SayHello) context.getBean("say-hello-from-dev");
			log.debug("Get SayHello instance from context by bean id.");
			log.debug(hello.sayHello());
			log.debug("logger full class name = {}", log.getClass().getCanonicalName());
		}
		assertThat(sayHelloBot.sayHello().equals(devHello), is(true));
	}

}
