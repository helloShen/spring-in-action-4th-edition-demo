package com.ciaoshen.sia4.ch05.basic_controller_52.spittr.web;

// spring framework
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// my project package
import com.ciaoshen.sia4.ch05.basic_controller_52.spittr.Spittle;
import com.ciaoshen.sia4.ch05.basic_controller_52.spittr.data.SpittleRepository;
// java util
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;

    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * 对 http://localhost:8080/spittles 发起GET请求时调用此方法
     * ViewResolver会把 "spittles" 解析成 "/WEB-INF/views/spittles.jsp"
     * 带有SpittleRepository实例的Mode对象会被传递给 spittles.jsp 页面
     * 装进Model的只给了value没给key。key是根据数据类型自动推断的
     * 因为是 List<Spittle> 型，所以 key = spittleList
     */
    @RequestMapping(method=GET)
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

}
