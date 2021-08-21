package cn.tongyl.febs.common.interceptor;

import cn.tongyl.febs.common.entity.FebsConstant;
import cn.tongyl.febs.common.entity.FebsResponse;
import cn.tongyl.febs.common.utils.FebsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 检验zuul token 的拦截器k
 * @author create by Tunyl on 2021/8/21
 * @version 1.0
 */
public class FebsServerProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求头中中获取zuul token
        String token = request.getHeader(FebsConstant.ZUUL_TOKEN_HEADER);
        String zuulToken = new String(Base64Utils.decode(token.getBytes()));

        if (StringUtils.equals(FebsConstant.ZUUL_TOKEN_VALUE, zuulToken)) {
            return true;
        } else {
            FebsResponse febsResponse = new FebsResponse();
            febsResponse.message("请通网关获取资源");
            FebsUtil.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE, HttpServletResponse.SC_FORBIDDEN, febsResponse);
            return false;
        }
    }
}
