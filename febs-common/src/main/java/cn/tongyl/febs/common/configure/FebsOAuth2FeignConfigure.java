package cn.tongyl.febs.common.configure;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * @author create by Tunyl on 2021/8/21
 * @version 1.0
 */
public class FebsOAuth2FeignConfigure {
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptro() {
        return requestTemplate -> {
            Object detail = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (detail instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) detail).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION,"bearer " + authorizationToken);
            }
        };
    }
}
