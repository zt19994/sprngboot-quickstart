package demo.springboot.service;

import demo.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * user service
 *
 * @author zt1994 2020/9/17 16:25
 */
@Service
public class UserService {

    /**
     * 查找所有
     *
     * @return
     */
    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setId(1L);
        user.setName("peter");
        user.setAge(18);
        user.setBirthday("2020-12-12");
        list.add(user);
        return list;
    }

    public User insertByUser(User user) {
        return null;
    }

    public User findById(Long id) {
        return null;
    }

    public User update(User user) {
        return null;
    }

    public User delete(Long id) {
        return null;
    }
}
