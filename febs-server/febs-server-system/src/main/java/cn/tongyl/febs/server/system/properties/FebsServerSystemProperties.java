package cn.tongyl.febs.server.system.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author create by Tunyl on 2021/9/11
 * @version 1.0
 */
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:febs-server-system.properties"})
@ConfigurationProperties(prefix = "febs.server.system")
public class FebsServerSystemProperties {
    /**
     * 免认证URI，多个值以逗号分隔
     */
    private String anonUrl;
    private FebsSwaggerProperties swagger = new FebsSwaggerProperties();
}
