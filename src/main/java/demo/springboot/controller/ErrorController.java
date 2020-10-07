package demo.springboot.controller;

import demo.springboot.entity.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * error controller
 *
 * @author zt1994
 * @date 2020/10/7 20:18
 */
@Controller
@RequestMapping("/err")
public class ErrorController {

    /**
     * 错误页面
     *
     * @return
     */
    @GetMapping("/error")
    public String error() {
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @GetMapping("/ajaxerror")
    public String ajaxerror() {
        return "thymeleaf/ajaxerror";
    }

    @GetMapping("/getAjaxerror")
    public JsonResult getAjaxerror() {
        int a = 1 / 0;
        return JsonResult.ok();
    }
}
