package demo.springboot.controller;

import demo.springboot.entity.JsonResult;
import demo.springboot.entity.SysUser;
import demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * mybatis 测试controller
 *
 * @author zt1994
 * @date 2020/10/8 20:22
 */
@RestController
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private UserService userService;

    /**
     * 保存用户
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveUser")
    public JsonResult saveUser() throws Exception {
        SysUser user = new SysUser();
        user.setId("1");
        user.setUsername("mybatis" + new Date());
        user.setNickname("mybatis" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);

        return JsonResult.ok("保存成功");
    }


    /**
     * 更新用户
     *
     * @return
     */
    @RequestMapping("/updateUser")
    public JsonResult updateUser() {

        SysUser user = new SysUser();
        user.setId("2");
        user.setUsername("2-updated" + new Date());
        user.setNickname("2-updated" + new Date());
        user.setPassword("2-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return JsonResult.ok("保存成功");
    }


    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/deleteUser")
    public JsonResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return JsonResult.ok("删除成功");
    }


    /**
     * 通过id查询用户
     *
     * @param userId
     * @return
     */
    @RequestMapping("/queryUserById")
    public JsonResult queryUserById(String userId) {

        return JsonResult.ok(userService.queryUserById(userId));
    }


    /**
     * 查询用户列表
     *
     * @return
     */
    @RequestMapping("/queryUserList")
    public JsonResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("peter");
        user.setNickname("p");

        List<SysUser> userList = userService.queryUserList(user);

        return JsonResult.ok(userList);
    }


    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @RequestMapping("/queryUserListPaged")
    public JsonResult queryUserListPaged(Integer page) {
        if (page == null) {
            page = 1;
        }
        int pageSize = 3;

        SysUser user = new SysUser();
        //user.setNickname("p");

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return JsonResult.ok(userList);
    }


    /**
     * 自定义mapper查询
     *
     * @param userId
     * @return
     */
    @RequestMapping("/queryUserByIdCustom")
    public JsonResult queryUserByIdCustom(String userId) {
        return JsonResult.ok(userService.queryUserByIdCustom(userId));
    }


    /**
     * 测试事务
     *
     * @return
     */
    @RequestMapping("/saveUserTransactional")
    public JsonResult saveUserTransactional() {
        SysUser user = new SysUser();
        user.setId("1002");
        user.setUsername("mark" + new Date());
        user.setNickname("mark" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return JsonResult.ok("保存成功");
    }
}
