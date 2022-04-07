package com.lolixx.example.springsecurity.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSucessHandler implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(mapper.writeValueAsString(authentication));
//        通过上面配置，登录成功后页面将跳转回引发跳转的页面。如果想指定跳转的页面，比如跳转到/index，可以将savedRequest.getRedirectUrl()修改为/index：
        redirectStrategy.sendRedirect(request, response, "/index");
    }
}
