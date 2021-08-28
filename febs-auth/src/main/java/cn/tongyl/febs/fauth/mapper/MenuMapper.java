package cn.tongyl.febs.fauth.mapper;

import cn.tongyl.febs.common.entity.system.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author create by Tunyl on 2021/8/22
 * @version 1.0
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户名称查找用户信息
     * @param username 用户名称
     * @return List<Menu>
     */
    List<Menu> findUserPermissions(String username);
}
