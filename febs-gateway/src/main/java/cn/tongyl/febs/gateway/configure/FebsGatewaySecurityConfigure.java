package cn.tongyl.febs.gateway.configure;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author create by Tunyl on 2021/8/8
 * @version 1.0
 */
@EnableWebSecurity
public class FebsGatewaySecurityConfigure extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/actuator/**").permitAll();

    }
}
