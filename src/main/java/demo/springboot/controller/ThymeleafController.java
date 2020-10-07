package demo.springboot.controller;

import demo.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Thymeleaf 模板controller
 *
 * @author zt1994
 * @date 2020/10/7 16:32
 */
@Controller
@RequestMapping("/th")
public class ThymeleafController {

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


    /**
     * test
     *
     * @param map
     * @return
     */
    @GetMapping("/test")
    public String test(ModelMap map) {

        User u = new User();
        u.setName("manager");
        u.setAge(16);
        u.setPassword("123456");
        u.setBirthday(new Date());
        u.setDesc("<font color='green'><b>hello imooc</b></font>");
        map.addAttribute("user", u);

        User u1 = new User();
        u1.setAge(19);
        u1.setName("peter");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("mark");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);
        map.addAttribute("userList", userList);

        return "thymeleaf/test";
    }


    /**
     * 表单提交
     *
     * @param u
     * @return
     */
    @PostMapping("/postform")
    public String postForm(User u) {
        System.out.println("姓名：" + u.getName());
        System.out.println("年龄：" + u.getAge());
        return "redirect:/th/test";
    }


    /**
     * 查看错误页面
     *
     * @param u
     * @return
     */
    @GetMapping("/showerror")
    public String showError(User u) {
        int a = 1 / 0;
        return "redirect:/th/test";
    }

}
