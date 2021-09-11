package cn.tongyl.febs.server.system.properties;

import lombok.Data;

/**
 * @author create by Tunyl on 2021/9/11
 * @version 1.0
 */
@Data
public class FebsSwaggerProperties {
    private String basePackage;
    private String title;
    private String description;
    private String version;
    private String author;
    private String url;
    private String email;
    private String license;
    private String licenseUrl;
    // 认证安全使用属性
    private String grantUrl;
    private String name;
    private String scope;
}
