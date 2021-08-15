package cn.tongyl.febs.server.test.configure;

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
public class FebsServerTestResourceServerConfigure extends ResourceServerConfigurerAdapter {
    @Autowired
    private FebsAuthExceptionEntryPoint exceptionEntryPoint;
    @Autowired
    private FebsAccessDeniedHandler accessDeniedHandler;

    //令牌不正常返回401，用户无权访问返回403
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(exceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
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
