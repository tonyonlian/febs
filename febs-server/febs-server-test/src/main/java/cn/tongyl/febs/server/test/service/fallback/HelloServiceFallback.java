package cn.tongyl.febs.server.test.service.fallback;

import cn.tongyl.febs.server.test.service.IHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author create by Tunyl on 2021/8/21
 * @version 1.0
 */
@Slf4j
@Component
public class HelloServiceFallback  implements FallbackFactory<IHelloService> {

    @Override
    public IHelloService create(Throwable throwable) {
        return name->{
            log.error("调用febs-server-system服务错误",throwable);
            return "调用出错";
        };
    }
}
