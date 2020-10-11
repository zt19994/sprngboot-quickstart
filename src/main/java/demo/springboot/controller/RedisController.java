package demo.springboot.controller;

import demo.springboot.entity.JsonResult;
import demo.springboot.entity.SysUser;
import demo.springboot.entity.User;
import demo.springboot.utils.JsonUtils;
import demo.springboot.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * redis controller
 *
 * @author zt1994
 * @date 2020/10/11 17:27
 */
@RestController
@RequestMapping("redis")
public class RedisController {


    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;


    @RequestMapping("/test")
    public JsonResult test() {

        strRedis.opsForValue().set("cache", "hello redis");

        SysUser user = new SysUser();
        user.setId("1009");
        user.setUsername("peter");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));

        SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);

        return JsonResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public JsonResult getJsonList() {

        User user = new User();
        user.setAge(18);
        user.setName("test1");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("test2");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("test3");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:userlist");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JsonResult.ok(userListBorn);
    }
}
