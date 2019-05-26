package com.ciaoshen.sia4.ch05.post_form_54.spittr;

// spring framework
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
// junit
import org.junit.Test;
// my project package
import com.ciaoshen.sia4.ch05.post_form_54.spittr.web.SpitterController;
import com.ciaoshen.sia4.ch05.post_form_54.spittr.data.SpitterRepository;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
            .andExpect(view().name("registerForm"));

        mockMvc.perform(post("/spitter/register")
            .param("firstName", "Jack")
            .param("lastName", "Bauer")
            .param("username", "jbauer")
            .param("password", "24hours"))
            .andExpect(redirectedUrl("/spitter/jbauer"));

        // verify(mockRepository, atLeastOnce()).save(unsaved);
    }


}
