package cn.tongyl.febs.server.test.service;

import cn.tongyl.febs.common.entity.FebsServerConstant;
import cn.tongyl.febs.server.test.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author create by Tunyl on 2021/8/21
 * @version 1.0
 */
@FeignClient(value= FebsServerConstant.FEBS_SERVER_SYSTEM,contextId="helloServiceClient",fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {
    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}
