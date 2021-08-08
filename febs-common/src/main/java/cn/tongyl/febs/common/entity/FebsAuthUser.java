package cn.tongyl.febs.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author create by Tunyl on 2021/8/7
 * @version 1.0
 */
@Data
public class FebsAuthUser implements Serializable {
    private static final long serialVersionUID = -1748289340320186418L;
    private String username;
    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
}
