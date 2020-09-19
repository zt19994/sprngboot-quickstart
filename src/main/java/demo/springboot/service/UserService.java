package demo.springboot.service;

import demo.springboot.entity.User;

import java.util.List;

/**
 * user service
 *
 * @author zt1994 2020/9/17 16:25
 */
public interface UserService {

    /**
     * 查找所有
     *
     * @return
     */
    public List<User> findAll();

    public User insertByUser(User user);

    public User findById(Long id);

    public User update(User user);

    public User delete(Long id);
}
