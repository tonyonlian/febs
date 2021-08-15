package cn.tongyl.febs.common.configure;

import cn.tongyl.febs.common.handler.FebsAccessDeniedHandler;
import cn.tongyl.febs.common.handler.FebsAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author create by Tunyl on 2021/8/15
 * @version 1.0
 */
public class FebsAuthExceptionConfigure {
    @Bean
    @ConditionalOnMissingBean(name="accessDeniedHandler")
    public FebsAccessDeniedHandler accessDeniedHandler() {
        return new FebsAccessDeniedHandler();
    }
    @Bean
    @ConditionalOnMissingBean(name="authExceptionEntryPoint")
    public FebsAuthExceptionEntryPoint authExceptionEntryPoint() {
        return new FebsAuthExceptionEntryPoint();
    }
}
