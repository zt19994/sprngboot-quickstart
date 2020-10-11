package demo.springboot.controller.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 第一个拦截器controller
 *
 * @author zt1994
 * @date 2020/10/11 21:51
 */
@Controller
@RequestMapping("one")
public class OneController {

    /**
     * thymeleaf index
     *
     * @param map
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf 模板测试");
        return "thymeleaf/index";
    }


    /**
     * thymeleaf center
     *
     * @return
     */
    @GetMapping("/center")
    public String center() {
        return "thymeleaf/center/center";
    }
}
