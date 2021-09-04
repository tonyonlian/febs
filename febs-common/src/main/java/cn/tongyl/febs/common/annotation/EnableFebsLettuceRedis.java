package cn.tongyl.febs.common.annotation;

import cn.tongyl.febs.common.configure.FebsLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Redis的Enable注解
 *
 * @author create by Tunyl on 2021/8/29
 * @version 1.0
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FebsLettuceRedisConfigure.class)
public @interface EnableFebsLettuceRedis {
}
