package cn.tongyl.febs.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

/**
 * @author create by Tunyl on 2021/8/7
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FebsAuthUser extends User {
    private static final long serialVersionUID = -1748289340320186418L;
    private Long userId;
    private String avatar;
    private String email;
    private String mobile;
    private String sex;
    private Long deptId;
    private String roleId;
    private String roleName;
    private Date lastLoginTime;
    private String description;
    private String status;
    public FebsAuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username,password,authorities);
    }

    public FebsAuthUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
    }

}
