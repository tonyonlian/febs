package cn.tongyl.febs.fauth.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author create by Tunyl on 2021/8/14
 * @version 1.0
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:febs-auth.properties"})
@ConfigurationProperties(prefix = "febs.auth")
public class FebsAuthProperties {
    private FebsClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;
    /**
     * 免认证路径
     */
    private String anonUrl;

    /**
     * 验证配置类
     */
    private FebsValidateCodeProperties code = new FebsValidateCodeProperties();
}
