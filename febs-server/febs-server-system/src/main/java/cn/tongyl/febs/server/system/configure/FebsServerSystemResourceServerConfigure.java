package cn.tongyl.febs.server.system.configure;

import cn.tongyl.febs.common.handler.FebsAccessDeniedHandler;
import cn.tongyl.febs.common.handler.FebsAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author create by Tunyl on 2021/8/8
 * @version 1.0
 */
@Configuration
@EnableResourceServer
public class FebsServerSystemResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private FebsAccessDeniedHandler accessDeniedHandler;
    @Autowired
    private FebsAuthExceptionEntryPoint exceptionEntryPoint;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(exceptionEntryPoint);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }
}
