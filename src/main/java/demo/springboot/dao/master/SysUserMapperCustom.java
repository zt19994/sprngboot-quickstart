package demo.springboot.dao.master;

import demo.springboot.entity.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义mapper
 *
 * @author zt1994
 * @date 2020/10/9 21:26
 */
@Component
public interface SysUserMapperCustom {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    List<SysUser> queryUserSimplyInfoById(String id);
}
