package com.ciaoshen.sia4.ch05.with_parameter_53.spittr.web;

// spring framework
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method=GET)
    public String home() {
        return "home";
    }

}
