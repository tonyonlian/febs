package cn.tongyl.febs.fauth.properties;

import lombok.Data;

/**
 * @author create by Tunyl on 2021/8/14
 * @version 1.0
 */
@Data
public class FebsClientsProperties {
    private String client;
    private String secret;
    private String grantType = "password,authorization_code,refresh_token";
    private String scope = "all";
}
