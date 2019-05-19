package com.ciaoshen.sia4.ch04.aop_parameter_xml_44;

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
import com.ciaoshen.sia4.ch04.aop_parameter_xml_44.CompactDisc;
import com.ciaoshen.sia4.ch04.aop_parameter_xml_44.TrackCounter;
// java utils
import java.util.Map;
import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aop_parameter_xml_44/beans.xml")
public class TestAopParameterXml {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private TrackCounter counter;

    @Test
    public void testAopParameterXml() {
        int before = totalCount();
        int cdSize = cd.size();
        int num = 10;
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            cd.playTrack(r.nextInt(cdSize));
        }
        System.out.println("Track Counter = " + counter.getCount());
        int after = totalCount();
        assertThat(after - before == num, is(true));
    }

    private int totalCount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : counter.getCount().entrySet()) {
            int count = entry.getValue();
            System.out.println("Track #" + entry.getKey() + " played [" + count + "] times.");
            sum += count;
        }
        return sum;
    }

}
