/**
package com.ciaoshen.sia4.ch04.aop_aspectj_45;

// junit & hamcrest
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.junit.Test;
// spring framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// my project
import com.ciaoshen.sia4.ch04.aop_aspectj_45.concert.Performance;
import com.ciaoshen.sia4.ch04.aop_aspectj_45.config.AopAspectjConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopAspectjConfig.class)
public class TestAopAspectj {

    @Autowired
    private Performance performance;

    @Test
    public void testAopAspectj() {
     performance.perform();
     assertNotNull(performance);
    }

}
*/
