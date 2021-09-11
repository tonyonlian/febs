package cn.tongyl.febs.server.system.mapper;

import cn.tongyl.febs.common.entity.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author create by Tunyl on 2021/9/5
 * @version 1.0
 */
public interface UserMapper extends BaseMapper<SystemUser> {
    IPage<SystemUser> findUserDetailPage(Page page, @Param("user") SystemUser user);
}
