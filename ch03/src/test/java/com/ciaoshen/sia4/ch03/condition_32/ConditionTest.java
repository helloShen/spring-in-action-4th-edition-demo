package com.ciaoshen.sia4.ch03.condition_32;

// junit
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Test;
// spring framework
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
// slf4j
import org.slf4j.Logger;
// my package
import com.ciaoshen.sia4.ch03.condition_32.config.ConditionConfig;
import com.ciaoshen.sia4.ch03.profile_31.config.ProfileConfig;
// java utils
import java.util.Arrays;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes={ConditionConfig.class})
public class ConditionTest {

    @Autowired
    private MagicBean magicBean;
    @Autowired
    private Logger log;
    @Autowired
    private ApplicationContext context;

    @Test
    public void testMagicBean() {
        if (log.isDebugEnabled()) {
         log.debug("In testMaticBean() method... ...");
        }
        printBeans();
        if (log.isDebugEnabled()) {
            if (magicBean != null) {
                log.debug("MamiMami~HONG~~~" + magicBean.magic());
            }
        }
        assertNotNull(magicBean);
    }

    public void printBeans() {
        if (log.isDebugEnabled()) {
            log.debug("{}", Arrays.asList(context.getBeanDefinitionNames()));
        }
    }

}
