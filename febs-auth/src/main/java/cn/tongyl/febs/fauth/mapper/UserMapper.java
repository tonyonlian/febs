package cn.tongyl.febs.fauth.mapper;

import cn.tongyl.febs.common.entity.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author create by Tunyl on 2021/8/22
 * @version 1.0
 */
public interface UserMapper extends BaseMapper<SystemUser> {
    /**
     * 通过名子查询用户
     * @param name 用户名称
     * @return SystemUser
     */
    SystemUser findByName(String name);
}
