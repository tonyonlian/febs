package cn.tongyl.febs.common.handler;

import cn.tongyl.febs.common.entity.FebsResponse;
import cn.tongyl.febs.common.exception.FebsAuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;

/**
 * @author create by Tunyl on 2021/8/15
 * @version 1.0
 */
@Slf4j
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FebsResponse handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new FebsResponse().message("系统内部错误");

    }

    @ExceptionHandler(value=FebsAuthException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public FebsResponse handleFebsAuthException(FebsAuthException e) {
        log.error("系统错误", e);
        return new FebsResponse().message(e.getMessage());
    }

    @ExceptionHandler(value= AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public FebsResponse handleAccessDeniedException() {
        return new FebsResponse().message("没有权限访问该资源");
    }
}
