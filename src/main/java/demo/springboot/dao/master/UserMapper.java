package demo.springboot.dao.master;

import demo.springboot.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 dao 接口类
 *
 * @author zt1994 2020/9/19 20:09
 */
public interface UserMapper {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User findByName(@Param("userName") String userName);
}
