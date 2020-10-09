package demo.springboot.service;

import demo.springboot.entity.SysUser;
import demo.springboot.entity.User;

import java.util.List;

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

    /**
     * 保存用户
     *
     * @param user
     * @throws Exception
     */
    void saveUser(SysUser user) throws Exception;

    /**
     * 更新用户
     *
     * @param user
     */
    void updateUser(SysUser user);

    /**
     * 删除用户
     *
     * @param userId
     */
    void deleteUser(String userId);

    /**
     * 通过id查询用户
     *
     * @param userId
     * @return
     */
    SysUser queryUserById(String userId);

    /**
     * 查询用户列表
     *
     * @param user
     * @return
     */
    List<SysUser> queryUserList(SysUser user);

    /**
     * 分页查询
     *
     * @param user
     * @param page
     * @param pageSize
     * @return
     */
    List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    /**
     * 自定义mapper查询
     *
     * @param userId
     * @return
     */
    SysUser queryUserByIdCustom(String userId);

    /**
     * 事务管理
     *
     * @param user
     */
    void saveUserTransactional(SysUser user);
}
