package cn.tongyl.febs.fauth.controller;

import cn.tongyl.febs.common.entity.FebsResponse;
import cn.tongyl.febs.common.exception.FebsAuthException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author create by Tunyl on 2021/8/7
 * @version 1.0
 */
@RestController
public class SecurityController {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;
    @RequestMapping(path="oauth/test",method = RequestMethod.GET)
    public String testOauth(){
        return "oauth";
    }
    @GetMapping("user")
    public Principal currentUser(Principal principal){
        return principal;
    }
    @DeleteMapping("signout")
    public FebsResponse signout(HttpServletRequest request) throws FebsAuthException {
        String authorization = request.getHeader("Authorization");
        String token = StringUtils.replace(authorization,"bearer ","");
        FebsResponse febsResponse = new FebsResponse();
        if (!consumerTokenServices.revokeToken(token)) {
            throw new FebsAuthException("退出登录失败");

        }
        return febsResponse.message("退出登录成功");
    }

}
