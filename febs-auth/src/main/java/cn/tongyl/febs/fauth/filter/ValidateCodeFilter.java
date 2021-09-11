package cn.tongyl.febs.fauth.filter;

import cn.tongyl.febs.common.entity.FebsResponse;
import cn.tongyl.febs.common.exception.ValidateCodeException;
import cn.tongyl.febs.common.utils.FebsUtil;
import cn.tongyl.febs.fauth.service.ValidateCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author create by Tunyl on 2021/9/4
 * @version 1.0
 */
@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Autowired
    private ValidateCodeService validateCodeService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        String clientId = getClientId(header, request);

        RequestMatcher matcher = new AntPathRequestMatcher("/oauth/token", HttpMethod.POST.toString());
        // 过滤了swagger的clientId，swagger用户swagger文档权限验证
        if (matcher.matches(request)
                && StringUtils.equalsIgnoreCase(request.getParameter("grant_type"), "password")
                && !StringUtils.equalsIgnoreCase(clientId, "swagger")) {
            try {
                validateCode(request);
                filterChain.doFilter(request, response);
            } catch (ValidateCodeException e) {
                FebsResponse febsResponse = new FebsResponse();
                FebsUtil.makeResponse(response, MediaType.APPLICATION_JSON_UTF8_VALUE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, febsResponse.message(e.getMessage()));
                log.info("验证码验证：{}", e.getMessage());
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }

    private String getClientId(String header, HttpServletRequest request) {
        String clientId = "";
        try {
            byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
            byte[] decoded = Base64.getDecoder().decode(base64Token);
            String token = new String(decoded, StandardCharsets.UTF_8);
            int delim = token.indexOf(":");
            if (delim != -1) {
                clientId = new String[]{token.substring(0, delim), token.substring(delim + 1)}[0];
            }
        } catch (Exception ignore) {

        }
        return clientId;
    }

    private void validateCode(HttpServletRequest request) throws ValidateCodeException {
        String key = request.getParameter("key");
        String code = request.getParameter("code");
        validateCodeService.check(key, code);
    }
}
