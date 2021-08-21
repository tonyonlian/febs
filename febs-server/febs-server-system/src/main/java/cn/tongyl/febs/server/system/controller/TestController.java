package cn.tongyl.febs.server.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author create by Tunyl on 2021/8/8
 * @version 1.0
 */
@RestController
public class TestController {
    @GetMapping("info")
    public String test() {
        return "febs-sever-system";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @GetMapping("hello")
    public String hello(String name) {
        return "hello" + name;
    }


}
