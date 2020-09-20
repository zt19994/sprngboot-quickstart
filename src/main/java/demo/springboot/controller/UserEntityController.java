package demo.springboot.controller;

import demo.springboot.entity.UserEntity;
import demo.springboot.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * user controller
 *
 * @author zt1994 2020/9/17 16:24
 */
@Controller
@RequestMapping(value = "/users")
public class UserEntityController {


    @Autowired
    private UserEntityService userEntityService;


    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public String getUserList(ModelMap map) {
        map.addAttribute("userList", userEntityService.findAll());
        return "userList";
    }

    /**
     * 显示创建用户表单
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new UserEntity());
        map.addAttribute("action", "create");
        return "userForm";
    }

    /**
     * 创建用户
     * 处理 "/users" 的 POST 请求，用来获取用户列表
     * 通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(ModelMap map,
                           @ModelAttribute @Valid UserEntity user,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "userForm";
        }

        userEntityService.insertByUser(user);

        return "redirect:/users/";
    }


    /**
     * 显示需要更新用户表单
     * 处理 "/users/{id}" 的 GET 请求，通过 URL 中的 id 值获取 User 信息
     * URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("user", userEntityService.findById(id));
        map.addAttribute("action", "update");
        return "userForm";
    }

    /**
     * 处理 "/users/{id}" 的 PUT 请求，用来更新 User 信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(ModelMap map,
                          @ModelAttribute @Valid UserEntity user,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "update");
            return "userForm";
        }

        userEntityService.update(user);
        return "redirect:/users/";
    }

    /**
     * 处理 "/users/{id}" 的 GET 请求，用来删除 User 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {

        userEntityService.delete(id);
        return "redirect:/users/";
    }
}