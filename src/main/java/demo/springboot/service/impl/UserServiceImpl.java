package demo.springboot.service.impl;

import demo.springboot.dao.cluster.CityMapper;
import demo.springboot.dao.master.UserMapper;
import demo.springboot.entity.City;
import demo.springboot.entity.User;
import demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * @author zt1994 2020/9/20 16:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper; // 主数据源

    @Autowired
    private CityMapper cityMapper; // 从数据源

    @Override
    public User findByName(String userName) {
        User user = userMapper.findByName(userName);
        City city = cityMapper.findByName("成都市");
        user.setCity(city);
        return user;
    }
}