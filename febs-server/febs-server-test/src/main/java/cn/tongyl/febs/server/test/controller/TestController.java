package cn.tongyl.febs.server.test.controller;

import cn.tongyl.febs.server.test.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

/**
 * @author create by Tunyl on 2021/8/8
 * @version 1.0
 */
@RestController
public class TestController {
    @Autowired
    private IHelloService helloService;

    @GetMapping("hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
    @GetMapping("test1")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String test1() {
        return "拥有'user:add'权限";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String test2() {
        return "拥有'user:update'权限";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    private void test() {
        HashMap<String, String> m = new HashMap<>();

        HashSet<Object> se = new HashSet<>();
        Vector<String> v = new Vector<>();
    }
}
