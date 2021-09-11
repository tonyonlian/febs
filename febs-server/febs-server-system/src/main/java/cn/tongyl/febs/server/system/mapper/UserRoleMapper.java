package cn.tongyl.febs.server.system.mapper;

import cn.tongyl.febs.common.entity.system.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author create by Tunyl on 2021/9/5
 * @version 1.0
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 根据用户Id删除该用户的角色关系
     *
     * @param userId 用户Id
     * @return boolean
     */
    Boolean deleteByUserId(@Param("userId") Long userId);

    /**
     * 根据角色id删除该角色用户关系
     *
     * @param roleId 角色Id
     * @return boolean
     */
    Boolean deleteByRoleId(@Param("roleId") Long roleId);
}
