package com.lolixx.example.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("hello")
    public String hello() {
        return "hello spring security";
    }

    @GetMapping("index")
    public Object index() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    //    登录成功后，便可以使用SecurityContextHolder.getContext().getAuthentication()获取到Authentication对象信息。除了通过这种方式获取Authentication对象信息外，也可以使用下面这种方式:
    @GetMapping("index1")
    public Object index(Authentication authentication) {
        return authentication;
    }
}
