package cn.tongyl.febs.fauth.translator;

import cn.tongyl.febs.common.entity.FebsResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @author create by Tunyl on 2021/8/15
 * @version 1.0
 */
@Slf4j
@Component
public class FebsWebResponseExceptionTranslator implements WebResponseExceptionTranslator{
    @Override
    public ResponseEntity translate(Exception e) throws Exception {
        HttpStatus status;
        ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        FebsResponse response = new FebsResponse();
        String message = "认证失败";
        log.error(message,e.getMessage());
        if (e instanceof UnsupportedGrantTypeException) {
            message  = "不支持该认证类型";
            return bodyBuilder.body(response.message(message));
        }
        if (e instanceof InvalidGrantException) {
            if (StringUtils.containsIgnoreCase(e.getMessage(), "Invalid refresh token")) {
                message = "refresh token 无效";
                return bodyBuilder.body(response.message(message));
            }
            if (StringUtils.containsIgnoreCase(e.getMessage(), "locked")) {
                message = "用户已经锁定，请联系管理员";
                return bodyBuilder.body(response.message(message));
            }
            message = "用户名或密码错误";
            return bodyBuilder.body(response.message(message));
        }
        return bodyBuilder.body(response.message(message));
    }
}
