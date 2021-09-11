package cn.tongyl.febs.server.system.service;

import cn.tongyl.febs.common.entity.system.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author create by Tunyl on 2021/9/5
 * @version 1.0
 */
public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}
