package cn.tongyl.febs.fauth.configure;

import cn.tongyl.febs.common.handler.FebsAccessDeniedHandler;
import cn.tongyl.febs.common.handler.FebsAuthExceptionEntryPoint;
import cn.tongyl.febs.fauth.properties.FebsAuthProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author create by Tunyl on 2021/8/7
 * @version 1.0
 */
@Configuration
@EnableResourceServer
public class FebsResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private FebsAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private FebsAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private FebsAuthProperties febsAuthProperties;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(febsAuthProperties.getAnonUrl(),",");
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(anonUrl).permitAll()
                .antMatchers("/**")
                .authenticated();
    }

}
