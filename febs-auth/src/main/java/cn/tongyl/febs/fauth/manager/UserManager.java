package cn.tongyl.febs.fauth.manager;

import cn.tongyl.febs.common.entity.system.Menu;
import cn.tongyl.febs.common.entity.system.SystemUser;
import cn.tongyl.febs.fauth.mapper.MenuMapper;
import cn.tongyl.febs.fauth.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author create by Tunyl on 2021/8/22
 * @version 1.0
 */
@Service
public class UserManager {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String name) {
        return userMapper.findByName(name);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);

        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
        //List<String> perms = new ArrayList<>();
        //for (Menu m : userPermissions) {
        //    perms.add(m.getPerms());
        //}
        //return StringUtils.join(perms,",");
    }
}
