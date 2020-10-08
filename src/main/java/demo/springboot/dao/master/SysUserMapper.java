package demo.springboot.dao.master;

import demo.springboot.entity.SysUser;
import demo.springboot.utils.MyMapper;
import org.springframework.stereotype.Component;

/**
 * SysUserMapper
 *
 * @author zt1994
 * @date 2020/10/8 19:41
 */
@Component
public interface SysUserMapper extends MyMapper<SysUser> {
}