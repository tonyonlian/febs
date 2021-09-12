package cn.tongyl.febs.gateway.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author create by Tunyl on 2021/9/12
 * @version 1.0
 */

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:febs-gateway.properties"})
@ConfigurationProperties(prefix = "febs.gateway")
public class FebsGatewayProperties {
    /**
     * 禁止外部访问的URI，多个值用逗号隔开
     */
    private String forbidRequestUri;
}
