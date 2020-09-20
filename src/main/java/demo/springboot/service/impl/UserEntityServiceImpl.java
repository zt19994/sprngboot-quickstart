package demo.springboot.service.impl;

import demo.springboot.entity.User;
import demo.springboot.entity.UserEntity;
import demo.springboot.service.UserEntityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * user entity 业务层
 *
 * @author zt1994 2020/9/17 16:25
 */
@Service
public class UserEntityServiceImpl implements UserEntityService {

    /**
     * 查找所有
     *
     * @return
     */
    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setName("peter");
        user.setAge(18);
        user.setBirthday("2020-12-12");
        list.add(user);
        return list;
    }

    @Override
    public User insertByUser(UserEntity user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User update(UserEntity user) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }
}
