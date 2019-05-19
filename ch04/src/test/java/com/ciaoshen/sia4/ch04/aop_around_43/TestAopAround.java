package com.ciaoshen.sia4.ch04.aop_around_43;

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
import com.ciaoshen.sia4.ch04.aop_around_43.concert.Performance;
import com.ciaoshen.sia4.ch04.aop_around_43.config.AopAroundConfig;
// java utils
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopAroundConfig.class)
public class TestAopAround {

    @Autowired
    private Performance performance;

    @Test
    public void testAopAround() {
        Set<Integer> performed = new HashSet<>();
        List<String> performedList = new ArrayList<>();
        Random r = new Random();
        int size = performance.size();
        for (int i = 0; i < size / 2; i++) {
            int next = 0;
            while (true) {
                next = r.nextInt(size);
                if (performed.add(next)) break;
            }
            performance.perform(next);
            performedList.add(performance.whatsOnStage());
        }
        assertThat(performedList.size() == performance.size() / 2, is(true));
        assertThat(performance.getPerformanceList().containsAll(performedList), is(true));
    }

}
