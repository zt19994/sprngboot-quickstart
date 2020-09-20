package demo.springboot.controller;

import demo.springboot.entity.User;
import demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @author zt1994 2020/9/20 16:40
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName", required = true) String userName) {
        return userService.findByName(userName);
    }
}
