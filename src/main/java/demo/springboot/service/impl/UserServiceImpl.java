package demo.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import demo.springboot.dao.cluster.CityMapper;
import demo.springboot.dao.master.SysUserMapper;
import demo.springboot.dao.master.SysUserMapperCustom;
import demo.springboot.dao.master.UserMapper;
import demo.springboot.entity.City;
import demo.springboot.entity.SysUser;
import demo.springboot.entity.User;
import demo.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户业务实现层
 *
 * @author zt1994 2020/9/20 16:38
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 主数据源
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 从数据源
     */
    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperCustom userMapperCustom;


    /**
     * 根据用户名查找城市
     *
     * @param userName
     * @return
     */
    @Override
    public User findByName(String userName) {
        User user = userMapper.findByName(userName);
        City city = cityMapper.findByName("成都市");
        user.setCity(city);
        return user;
    }


    /**
     * 保存用户
     *
     * @param user
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveUser(SysUser user) throws Exception {
        sysUserMapper.insert(user);
    }


    /**
     * 更新用户
     *
     * @param user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteUser(String userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public SysUser queryUserById(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<SysUser> queryUserList(SysUser user) {
        return sysUserMapper.selectByExample(user);
    }


    /**
     * 分页查询
     *
     * @param user
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        // 开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        return sysUserMapper.selectByExample(example);
    }


    /**
     * 自定义mapper查询
     *
     * @param userId
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public SysUser queryUserByIdCustom(String userId) {
        List<SysUser> userList = userMapperCustom.queryUserSimplyInfoById(userId);
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    /**
     * 事务管理
     *
     * @param user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveUserTransactional(SysUser user) {
        sysUserMapper.insert(user);
        int a = 1 / 0;
        user.setIsDelete(1);
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

}