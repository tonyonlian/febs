package cn.tongyl.febs.common.configure;

import cn.tongyl.febs.common.entity.FebsConstant;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

/**
 * @author create by Tunyl on 2021/8/21
 * @version 1.0
 */
public class FebsOAuth2FeignConfigure {
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptro() {
        return requestTemplate -> {
            //添加zuul token （zuul token 用来控制只能通网关zuul调用服务，防直接调用服务）
            String zuulToken = new String(Base64Utils.encode(FebsConstant.ZUUL_TOKEN_VALUE.getBytes()));
            requestTemplate.header(FebsConstant.ZUUL_TOKEN_HEADER, zuulToken);
            //feign 添加oauth token
            Object detail = SecurityContextHolder.getContext().getAuthentication().getDetails();
            if (detail instanceof OAuth2AuthenticationDetails) {
                String authorizationToken = ((OAuth2AuthenticationDetails) detail).getTokenValue();
                requestTemplate.header(HttpHeaders.AUTHORIZATION,"bearer " + authorizationToken);
            }
        };
    }
}
