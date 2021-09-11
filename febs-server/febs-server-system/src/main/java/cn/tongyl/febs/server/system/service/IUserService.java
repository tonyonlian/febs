package cn.tongyl.febs.server.system.service;

import cn.tongyl.febs.common.entity.QueryRequest;
import cn.tongyl.febs.common.entity.system.SystemUser;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author create by Tunyl on 2021/9/5
 * @version 1.0
 */
public interface IUserService extends IService<SystemUser> {


    /**
     * 查询用户详情
     *
     * @param user    用户对象，用于传递查询条件
     * @param request request
     * @return IPage
     */
    IPage<SystemUser> findUserDetail(SystemUser user, QueryRequest request);

    /**
     * 新增用户
     *
     * @param user user
     */
    void createUser(SystemUser user);


    /**
     * 修改用户
     *
     * @param user user
     */
    void updateUser(SystemUser user);

    /**
     * 删除用户
     *
     * @param userIds 用户 id数组
     */
    void deleteUser(String[] userIds);

}
