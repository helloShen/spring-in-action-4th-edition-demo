package com.ciaoshen.sia4.ch05.post_form_54.spittr.web;

// spring framework
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
// my project package
import com.ciaoshen.sia4.ch05.post_form_54.spittr.Spitter;
import com.ciaoshen.sia4.ch05.post_form_54.spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    /** 注册表单入口 */
    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    /** 注册信息储存，并跳转到用户信息页面 */
    @RequestMapping(value="/register", method=POST)
    public String processRegistration(Spitter spitter) {
        if (spitter != null) {
            System.out.println("spitter.firstName = " + spitter.getFirstName());
            System.out.println("spitter.lastName = " + spitter.getLastName());
            System.out.println("spitter.username = " + spitter.getUsername());
            System.out.println("spitter.password = " + spitter.getPassword());
        } else {
            System.out.println("spitter is NULL!");
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    /** 负责显示单个注册用户信息页面 */
    @RequestMapping(value="{username}", method=GET)
    public String showSpitterInfo(@PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

}
