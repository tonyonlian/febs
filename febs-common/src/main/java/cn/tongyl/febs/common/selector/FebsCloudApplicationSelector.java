package cn.tongyl.febs.common.selector;

import cn.tongyl.febs.common.configure.FebsAuthExceptionConfigure;
import cn.tongyl.febs.common.configure.FebsOAuth2FeignConfigure;
import cn.tongyl.febs.common.configure.FebsServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 聚合三个自定义Enable注解（@EnableFebsServerProtect,@EnableFebsOauth2FeignClient,@EnableFebsAuthExceptionHandler)
 * @author create by Tunyl on 2021/8/21
 * @version 1.0
 */

public class FebsCloudApplicationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                FebsAuthExceptionConfigure.class.getName(),
                FebsOAuth2FeignConfigure.class.getName(),
                FebsServerProtectConfigure.class.getName()
        };
    }
}
