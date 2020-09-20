package demo.springboot.service;

import demo.springboot.entity.User;
import demo.springboot.entity.UserEntity;

import java.util.List;

/**
 * user service
 *
 * @author zt1994 2020/9/17 16:25
 */
public interface UserEntityService {

    /**
     * 查找所有
     *
     * @return
     */
    public List<UserEntity> findAll();

    public User insertByUser(UserEntity user);

    public User findById(Long id);

    public User update(UserEntity user);

    public User delete(Long id);
}
