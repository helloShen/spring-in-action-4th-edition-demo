package com.ciaoshen.sia4.ch03.qualifier_33;

//junit & hamcrest
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
// spring framework
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
// my package
import com.ciaoshen.sia4.ch03.qualifier_33.qualifier.Cold;
import com.ciaoshen.sia4.ch03.qualifier_33.qualifier.Creamy;
import com.ciaoshen.sia4.ch03.qualifier_33.qualifier.Fruity;
import com.ciaoshen.sia4.ch03.qualifier_33.config.QualifierConfig;
import com.ciaoshen.sia4.ch03.qualifier_33.Dessert;
import com.ciaoshen.sia4.ch03.qualifier_33.IceCream;
import com.ciaoshen.sia4.ch03.qualifier_33.Popsicle;
// slf4j
import org.slf4j.Logger;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes={QualifierConfig.class})
public class QualifierTest {

    @Autowired
    @Cold
    @Creamy
    private Dessert icecream;

    @Autowired
    @Cold
    @Fruity
    private Dessert popsicle;

    @Autowired
    private Logger log;

    @Test
    public void testQualifier() {
        assertThat(icecream instanceof IceCream, is(true));
        if (log.isDebugEnabled()) {
            log.debug("Object icecream is instance of IceCream.");
        }
        assertThat(popsicle instanceof Popsicle, is(true));
        if (log.isDebugEnabled()) {
            log.debug("Object popsicle is instance of Popsicle.");
        }
    }

}
