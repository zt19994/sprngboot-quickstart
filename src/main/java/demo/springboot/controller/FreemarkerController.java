package demo.springboot.controller;

import demo.springboot.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * freemarker 模板引擎controller
 *
 * @author zt1994
 * @date 2020/10/7 12:21
 */
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;


    /**
     * 测试index
     *
     * @param map
     * @return
     */
    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }


    /**
     * 测试访问模板路径
     *
     * @return
     */
    @RequestMapping("/center")
    public String center() {
        return "freemarker/center/center";
    }


}
