package cn.tongyl.febs.fauth.configure;

import cn.tongyl.febs.fauth.properties.FebsAuthProperties;
import cn.tongyl.febs.fauth.properties.FebsClientsProperties;
import cn.tongyl.febs.fauth.service.FebsUserDetailService;
import cn.tongyl.febs.fauth.translator.FebsWebResponseExceptionTranslator;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author create by Tunyl on 2021/8/7
 * @version 1.0
 */
@Configuration
@EnableAuthorizationServer
public class FebsAuthorizationServerConfigure extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private FebsUserDetailService userDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FebsAuthProperties authProperties;
    @Autowired
    private FebsWebResponseExceptionTranslator responseExceptionTranslator;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        FebsClientsProperties[] clientsArray = authProperties.getClients();
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        if (ArrayUtils.isNotEmpty(clientsArray)) {
            for (FebsClientsProperties client : clientsArray) {
                if (StringUtils.isBlank(client.getClient())) {
                    throw new Exception("client 不能为空");
                }
                if (StringUtils.isBlank(client.getSecret())) {
                    throw new Exception("secret 不能为空");
                }
                String[] grantTypes = StringUtils.splitByWholeSeparatorPreserveAllTokens(client.getGrantType(),",");
                builder.withClient(client.getClient())
                        .secret(passwordEncoder.encode(client.getSecret()))
                        .authorizedGrantTypes(grantTypes)
                        .scopes(client.getScope());

            }
        }
    }

    @Override
    @SuppressWarnings("all")
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
       endpoints.tokenStore(tokenStore())
               .userDetailsService(userDetailService)
               .authenticationManager(authenticationManager)
               .tokenServices(defaultTokenServices())
               .exceptionTranslator(responseExceptionTranslator);
    }

    @Bean
    public TokenStore tokenStore() {
      return new RedisTokenStore(redisConnectionFactory);
    }

    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
       DefaultTokenServices tokenServices = new DefaultTokenServices();
       tokenServices.setTokenStore(tokenStore());
       tokenServices.setSupportRefreshToken(true);
       tokenServices.setAccessTokenValiditySeconds(authProperties.getAccessTokenValiditySeconds());
       tokenServices.setRefreshTokenValiditySeconds(authProperties.getRefreshTokenValiditySeconds());
       return tokenServices;
    }

}
