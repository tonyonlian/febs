package cn.tongyl.febs.fauth.configure;

import cn.tongyl.febs.fauth.filter.ValidateCodeFilter;
import cn.tongyl.febs.fauth.service.FebsUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author create by Tunyl on 2021/7/31
 * @version 1.0
 */
@Order(2)
@EnableWebSecurity
public class FebsSecurityConfigure extends WebSecurityConfigurerAdapter {
    @Autowired
    private FebsUserDetailService userDetailService;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 接下来我们需要将ValidateCodeFilter过滤器添加到Spring Security过滤器链中，并且位于UsernamePasswordAuthenticationFilter过滤器前（即校验用户名密码时先校验验证码）。
         */
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .requestMatchers()
                .antMatchers("/oauth/**")
                .antMatchers("/actuator/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .antMatchers("/actuator/**").permitAll()
                .and()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }


}
