package com.ciaoshen.sia4.ch05.with_parameter_53.spittr;

// spring framework
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
// junit
import org.junit.Test;
// my project package
import com.ciaoshen.sia4.ch05.with_parameter_53.spittr.web.HomeController;
import com.ciaoshen.sia4.ch05.with_parameter_53.spittr.web.SpittleController;
import com.ciaoshen.sia4.ch05.with_parameter_53.spittr.data.SpittleRepository;
// java util
import java.util.Date;

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
    public void shouldShowSpittleFound() throws Exception {
        // spittles
        Spittle expectedSpittle = new Spittle("Hello World!", new Date());
        // mock repository
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
        // mock controller
        SpittleController controller = new SpittleController(mockRepository);
        // mock MVC
        MockMvc mockMvc = standaloneSetup(controller)
            .setSingleView(
                new InternalResourceView("/WEB-INF/views/spittle.jsp")) // mocked view, no need for real .jsp file
            .build();
        // test
        mockMvc.perform(get("/spittle/12345"))
            .andExpect(view().name("spittle"))
            .andExpect(model().attributeExists("spittle")) // key是自动推断的，因为是Spittle类型，所以key推断为spittle
            .andExpect(model().attribute("spittle", expectedSpittle));
    }

}
