package com.ciaoshen.sia4.ch05.basic_controller_52.spittr;

// spring framework
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
// junit
import org.junit.Test;
import static org.hamcrest.Matchers.*;
// my project package
import com.ciaoshen.sia4.ch05.basic_controller_52.spittr.web.HomeController;
import com.ciaoshen.sia4.ch05.basic_controller_52.spittr.web.SpittleController;
import com.ciaoshen.sia4.ch05.basic_controller_52.spittr.data.SpittleRepository;
// java util
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    /**
     * repository是模拟的：自动返回20个createSpittleList()函数预构建的Spittle
     * view是模拟的：MockMvc对象中预设了假象的jsp路径 "/WEB-INF/views/spittles.jsp"（实际并不存在）
     * 服务器是模拟的：MockMvc对象
     *
     * 只有Controller是真的。
     */
    @Test
    public void shouldShowRecentSpittles() throws Exception {
        // spittles
        List<Spittle> expectedSpittles = createSpittleList(20);
        // mock repository
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
        // mock controller
        SpittleController controller = new SpittleController(mockRepository);
        // mock MVC
        MockMvc mockMvc = standaloneSetup(controller)
            .setSingleView(
                new InternalResourceView("/WEB-INF/views/spittles.jsp")) // mocked view, no need for real .jsp file
            .build();
        // test
        mockMvc.perform(get("/spittles"))
            .andExpect(view().name("spittles"))
            .andExpect(model().attributeExists("spittleList")) // key值推断为 "spittleList"，因为value是一个 List<Spittle> 类型
            .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray()))); // hasItems() comes from hamcrest
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

}
