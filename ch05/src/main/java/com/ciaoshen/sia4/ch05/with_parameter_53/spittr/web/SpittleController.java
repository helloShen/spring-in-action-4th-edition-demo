package com.ciaoshen.sia4.ch05.with_parameter_53.spittr.web;

// spring framework
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// my project package
import com.ciaoshen.sia4.ch05.with_parameter_53.spittr.Spittle;
import com.ciaoshen.sia4.ch05.with_parameter_53.spittr.data.SpittleRepository;
// java util
import java.util.List;

@Controller
@RequestMapping("/spittle")
public class SpittleController {

    @Autowired
    private SpittleRepository spittleRepository;

    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * 对 http://localhost:8080/spittles/12345 发起GET请求时调用此方法
     * 通过@PathVariable拿到的 "spittleId" = 12345
     * SpittleRepository 根据12345这个ID查到 "Hello World!"这条消息
     * 把这条消息装进Model实例，交给 "WEB-INF/views/spittles.jsp" 渲染
     * 装进Model的只给了value没给key。key是根据数据类型自动推断的
     * 因为是 Spittle 型，所以 key = spittle
     */
    @RequestMapping(value="/{spittleId}", method=GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

}
