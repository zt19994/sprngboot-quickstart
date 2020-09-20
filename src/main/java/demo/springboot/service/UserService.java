package demo.springboot.service;

import demo.springboot.entity.User;

/**
 * 用户业务层
 *
 * @author zt1994 2020/9/20 16:37
 */
public interface UserService {


    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    User findByName(String userName);
}
